package com.tul.ecommerce.domain.port.in.shoppingcart;

import com.tul.ecommerce.domain.model.ShoppingCart;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

public interface CreateShoppingCartUseCase {

    ShoppingCart createShoppingCart(List<CreateShoppingCartCommand> createShoppingCartCommand);

    @Value
    class CreateShoppingCartCommand {
        @NotNull int quantity;
        @NotNull UUID product;

        public CreateShoppingCartCommand(@NotNull int quantity, @NotNull UUID product) {
            this.quantity = quantity;
            this.product = product;
        }
    }
}
