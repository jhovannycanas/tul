package com.tul.ecommerce.domain.usecase.product;

import com.tul.ecommerce.domain.model.Product;
import com.tul.ecommerce.domain.port.in.product.CreateProductUseCase;
import com.tul.ecommerce.domain.port.out.ProductRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateProductService implements CreateProductUseCase {

    private final ProductRepository productRepository;

    @Override
    public Product create(CreateProductCommand createProductCommand) {
        Product product = Product.builder().isDiscount(createProductCommand.isDiscount())
                .description(createProductCommand.getDescription())
                .name(createProductCommand.getName())
                .price(createProductCommand.getPrice())
                .sku(createProductCommand.getSku()).build();
        return productRepository.add(product);
    }
}
