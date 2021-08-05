package com.tul.ecommerce.domain.port.in.shoppingcart;

import com.tul.ecommerce.domain.model.ShoppingCart;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public interface DeleteItemShoppingCartUseCase {

    ShoppingCart deleteItem(UUID cart, UUID item);

}
