package com.co.ias.market.infranstructure.controllers;

import com.co.ias.market.infranstructure.models.ApplicationError;
import com.co.ias.market.infranstructure.models.ProductDTO;
import com.co.ias.market.products.application.ports.input.CreateProductUseCase;
import com.co.ias.market.products.application.ports.input.DeleteProductUseCase;
import com.co.ias.market.products.application.ports.input.QueryProductByIdUseCase;
import com.co.ias.market.products.application.ports.input.UpdateProductUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class ProductController {
    private final CreateProductUseCase  createProductUseCase;
    private final QueryProductByIdUseCase queryProductByIdUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;

    public ProductController(CreateProductUseCase createProductUseCase, QueryProductByIdUseCase queryProductByIdUseCase, UpdateProductUseCase updateProductUseCase, DeleteProductUseCase deleteProductUseCase) {
        this.createProductUseCase = createProductUseCase;
        this.queryProductByIdUseCase = queryProductByIdUseCase;
        this.updateProductUseCase = updateProductUseCase;
        this.deleteProductUseCase = deleteProductUseCase;
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO) {
        try {
            ProductDTO productDTOOutput = createProductUseCase.execute(productDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(productDTOOutput);
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

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getProductById(@PathVariable("id") Long id) {
        try {
            Optional<ProductDTO> productDTO = queryProductByIdUseCase.execute(id);
            if (productDTO.isPresent()) {
                return ResponseEntity.ok(productDTO.get());
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No exist product with this id");
            }
        } catch (NullPointerException | IllegalArgumentException exception) {
            ApplicationError applicationError = new ApplicationError("InpuDataValidationError", "Bad input data",
                    Map.of("error", exception.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(applicationError);
        } catch (Exception exception) {
            ApplicationError applicationError = new ApplicationError("SystemError", "Try more later", Map.of());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(applicationError);
        }

    }

    @RequestMapping(value = "/products", method = RequestMethod.PUT)
    public ResponseEntity<?> updateProduct(@RequestBody ProductDTO productDTO) {
        try {
            ProductDTO productDTOOutput = updateProductUseCase.execute(productDTO);
            return ResponseEntity.ok(productDTOOutput);
        } catch (NullPointerException | IllegalArgumentException exception) {
            ApplicationError applicationError = new ApplicationError("InpuDataValidationError", "Bad input data",
                    Map.of("error", exception.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(applicationError);
        } catch (Exception exception) {
            ApplicationError applicationError = new ApplicationError("SystemError", "Try more later", Map.of());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(applicationError);
        }
    }

    @RequestMapping(value="/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        try {
            Boolean result = deleteProductUseCase.execute(id);
            if (result) {
                return ResponseEntity.ok("Deleted");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product can not be deleted");
            }
        } catch (NullPointerException | IllegalArgumentException exception) {
            ApplicationError applicationError = new ApplicationError("InpuDataValidationError", "Bad input data",
                    Map.of("error", exception.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(applicationError);
        } catch (Exception exception) {
            ApplicationError applicationError = new ApplicationError("SystemError", "Try more later", Map.of());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(applicationError);
        }
    }

}
