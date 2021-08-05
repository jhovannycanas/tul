package com.tul.ecommerce.adapter.persistence;

import com.tul.ecommerce.domain.model.ShoppingCart;
import com.tul.ecommerce.domain.model.ShoppingCartItem;
import com.tul.ecommerce.domain.port.out.ShoppingCartRepository;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ShoppingCartAdapter implements ShoppingCartRepository {

    Map<UUID, ShoppingCart> shoppingCartMap = new HashMap<>();

    @Override
    public ShoppingCart createShoppingCart(List<ShoppingCartItem> shoppingCartItems) {
        UUID uuid = UUID.randomUUID();
        ShoppingCart shoppingCart  = new ShoppingCart(uuid, ShoppingCart.Status.REGISTER, 0.0, shoppingCartItems);
        shoppingCartMap.put(uuid, shoppingCart);
        return shoppingCart;
    }

    @Override
    public Optional<ShoppingCart> findById(UUID uuid) {
        return Optional.ofNullable(shoppingCartMap.get(uuid));
    }

    @Override
    public ShoppingCart addItem(UUID uuid, ShoppingCartItem shoppingCartItem) {
        ShoppingCart shoppingCart = this.shoppingCartMap.get(uuid);
        shoppingCart.getItems().add(shoppingCartItem);
        return shoppingCart;
    }

    @Override
    public ShoppingCart editItem(UUID uuid, ShoppingCartItem shoppingCartItem) {
        ShoppingCart shoppingCart = this.shoppingCartMap.get(uuid);
        ShoppingCartItem shoppingCartItem1 = shoppingCart.getItems().stream()
                .filter(shoppingCartItem2 -> shoppingCartItem2.getProductCalculate().getId()
                        .equals(shoppingCartItem.getProductCalculate().getId())).findFirst()
                .orElseThrow(()-> new RuntimeException("producto no encontrado"));
        shoppingCart.getItems().remove(shoppingCartItem1);
        shoppingCart.getItems().add(shoppingCartItem);
        return shoppingCart;
    }

    @Override
    public ShoppingCart deleteItem(UUID cart, UUID item) {
        ShoppingCart shoppingCart = this.shoppingCartMap.get(cart);
        ShoppingCartItem shoppingCartItem1 = shoppingCart.getItems().stream()
                .filter(shoppingCartItem2 -> shoppingCartItem2.getProductCalculate().getId()
                        .equals(item)).findFirst()
                .orElseThrow(()-> new RuntimeException("producto no encontrado"));
        shoppingCart.getItems().remove(shoppingCartItem1);
        return shoppingCart;
    }

    @Override
    public ShoppingCart process(UUID uuid) {
        ShoppingCart shoppingCart = this.shoppingCartMap.get(uuid);
        shoppingCart.setStatus(ShoppingCart.Status.COMPLETED);
        return shoppingCart;
    }
}
