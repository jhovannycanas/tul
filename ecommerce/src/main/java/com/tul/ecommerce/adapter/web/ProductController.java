package com.tul.ecommerce.adapter.web;

import com.tul.ecommerce.adapter.web.request.ProductRequest;
import com.tul.ecommerce.domain.port.in.product.CreateProductUseCase;
import com.tul.ecommerce.domain.port.in.product.DeleteProductUseCase;
import com.tul.ecommerce.domain.port.in.product.GetProductUseCase;
import com.tul.ecommerce.domain.port.in.product.UpdateProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/tul/products")
public class ProductController {

    private final GetProductUseCase getProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;
    private final CreateProductUseCase createProductUseCase;

    @GetMapping
    public ResponseEntity getAllProducts() {
        return new ResponseEntity(getProductUseCase.getAllProduct(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createProduct(@Valid ProductRequest productRequest) {
        CreateProductUseCase.CreateProductCommand createProductCommand =
                new CreateProductUseCase.CreateProductCommand(productRequest.getPrice(), productRequest.getName(),
                        productRequest.getDescription(), productRequest.getSku(), productRequest.isDiscount());

        return new ResponseEntity(createProductUseCase.create(createProductCommand), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity deleteProduct(@PathVariable UUID uuid) {
        deleteProductUseCase.delete(uuid);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PatchMapping
    public ResponseEntity updateProduct(@PathVariable UUID uuid,@Valid ProductRequest productRequest) {
        UpdateProductUseCase.ProductCommand productCommand = new UpdateProductUseCase.
                ProductCommand(productRequest.getPrice(), productRequest.getName(),
                productRequest.getDescription(), productRequest.getSku(), productRequest.isDiscount());
        UpdateProductUseCase.UpdateCommand updateCommand = new UpdateProductUseCase.UpdateCommand(uuid, productCommand);
        updateProductUseCase.update(updateCommand);
        return new ResponseEntity(HttpStatus.OK);
    }
}
