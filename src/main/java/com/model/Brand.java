/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

/**
 *
 * @author Administrator
 */
public class Brand {
    private int brandID;
    private String brandName ;
    private int amountProduct;
    
    public Brand() {
    }

    
    public Brand(int brandID, String brandName) {
        this.brandID = brandID;
        this.brandName = brandName;
    }

    public Brand(int brandID, String brandName, int amountProduct) {
        this.brandID = brandID;
        this.brandName = brandName;
        this.amountProduct = amountProduct;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getAmountProduct() {
        return amountProduct;
    }

    public void setAmountProduct(int amountProduct) {
        this.amountProduct = amountProduct;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Brand{");
        sb.append("brandID=").append(brandID);
        sb.append(", brandName=").append(brandName);
        sb.append('}');
        return sb.toString();
    }

    
}
