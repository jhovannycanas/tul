package com.tul.ecommerce.adapter.web.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class OrderShoppingRequest {

    @JsonProperty("shopping_cart")
    private List<ShopingCartRequest> shopingCartRequests;
}
