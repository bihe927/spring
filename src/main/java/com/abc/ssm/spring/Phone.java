package com.abc.ssm.spring;

import java.math.BigDecimal;

public class Phone {
    private String brand;
    private BigDecimal price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
