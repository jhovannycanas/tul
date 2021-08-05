package com.tul.ecommerce.domain.usecase.shoppingcart;

import com.tul.ecommerce.domain.model.Product;
import com.tul.ecommerce.domain.model.ShoppingCart;
import com.tul.ecommerce.domain.model.ShoppingCartItem;
import com.tul.ecommerce.domain.port.in.shoppingcart.AddItemShoppingCartUseCase;
import com.tul.ecommerce.domain.port.in.shoppingcart.DeleteItemShoppingCartUseCase;
import com.tul.ecommerce.domain.port.out.ProductRepository;
import com.tul.ecommerce.domain.port.out.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class DeleteItemShoppingCartService implements DeleteItemShoppingCartUseCase {

    private final ProductRepository productRepository;
    private final ShoppingCartRepository shoppingCartRepository;

    @Override
    public ShoppingCart deleteItem(UUID cart, UUID item) {
        shoppingCartRepository.findById(cart).orElseThrow(() -> new RuntimeException("Carrito de compras no encontrado"));
        Product product = this.productRepository.findByUuid(item)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        return this.shoppingCartRepository.deleteItem(cart, item);
    }
}
