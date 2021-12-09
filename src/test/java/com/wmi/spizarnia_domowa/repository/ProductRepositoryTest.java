package com.wmi.spizarnia_domowa.repository;

import com.wmi.spizarnia_domowa.model.CategoryProduct;
import com.wmi.spizarnia_domowa.model.Group;
import com.wmi.spizarnia_domowa.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private CategoryProductRepository categoryProductRepository;

    private Group group;
    private String code;


    @BeforeEach
    void setUp() {
        group = new Group();
        groupRepository.save(group);
        code = group.getCode();
    }

    @Test
    void shouldGetAllProductForGroupWithoutZeroQuantity() {
        Product productZeroQuantity = new Product();
        productZeroQuantity.setGroup(group);
        productZeroQuantity.setQuantity(0);
        Product productNotZeroQuantity1 = new Product();
        productNotZeroQuantity1.setGroup(group);
        productNotZeroQuantity1.setQuantity(10);
        Product productNotZeroQuantity2 = new Product();
        productNotZeroQuantity2.setGroup(group);
        productNotZeroQuantity2.setQuantity(10);
        productRepository.save(productZeroQuantity);
        productRepository.save(productNotZeroQuantity1);
        productRepository.save(productNotZeroQuantity2);

        List<Product> productList = productRepository.getAllWithoutZero(code);

        assertEquals(2, productList.size());
    }

    @Test
    void shouldGetAllProductsSortedByCategoryProduct() {
        CategoryProduct categoryProductA = new CategoryProduct();
        categoryProductA.setName("A");
        CategoryProduct categoryProductZ = new CategoryProduct();
        categoryProductZ.setName("Z");
        categoryProductRepository.save(categoryProductA);
        categoryProductRepository.save(categoryProductZ);
        Product productCategoryFirstLetterA = new Product();
        productCategoryFirstLetterA.setCategoryProduct(categoryProductA);
        productCategoryFirstLetterA.setGroup(group);
        Product productCategoryFirstLetterZ = new Product();
        productCategoryFirstLetterZ.setCategoryProduct(categoryProductZ);
        productCategoryFirstLetterZ.setGroup(group);
        productRepository.save(productCategoryFirstLetterZ);
        productRepository.save(productCategoryFirstLetterA);

        List<Product> productList = productRepository.getAllSortedByCategoryProduct(code);

        assertEquals(productCategoryFirstLetterA.getId(), productList.get(0).getId());
        assertEquals(productCategoryFirstLetterZ.getId(), productList.get(1).getId());
    }
}