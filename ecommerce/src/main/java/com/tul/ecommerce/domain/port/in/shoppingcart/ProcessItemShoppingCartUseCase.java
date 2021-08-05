package com.tul.ecommerce.domain.port.in.shoppingcart;

import com.tul.ecommerce.domain.model.ShoppingCart;

import java.util.UUID;

public interface ProcessItemShoppingCartUseCase {

    ShoppingCart processCart(UUID uuid);
}
