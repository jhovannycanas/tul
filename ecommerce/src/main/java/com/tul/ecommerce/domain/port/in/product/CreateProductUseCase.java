package com.tul.ecommerce.domain.port.in.product;

import com.tul.ecommerce.commons.SelfValidating;
import com.tul.ecommerce.domain.model.Product;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface CreateProductUseCase {

    Product create(CreateProductCommand createProductCommand);

    @Value
    @EqualsAndHashCode(callSuper = false)
    class CreateProductCommand extends SelfValidating<CreateProductCommand> {
        @NotNull private Double price;
        @NotNull @NotEmpty private String name;
        @NotNull @NotEmpty final String description;
        @NotNull final String sku;
        @NotNull private boolean isDiscount;

        public CreateProductCommand(@NotNull Double price, @NotNull String name,
                                    @NotNull String description, @NotNull String sku, boolean isDiscount) {
            this.price = price;
            this.name = name;
            this.description = description;
            this.sku = sku;
            this.isDiscount = isDiscount;
            this.validateSelf();
        }
    }
}
