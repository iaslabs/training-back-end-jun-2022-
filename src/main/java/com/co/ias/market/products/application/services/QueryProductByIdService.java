package com.co.ias.market.products.application.services;

import com.co.ias.market.infranstructure.models.ProductDTO;
import com.co.ias.market.products.application.domain.Product;
import com.co.ias.market.products.application.domain.valueObjs.ProductId;
import com.co.ias.market.products.application.ports.input.QueryProductByIdUseCase;
import com.co.ias.market.products.application.ports.ouput.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QueryProductByIdService implements QueryProductByIdUseCase {


    private final ProductRepository productRepository;

    public QueryProductByIdService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<ProductDTO> execute(Long id) {

        ProductId productId = new ProductId(id);

        Optional<Product> productOptional = productRepository.get(productId);

        return productOptional.map(product -> {
            ProductDTO productDTO = ProductDTO.fromDomain(product);
            return productDTO;
        });
    }
}
