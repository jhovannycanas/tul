package com.tul.ecommerce.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = false)
public class ProductDiscount extends Product {

    @Override
    public double commercialPrice() {
        return this.getPrice() / 2;
    }
}
