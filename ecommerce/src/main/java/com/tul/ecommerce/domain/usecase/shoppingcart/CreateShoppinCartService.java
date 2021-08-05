package com.tul.ecommerce.domain.usecase.shoppingcart;

import com.tul.ecommerce.domain.model.Product;
import com.tul.ecommerce.domain.model.ShoppingCart;
import com.tul.ecommerce.domain.model.ShoppingCartItem;
import com.tul.ecommerce.domain.port.in.shoppingcart.CreateShoppingCartUseCase;
import com.tul.ecommerce.domain.port.out.ProductRepository;
import com.tul.ecommerce.domain.port.out.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
public class CreateShoppinCartService implements CreateShoppingCartUseCase {

    private final ProductRepository productRepository;
    private final ShoppingCartRepository shoppingCartRepository;

    @Override
    public ShoppingCart createShoppingCart(List<CreateShoppingCartCommand>createShoppingCartCommand) {

        List<ShoppingCartItem> item = new ArrayList<>();
        for (CreateShoppingCartCommand createShoppingCartCommand1:
        createShoppingCartCommand) {
            Product product = this.productRepository.findByUuid(createShoppingCartCommand1.getProduct())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            item.add(new ShoppingCartItem(product,0.0, createShoppingCartCommand1.getQuantity()));
        }

        return this.shoppingCartRepository.createShoppingCart(item);
    }
}
