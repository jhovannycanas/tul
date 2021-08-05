package com.tul.ecommerce.adapter.web;

import com.tul.ecommerce.adapter.web.request.OrderShoppingRequest;
import com.tul.ecommerce.adapter.web.request.ShopingCartRequest;
import com.tul.ecommerce.adapter.web.response.ShopingCartResponse;
import com.tul.ecommerce.domain.model.ShoppingCart;
import com.tul.ecommerce.domain.port.in.shoppingcart.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/tul/shoppings")
public class ShoppingCartController {

    private final CreateShoppingCartUseCase createShoppingCartUseCase;
    private final AddItemShoppingCartUseCase addItemShoppingCartUseCase;
    private final EditItemShoppingCartUseCase editItemShoppingCartUseCase;
    private final DeleteItemShoppingCartUseCase deleteItemShoppingCartUseCase;
    private final ProcessItemShoppingCartUseCase processItemShoppingCartUseCase;

    @PostMapping
    public ResponseEntity createShoppingCart(@Valid @RequestBody OrderShoppingRequest orderShoppingRequest) {

        List<CreateShoppingCartUseCase.CreateShoppingCartCommand> createShoppingCartCommands =
                orderShoppingRequest.getShopingCartRequests().stream()
                .map(shopingCartRequest -> new
                        CreateShoppingCartUseCase.CreateShoppingCartCommand(shopingCartRequest.getQuantity(),
                        shopingCartRequest.getProduct()))
                .collect(Collectors.toList());
        return new ResponseEntity(this.createShoppingCartUseCase.createShoppingCart(createShoppingCartCommands),
                HttpStatus.OK);
    }

    @PostMapping(value = "/add/{uuid}")
    public ResponseEntity addItem(@PathVariable("uuid") UUID uuid,
                                  @Valid @RequestBody ShopingCartRequest shopingCartRequest) {
        AddItemShoppingCartUseCase.ShoppingCartCommand shoppingCartCommand =
                new AddItemShoppingCartUseCase.ShoppingCartCommand(shopingCartRequest.getQuantity(),
                        shopingCartRequest.getProduct());
        return new ResponseEntity(this.addItemShoppingCartUseCase.addItem(uuid, shoppingCartCommand), HttpStatus.OK);
    }

    @PostMapping(value = "/edit/{uuid}")
    public ResponseEntity editItem(@PathVariable("uuid") UUID uuid,
                                  @Valid @RequestBody ShopingCartRequest shopingCartRequest) {
        AddItemShoppingCartUseCase.ShoppingCartCommand shoppingCartCommand =
                new AddItemShoppingCartUseCase.ShoppingCartCommand(shopingCartRequest.getQuantity(),
                        shopingCartRequest.getProduct());
        return new ResponseEntity(this.editItemShoppingCartUseCase.editItem(uuid, shoppingCartCommand), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{cart}/items/{item}")
    public ResponseEntity deleteItem(@PathVariable("cart") UUID cart,
                                   @PathVariable("item") UUID item) {
        return new ResponseEntity(this.deleteItemShoppingCartUseCase.deleteItem(cart, item), HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/process/{cart}")
    public ResponseEntity processItem(@PathVariable("cart") UUID cart) {
        ShoppingCart shoppingCart = this.processItemShoppingCartUseCase.processCart(cart);
        ShopingCartResponse shopingCartResponse = new ShopingCartResponse();
        shopingCartResponse.setStatus(shoppingCart.getStatus().name());
        shopingCartResponse.setId(shoppingCart.getId());
        shopingCartResponse.setTotal(shoppingCart.getTotal());
        return new ResponseEntity(shopingCartResponse, HttpStatus.OK);
    }
}
