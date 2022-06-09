package com.co.ias.market.infranstructure.adapters.output;

import com.co.ias.market.products.application.domain.Product;
import com.co.ias.market.products.application.domain.valueObjs.ProductId;
import com.co.ias.market.products.application.ports.ouput.ProductRepository;

import java.util.Optional;


public class MongoDbProductRepository implements ProductRepository {
    @Override
    public void store(Product product) {

    }

    @Override
    public Optional<Product> get(ProductId productId) {
        return Optional.empty();
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public Boolean delete(ProductId productId) {
        return null;
    }
}
