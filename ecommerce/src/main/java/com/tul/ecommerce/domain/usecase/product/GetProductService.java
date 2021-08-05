package com.tul.ecommerce.domain.usecase.product;

import com.tul.ecommerce.domain.model.Product;
import com.tul.ecommerce.domain.model.ProductCalculate;
import com.tul.ecommerce.domain.port.in.product.GetProductUseCase;
import com.tul.ecommerce.domain.port.out.ProductRepository;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RequiredArgsConstructor
public class GetProductService implements GetProductUseCase {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.getAll();
    }
}
