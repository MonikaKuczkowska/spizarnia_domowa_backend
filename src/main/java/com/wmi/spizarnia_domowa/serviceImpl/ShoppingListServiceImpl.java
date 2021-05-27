package com.wmi.spizarnia_domowa.serviceImpl;

import com.wmi.spizarnia_domowa.model.ShoppingList;
import com.wmi.spizarnia_domowa.repository.ShoppingListRepository;
import com.wmi.spizarnia_domowa.service.ShoppingListService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShoppingListServiceImpl implements ShoppingListService {
    private final ShoppingListRepository shoppingListRepository;


    @Override
    public List<ShoppingList> getAll() {
        return shoppingListRepository.findAll();
    }

    @Override
    public ShoppingList save(ShoppingList shoppingList) {
        return shoppingListRepository.save(shoppingList);
    }
}
