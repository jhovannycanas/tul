package com.tul.ecommerce.domain.usecase.shoppingcart;

import com.tul.ecommerce.domain.model.Product;
import com.tul.ecommerce.domain.model.ShoppingCart;
import com.tul.ecommerce.domain.model.ShoppingCartItem;
import com.tul.ecommerce.domain.port.in.shoppingcart.AddItemShoppingCartUseCase;
import com.tul.ecommerce.domain.port.in.shoppingcart.EditItemShoppingCartUseCase;
import com.tul.ecommerce.domain.port.out.ProductRepository;
import com.tul.ecommerce.domain.port.out.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class EditItemShoppingCartService implements EditItemShoppingCartUseCase {

    private final ProductRepository productRepository;
    private final ShoppingCartRepository shoppingCartRepository;

    @Override
    public ShoppingCart editItem(UUID id, AddItemShoppingCartUseCase.ShoppingCartCommand shoppingCartCommand) {
        shoppingCartRepository.findById(id).orElseThrow(() -> new RuntimeException("Carrito de compras no encontrado"));
        Product product = this.productRepository.findByUuid(shoppingCartCommand.getProduct())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem(product, 0.0,
                shoppingCartCommand.getQuantity());
        return shoppingCartRepository.editItem(id, shoppingCartItem);
    }
}
