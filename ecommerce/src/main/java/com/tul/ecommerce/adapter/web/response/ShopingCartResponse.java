package com.tul.ecommerce.adapter.web.response;

import lombok.Data;

import java.util.UUID;

@Data
public class ShopingCartResponse {

    private UUID id;
    private String status;
    private Double total;
}
