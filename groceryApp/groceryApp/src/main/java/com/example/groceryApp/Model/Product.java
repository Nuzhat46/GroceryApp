package com.example.groceryApp.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String productName;

    private String description;

    private String image;

    @NotNull
    private Double sellPrice;

    @NotNull
    private Double costPrice;

    @NotNull
    private Integer stockUnit;

    // Constructors, getters, setters

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Integer getStockUnit() {
        return stockUnit;
    }

    public void setStockUnit(Integer stockUnit) {
        this.stockUnit = stockUnit;
    }
}
