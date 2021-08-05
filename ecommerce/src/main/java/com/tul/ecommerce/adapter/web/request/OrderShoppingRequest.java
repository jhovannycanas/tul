package com.tul.ecommerce.adapter.web.request;

import lombok.Data;

import java.util.List;

@Data
public class OrderShoppingRequest {

    private List<ShopingCartRequest> shopingCartRequests;
}
