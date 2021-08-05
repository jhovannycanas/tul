package com.tul.ecommerce.adapter.persistence;

import com.tul.ecommerce.domain.model.ShoppingCart;
import com.tul.ecommerce.domain.model.ShoppingCartItem;
import com.tul.ecommerce.domain.port.out.ShoppingCartRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
}
