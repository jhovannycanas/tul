package com.tul.ecommerce.domain.model;

import lombok.Data;
import lombok.Value;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@SuperBuilder(toBuilder = true)
public class Product implements ProductCalculate{

    private final UUID id;
    private final String name;
    private final String description;
    private final Double price;
    private final String sku;
    private final boolean isDiscount;

    @Override
    public double commercialPrice() {
        return this.getPrice();
    }
}
