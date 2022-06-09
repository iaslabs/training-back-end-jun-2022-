package com.co.ias.market.products.application.ports.ouput;

import com.co.ias.market.products.application.domain.Product;
import com.co.ias.market.products.application.domain.valueObjs.ProductId;

import java.util.Optional;

public interface ProductRepository {
    void store(Product product);

    Optional<Product> get(ProductId productId);

    void update(Product product);

    Boolean delete(ProductId productId);
}
