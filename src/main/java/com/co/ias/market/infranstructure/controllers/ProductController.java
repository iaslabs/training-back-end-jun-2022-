package com.co.ias.market.infranstructure.controllers;

import com.co.ias.market.infranstructure.models.ApplicationError;
import com.co.ias.market.infranstructure.models.ProductDTO;
import com.co.ias.market.products.application.ports.input.CreateProductUseCase;
import com.co.ias.market.products.application.ports.input.QueryProductByIdUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ProductController {
    private final CreateProductUseCase  createProductUseCase;
    private final QueryProductByIdUseCase queryProductByIdUseCase;

    public ProductController(CreateProductUseCase createProductUseCase, QueryProductByIdUseCase queryProductByIdUseCase) {
        this.createProductUseCase = createProductUseCase;
        this.queryProductByIdUseCase = queryProductByIdUseCase;
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO) {
        try {
            ProductDTO productDTOOutput = createProductUseCase.execute(productDTO);
            return ResponseEntity.ok(productDTOOutput);
        } catch (NullPointerException | IllegalArgumentException e) {
            ApplicationError applicationError = new ApplicationError("InputDataValidationError", "Bad input data",
                    Map.of("error", e.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(applicationError);
        } catch (Exception e) {
            ApplicationError applicationError = new ApplicationError("SystemError", "Try more later", Map.of());
            System.out.println("Error......: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(applicationError);
        }
    }

}
