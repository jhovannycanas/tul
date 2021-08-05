package com.tul.ecommerce.domain.port.in.shoppingcart;

import com.tul.ecommerce.domain.model.ShoppingCart;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public interface EditItemShoppingCartUseCase {

    ShoppingCart editItem(UUID id, AddItemShoppingCartUseCase.ShoppingCartCommand shoppingCartCommand);

    @Value
    class ShoppingCartCommand {
        @NotNull int quantity;
        @NotNull UUID product;

        public ShoppingCartCommand(@NotNull int quantity, @NotNull UUID product) {
            this.quantity = quantity;
            this.product = product;
        }
    }
}
