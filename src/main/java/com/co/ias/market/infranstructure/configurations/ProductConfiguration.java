package com.co.ias.market.infranstructure.configurations;

import com.co.ias.market.infranstructure.adapters.output.JPAPostgresProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfiguration {

    private final JPAProduct jpaProduct;

    public ProductConfiguration(JPAProduct jpaProduct) {
        this.jpaProduct = jpaProduct;
    }

    @Bean
    public JPAPostgresProductRepository jpaPostgresProductRepository() {
        return new JPAPostgresProductRepository(jpaProduct);
    }
}
