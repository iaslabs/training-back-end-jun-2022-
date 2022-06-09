package com.co.ias.market;

import com.co.ias.market.infranstructure.models.ProductDTO;
import com.co.ias.market.products.application.domain.*;
import com.co.ias.market.products.application.domain.valueObjs.ProductDescription;
import com.co.ias.market.products.application.domain.valueObjs.ProductId;
import com.co.ias.market.products.application.domain.valueObjs.ProductName;
import com.co.ias.market.products.application.domain.valueObjs.ProductPrice;

public class test {
    public static void main(String[] args) {
        try {
            Product product = new Product(
                    new ProductId(1L),
                    new ProductName("Headphones"),
                    new ProductPrice(1000000000),
                    new ProductDescription("Description") );
            System.out.println(product.toString());

        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        ProductDTO productDTO = new ProductDTO(1L, "headphone", 100, "description");
        Product product = productDTO.toDomain();
        System.out.println("dto example" + product);

        ProductDTO productDTO1 = ProductDTO.fromDomain(product);
        System.out.println("from domain" + productDTO1);
    }
}
