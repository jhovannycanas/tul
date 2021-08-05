package com.tul.ecommerce.adapter.persistence;

import com.tul.ecommerce.domain.model.Product;
import com.tul.ecommerce.domain.model.ProductDiscount;
import com.tul.ecommerce.domain.model.ProductSimple;
import com.tul.ecommerce.domain.port.out.ProductRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ProductAdapter implements ProductRepository {

    private List<Product> products = new ArrayList<>();

    @PostConstruct
    public void init() {
        products.add(ProductDiscount.builder().id(UUID.randomUUID())
                .price(100.00).description("Martillo grande").name("martillo")
                .sku("000").isDiscount(Boolean.TRUE).build());
        products.add(ProductSimple.builder().id(UUID.randomUUID()).name("Cemento")
                .price(2000.0).isDiscount(Boolean.FALSE).description("Cemeneto 25 kg").sku("20000").build());
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Optional<Product> findByUuid(UUID uuid) {
        return products.stream().filter(product -> product.getId().equals(uuid))
                .findFirst();
    }

    @Override
    public Product update(Product product) {
        Product productDb = products.stream().filter( product1 -> product1.getId().equals(product.getId()))
                .findFirst().orElseThrow(()-> new RuntimeException("No se encontro producto"));
        products.remove(productDb);
        products.add(product);
        return product;
    }

    @Override
    public String delete(UUID uuid) {
        Product product = products.stream().filter(product1 -> product1.getId()
        .equals(uuid)).findFirst().orElseThrow(() -> new RuntimeException("No se encontro el prducto"));
        products.remove(product);
        return uuid.toString();
    }

    @Override
    public Product add(Product product) {
        Product productDb = null;
        if (product.isDiscount()) {
            productDb = ProductDiscount.builder().id(UUID.randomUUID())
                    .name(product.getName())
                    .description(product.getDescription())
                    .price(product.getPrice())
                    .isDiscount(product.isDiscount())
                    .sku(product.getSku())
                    .build();
            products.add(productDb);
        }
        if (!product.isDiscount()) {
            productDb = ProductSimple.builder().id(UUID.randomUUID())
                    .name(product.getName())
                    .description(product.getDescription())
                    .price(product.getPrice())
                    .isDiscount(product.isDiscount())
                    .sku(product.getSku())
                    .build();
            products.add(productDb);
        }
        return productDb;
    }
}
