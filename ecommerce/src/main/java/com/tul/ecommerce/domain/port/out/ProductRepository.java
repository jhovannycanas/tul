package com.tul.ecommerce.domain.port.out;

import com.tul.ecommerce.domain.model.Product;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {

    List<Product> getAll();

    Optional<Product> findByUuid(UUID uuid);

    Product update(Product product);

    String delete(UUID uuid);

    Product add(Product product);
}
