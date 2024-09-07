/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import com.dao.ProductDao;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class OrderDetail {
    private int pID;
    private int pAmount;
    private double pPrice;
//    private int pSize;

    public OrderDetail(int pID, int pAmount, double pPrice) {
        this.pID = pID;
        this.pAmount = pAmount;
        this.pPrice = pPrice;
    }

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public int getpAmount() {
        return pAmount;
    }

    public void setpAmount(int pAmount) {
        this.pAmount = pAmount;
    }

    public double getpPrice() {
        return pPrice;
    }

    public void setpPrice(double pPrice) {
        this.pPrice = pPrice;
    }
    
    public String getNameOfProduct(int pID){
        String name ="Null";
        ProductDao pDao = new ProductDao();
        List<Product> lst = pDao.getAllProducts();
        for (Product product : lst) {
            if(product.getProductID() == pID)
            {
                name = product.getProductName();
                break;
            }
        }
        return name;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "pID=" + pID + ", pAmount=" + pAmount + ", pPrice=" + pPrice +'}';
    }
    
}
