package com.tul.ecommerce.application;

import com.tul.ecommerce.domain.port.out.ProductRepository;
import com.tul.ecommerce.domain.port.out.ShoppingCartRepository;
import com.tul.ecommerce.domain.usecase.product.CreateProductService;
import com.tul.ecommerce.domain.usecase.product.DeleteProductService;
import com.tul.ecommerce.domain.usecase.product.GetProductService;
import com.tul.ecommerce.domain.usecase.product.UpdateProductService;
import com.tul.ecommerce.domain.usecase.shoppingcart.*;
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

    @Bean
    public CreateShoppinCartService createShoppinCartService(ProductRepository productRepository,
                                                             ShoppingCartRepository shoppingCartRepository) {
        return new CreateShoppinCartService(productRepository, shoppingCartRepository);
    }

    @Bean
    public AddItemShoppingCartService addItemShoppingCartService(ProductRepository productRepository,
                                                                 ShoppingCartRepository shoppingCartRepository) {
        return new AddItemShoppingCartService(productRepository, shoppingCartRepository);
    }

    @Bean
    public EditItemShoppingCartService editItemShoppingCartService(ProductRepository productRepository,
                                                                   ShoppingCartRepository shoppingCartRepository) {
        return new EditItemShoppingCartService(productRepository, shoppingCartRepository);
    }

    @Bean
    public DeleteItemShoppingCartService deleteItemShoppingCartService(ProductRepository productRepository,
                                                              ShoppingCartRepository shoppingCartRepository) {
        return new DeleteItemShoppingCartService(productRepository, shoppingCartRepository);
    }

    @Bean
    public ProcessShopingCartService processShopingCartService(ShoppingCartRepository shoppingCartRepository) {
        return new ProcessShopingCartService(shoppingCartRepository);
    }
}
