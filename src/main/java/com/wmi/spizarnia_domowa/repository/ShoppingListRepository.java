package com.wmi.spizarnia_domowa.repository;

import com.wmi.spizarnia_domowa.model.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingList, UUID> {

    @Query(value = "select * from shopping_list\n" +
            "join product on shopping_list.product_id = product.id\n" +
            "join category_shopping on product.category_shopping_id = category_shopping.id\n" +
            "order by category_shopping.name;", nativeQuery = true)
    List<ShoppingList> getAllSortedByCategoryShopping();
}
