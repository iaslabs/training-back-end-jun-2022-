package com.co.ias.market.products.application.services;

import com.co.ias.market.infranstructure.models.ProductDTO;
import com.co.ias.market.products.application.ports.input.QueryProductByIdUseCase;
import org.springframework.stereotype.Service;

@Service
public class QueryProductByIdService implements QueryProductByIdUseCase {
    @Override
    public ProductDTO execute(ProductDTO productDTO) {
        return null;
    }
}
