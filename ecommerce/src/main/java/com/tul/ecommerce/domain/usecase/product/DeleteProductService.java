package com.tul.ecommerce.domain.usecase.product;

import com.tul.ecommerce.domain.port.in.product.DeleteProductUseCase;
import com.tul.ecommerce.domain.port.out.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;


@RequiredArgsConstructor
public class DeleteProductService implements DeleteProductUseCase {

    private final ProductRepository productRepository;

    @Override
    public void delete(UUID uuid) {
        this.productRepository.delete(uuid);
    }
}
