package com.tul.ecommerce.adapter.web.request;

import lombok.Data;

import java.util.UUID;

@Data
public class ShopingCartRequest {

    private int quiantity;
    private UUID product;
}
