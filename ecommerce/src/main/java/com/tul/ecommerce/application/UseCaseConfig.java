package com.tul.ecommerce.application;

import com.tul.ecommerce.domain.port.out.ProductRepository;
import com.tul.ecommerce.domain.usecase.product.CreateProductService;
import com.tul.ecommerce.domain.usecase.product.DeleteProductService;
import com.tul.ecommerce.domain.usecase.product.GetProductService;
import com.tul.ecommerce.domain.usecase.product.UpdateProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public GetProductService getProductService(ProductRepository productRepository) {
        return new GetProductService(productRepository);
    }

    @Bean
    public UpdateProductService updateProductService(ProductRepository productRepository) {
        return new UpdateProductService(productRepository);
    }

    @Bean
    public CreateProductService createProductService(ProductRepository productRepository) {
        return new CreateProductService(productRepository);
    }

    @Bean
    public DeleteProductService deleteProductService(ProductRepository productRepository) {
        return new DeleteProductService(productRepository);
    }
}
