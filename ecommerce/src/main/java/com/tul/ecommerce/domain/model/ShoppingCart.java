package com.tul.ecommerce.domain.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {

    private UUID id;
    private Status status;
    private Double total;
    private List<ShoppingCartItem> items;

    public enum Status {
        COMPLETED,
        CANCEL,
        REGISTER
    }

    public Double getTotal() {
        this.total = this.items.stream().map(ShoppingCartItem::getSubTotal)
                .collect(Collectors.summingDouble(value -> value.doubleValue()));
        return this.total;
    }
}
