package com.tul.ecommerce.domain.port.in.product;

import java.util.UUID;

public interface DeleteProductUseCase {

    void delete(UUID uuid);
}
