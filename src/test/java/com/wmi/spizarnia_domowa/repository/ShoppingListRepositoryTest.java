package com.wmi.spizarnia_domowa.repository;

import com.wmi.spizarnia_domowa.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ShoppingListRepositoryTest {

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private CategoryShoppingRepository categoryShoppingRepository;

    @Autowired
    private ProductRepository productRepository;

    private Group group;
    private String code;


    @BeforeEach
    void setUp() {
        group = new Group();
        groupRepository.save(group);
        code = group.getCode();
    }

    @Test
    void shouldGetAllProductFromShoppingListSortedByCategoryShopping() {
        CategoryShopping categoryShoppingA = new CategoryShopping();
        categoryShoppingA.setName("A");
        CategoryShopping categoryShoppingZ = new CategoryShopping();
        categoryShoppingZ.setName("Z");
        categoryShoppingRepository.save(categoryShoppingA);
        categoryShoppingRepository.save(categoryShoppingZ);
        Product productShoppingCategoryFirstLetterA = new Product();
        productShoppingCategoryFirstLetterA.setCategoryShopping(categoryShoppingA);
        productShoppingCategoryFirstLetterA.setGroup(group);
        Product productShoppingCategoryFirstLetterZ = new Product();
        productShoppingCategoryFirstLetterZ.setCategoryShopping(categoryShoppingZ);
        productShoppingCategoryFirstLetterZ.setGroup(group);
        productRepository.save(productShoppingCategoryFirstLetterA);
        productRepository.save(productShoppingCategoryFirstLetterZ);

        ShoppingList shoppingListA = new ShoppingList();
        shoppingListA.setProduct(productShoppingCategoryFirstLetterA);
        shoppingListA.setGroup(group);
        ShoppingList shoppingListZ = new ShoppingList();
        shoppingListZ.setProduct(productShoppingCategoryFirstLetterZ);
        shoppingListZ.setGroup(group);
        shoppingListRepository.save(shoppingListZ);
        shoppingListRepository.save(shoppingListA);

        List<ShoppingList> shoppingList = shoppingListRepository.getAllSortedByCategoryShopping(code);

        assertEquals(shoppingListA.getId(), shoppingList.get(0).getId());
        assertEquals(shoppingListZ.getId(), shoppingList.get(1).getId());
    }
}