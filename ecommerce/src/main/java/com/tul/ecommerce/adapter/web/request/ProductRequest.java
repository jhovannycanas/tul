package com.tul.ecommerce.adapter.web.request;

import lombok.Data;

@Data
public class ProductRequest {

    private Double price;
    private String name;
    private String description;
    private String sku;
    private boolean isDiscount;
}
