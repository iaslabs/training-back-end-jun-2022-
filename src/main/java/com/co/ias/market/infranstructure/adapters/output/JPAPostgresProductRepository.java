package com.co.ias.market.infranstructure.adapters.output;

import com.co.ias.market.infranstructure.configurations.JPAProduct;
import com.co.ias.market.infranstructure.models.ProductDAO;
import com.co.ias.market.products.application.domain.Product;
import com.co.ias.market.products.application.domain.valueObjs.ProductId;
import com.co.ias.market.products.application.ports.ouput.ProductRepository;

import java.util.Optional;

public class JPAPostgresProductRepository implements ProductRepository {

    private final JPAProduct jpaProduct;

    public JPAPostgresProductRepository(JPAProduct jpaProduct) {
        this.jpaProduct = jpaProduct;
    }

    @Override
    public void store(Product product) {
        ProductDAO p = ProductDAO.fromDomain(product);
        this.jpaProduct.save(p);
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
