package com.tul.ecommerce.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartItem {

    private Product productCalculate;
    private Double subTotal;
    private int quantity;

    public Double getSubTotal() {
        return this.productCalculate.commercialPrice() * quantity;
    }
}
