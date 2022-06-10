package com.co.ias.market.products.application.services;

import com.co.ias.market.infranstructure.models.ProductDTO;
import com.co.ias.market.products.application.domain.Product;
import com.co.ias.market.products.application.ports.input.UpdateProductUseCase;
import com.co.ias.market.products.application.ports.ouput.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateProductService implements UpdateProductUseCase {

    private final ProductRepository productRepository;

    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO execute(ProductDTO productDTO) {

        Product product = productDTO.toDomain();

        Optional<Product> productBD = productRepository.get(product.getId());

        if(productBD.isPresent()) {
            productRepository.update(product);
            productDTO.setStatus("Updated");
        } else {
            productDTO.setStatus("No Updated");
        }
        return productDTO;
    }
}
