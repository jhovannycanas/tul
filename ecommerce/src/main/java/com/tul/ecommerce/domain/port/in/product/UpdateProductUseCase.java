package com.tul.ecommerce.domain.port.in.product;

import com.tul.ecommerce.commons.SelfValidating;
import com.tul.ecommerce.domain.model.Product;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public interface UpdateProductUseCase {

    Product update(UpdateCommand updateCommand);


    @Value
    @EqualsAndHashCode(callSuper = false)
    class UpdateCommand {
        @NotNull UUID ID;
        ProductCommand productCommand;

        public UpdateCommand(@NotNull UUID ID, ProductCommand productCommand) {
            this.ID = ID;
            this.productCommand = productCommand;
        }
    }


    @Value
    @EqualsAndHashCode(callSuper = false)
    class ProductCommand extends SelfValidating<ProductCommand> {
        @NotNull Double price;
        @NotNull String name;
        @NotNull String description;
        @NotNull String sku;
        @NotNull boolean isDiscount;

        public ProductCommand(@NotNull Double price, @NotNull String name,
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
