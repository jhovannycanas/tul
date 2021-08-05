package com.tul.ecommerce.domain.port.in.product;

import com.tul.ecommerce.domain.model.Product;

import java.util.List;

public interface GetProductUseCase {

    List<Product> getAllProduct();
}
