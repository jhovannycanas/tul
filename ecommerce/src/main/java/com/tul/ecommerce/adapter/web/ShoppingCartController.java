package com.tul.ecommerce.adapter.web;

import com.tul.ecommerce.adapter.web.request.OrderShoppingRequest;
import com.tul.ecommerce.domain.port.in.shoppingcart.CreateShoppingCartUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/tul/shoppings")
public class ShoppingCartController {

    private final CreateShoppingCartUseCase createShoppingCartUseCase;

    @PostMapping
    public ResponseEntity createShoppingCart(@Valid @RequestBody OrderShoppingRequest orderShoppingRequest) {

        List<CreateShoppingCartUseCase.CreateShoppingCartCommand> createShoppingCartCommands =
                orderShoppingRequest.getShopingCartRequests().stream()
                .map(shopingCartRequest -> new
                        CreateShoppingCartUseCase.CreateShoppingCartCommand(shopingCartRequest.getQuiantity(),
                        shopingCartRequest.getProduct()))
                .collect(Collectors.toList());
        return new ResponseEntity(this.createShoppingCartUseCase.createShoppingCart(createShoppingCartCommands),
                HttpStatus.OK);

    }

}
