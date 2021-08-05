package com.tul.ecommerce.domain.port.out;

import com.tul.ecommerce.domain.model.ShoppingCart;
import com.tul.ecommerce.domain.model.ShoppingCartItem;

import java.util.List;

public interface ShoppingCartRepository {

    ShoppingCart createShoppingCart(List<ShoppingCartItem> shoppingCartItems);
}
