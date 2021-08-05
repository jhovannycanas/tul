package com.tul.ecommerce.domain.port.out;

import com.tul.ecommerce.domain.model.ShoppingCart;
import com.tul.ecommerce.domain.model.ShoppingCartItem;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ShoppingCartRepository {

    ShoppingCart createShoppingCart(List<ShoppingCartItem> shoppingCartItems);

    Optional<ShoppingCart> findById(UUID uuid);

    ShoppingCart addItem(UUID uuid, ShoppingCartItem shoppingCartItem);

    ShoppingCart editItem(UUID uuid, ShoppingCartItem shoppingCartItem);

    ShoppingCart deleteItem(UUID cart, UUID item);

    ShoppingCart process(UUID uuid);
}
