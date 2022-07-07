package com.co.ias.market.infranstructure.configurations;

import com.co.ias.market.infranstructure.models.ProductDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAProduct extends CrudRepository<ProductDAO, Long> {
}
