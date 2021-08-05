package com.tul.ecommerce.domain.usecase.shoppingcart;

import com.tul.ecommerce.domain.model.ShoppingCart;
import com.tul.ecommerce.domain.port.in.shoppingcart.ProcessItemShoppingCartUseCase;
import com.tul.ecommerce.domain.port.out.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class ProcessShopingCartService implements ProcessItemShoppingCartUseCase {
    private final ShoppingCartRepository shoppingCartRepository;

    @Override
    public ShoppingCart processCart(UUID uuid) {
        shoppingCartRepository.findById(uuid).orElseThrow(() -> new RuntimeException("Carrito de compras no encontrado"));
        return shoppingCartRepository.process(uuid);
    }
}
