package com.co.ias.market.infranstructure.models;

import com.co.ias.market.products.application.domain.Product;
import com.co.ias.market.products.application.domain.valueObjs.ProductDescription;
import com.co.ias.market.products.application.domain.valueObjs.ProductId;
import com.co.ias.market.products.application.domain.valueObjs.ProductName;
import com.co.ias.market.products.application.domain.valueObjs.ProductPrice;

public class ProductDTO {
    private Long productId;
    private String name;
    private Integer price;
    private String description;
    private String status;

    public ProductDTO(Long productId, String name, Integer price, String description) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Product toDomain() {
        return new Product(
                new ProductId(productId),
                new ProductName(name),
                new ProductPrice(price),
                new ProductDescription(description)
        );
    }

    public static ProductDTO fromDomain(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getId().getValue());
        productDTO.setName(product.getName().getValue());
        productDTO.setPrice(product.getPrice().getValue());
        productDTO.setDescription(product.getDescription().getValue());
        return productDTO;
    }

    public ProductDTO() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
