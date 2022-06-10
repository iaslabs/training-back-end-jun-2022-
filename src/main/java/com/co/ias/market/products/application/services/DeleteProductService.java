package com.co.ias.market.products.application.services;

import com.co.ias.market.products.application.domain.Product;
import com.co.ias.market.products.application.domain.valueObjs.ProductId;
import com.co.ias.market.products.application.ports.input.DeleteProductUseCase;
import com.co.ias.market.products.application.ports.ouput.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteProductService implements DeleteProductUseCase {

    private final ProductRepository productRepository;

    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Boolean execute(Long id) {

        ProductId productId = new ProductId(id);

        Optional<Product> product = productRepository.get(productId);

        if (product.isPresent()) {
            productRepository.delete(productId);
        }

        return product.isPresent();
    }
}
