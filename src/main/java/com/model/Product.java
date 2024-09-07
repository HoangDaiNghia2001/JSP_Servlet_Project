/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import com.dao.BrandDao;

/**
 *
 * @author Administrator
 */
public class Product {

    private int productID;
    private String productName;
    private String productDescrip;
    private double productPrice;
    private String imageLink;
    private int productAmout;
    private int cID;

    public Product() {
    }

    public Product(int productID, String productName, String productDescrip, double productPrice, String imageLink) {
        this.productID = productID;
        this.productName = productName;
        this.productDescrip = productDescrip;
        this.productPrice = productPrice;
        this.imageLink = imageLink;
    }

    public Product(int productID, String productName, String productDescrip, double productPrice, String imageLink, int cID) {
        this.productID = productID;
        this.productName = productName;
        this.productDescrip = productDescrip;
        this.productPrice = productPrice;
        this.imageLink = imageLink;
        this.cID = cID;
    }

    public Product(int productID, String productName, double productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    
    
    public Product(int productID, String productName, String productDescrip, double productPrice, String imageLink, int cID, int productAmout) {
        this.productID = productID;
        this.productName = productName;
        this.productDescrip = productDescrip;
        this.productPrice = productPrice;
        this.imageLink = imageLink;
        this.cID = cID;
        this.productAmout = productAmout;
    }

    public int getcID() {
        return cID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescrip() {
        return productDescrip;
    }

    public void setProductDescrip(String productDescrip) {
        this.productDescrip = productDescrip;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public int getProductAmout() {
        return productAmout;
    }

    public void setProductAmout(int productAmout) {
        this.productAmout = productAmout;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName + ", productDescrip=" + productDescrip + ", productPrice=" + productPrice + ", imageLink=" + imageLink + ", productAmout=" + productAmout + '}';
    }

    public String getBrandName(int proID) {
        BrandDao bDao = new BrandDao();
        String brandName = bDao.getBrandByIDProduct(proID);
        return brandName;
    }
}
