package com.tul.ecommerce.domain.usecase.product;

import com.tul.ecommerce.domain.model.Product;
import com.tul.ecommerce.domain.model.ProductCalculate;
import com.tul.ecommerce.domain.port.in.product.UpdateProductUseCase;
import com.tul.ecommerce.domain.port.out.ProductRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateProductService implements UpdateProductUseCase {

    private final ProductRepository productRepository;

    @Override
    public Product update(UpdateCommand updateCommand) {
        this.productRepository.findByUuid(updateCommand.getID())
                .orElseThrow(()->
                        new IllegalArgumentException("No se encontro prodcuto con el id:" + updateCommand.getID()));

        Product product = Product.builder().id(updateCommand.getID())
                .name(updateCommand.getProductCommand().getName())
                .description(updateCommand.getProductCommand().getDescription())
                .isDiscount(updateCommand.getProductCommand().isDiscount())
                .sku(updateCommand.getProductCommand().getSku())
                .price(updateCommand.getProductCommand().getPrice())
                .build();

        return this.productRepository.update(product);
    }
}
