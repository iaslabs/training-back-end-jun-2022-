package com.co.ias.market.products.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class ProductDescription {
    private final String value;

    public ProductDescription(String value) {
        if (value != null) {
            Validate.isTrue(value.length() <= 40, "Product description can not be longer than 40 characters");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
