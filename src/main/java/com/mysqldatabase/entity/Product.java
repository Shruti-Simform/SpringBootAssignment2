package com.mysqldatabase.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private String sellerName;
    private double productPrice;

    public Product() {
    }

    public Product(String productName, String sellerName, double productPrice) {
        this.productName = productName;
        this.sellerName = sellerName;
        this.productPrice = productPrice;
    }

    public Product(int productId, String productName, String sellerName, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.sellerName = sellerName;
        this.productPrice = productPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", sellerName='" + sellerName + '\'' +
                ", productPrice=" + productPrice;
    }
}
