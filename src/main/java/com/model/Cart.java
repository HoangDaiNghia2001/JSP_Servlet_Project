/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class Cart {
    
    private List<ProductCart> lstitems;
    
    public Cart() {
        lstitems = new ArrayList<ProductCart>();
    }

    public Cart(List<ProductCart> lstitems) {
        this.lstitems = lstitems;
    }
    
    
    public List<ProductCart> getLstitems() {
        return this.lstitems;
    }
    
    public int getQuantityByIDAndBySize(int id, int size) {
        return getProductCartByIDAndBySize(id,size).getQuantity();
    }
    
    private ProductCart getProductCartByIDAndBySize(int id, int size) {
        for (ProductCart i : lstitems) {
            if (i.getProduct().getProductID() == id && i.getSize() == size) {
                return i;
            }
        }
        return null;
    }
    
    public int getQuantityByID(int id) {
        int sum =0;
        for (ProductCart i : lstitems) {
            if (i.getProduct().getProductID() == id) {
                sum += i.getQuantity();
            }
        }
        return sum;
    }

    public void addProductCart(ProductCart p, int size) {
        if (getProductCartByIDAndBySize(p.getProduct().getProductID(),size) != null ) {
            ProductCart c = getProductCartByIDAndBySize(p.getProduct().getProductID(),size);
            c.setQuantity(c.getQuantity() + p.getQuantity());
        } else {
            lstitems.add(p);
        }
    }
    
    public void removeProductCart(int id, int size) {
        if (getProductCartByIDAndBySize(id,size) != null) {
            lstitems.remove(getProductCartByIDAndBySize(id,size));
        }
    }
    
    public double getTotalMoney() {
        double total = 0;
        for (ProductCart p : lstitems) {
            total += (p.getQuantity() * p.getProduct().getProductPrice());
        }
        return total;
    }
    
    private Product getProductByID(int id, List<Product> lstProduct) {
        for (Product p : lstProduct) {
            if (p.getProductID() == id) {
                return p;
            }
        }
        return null;
    }
    
    public Cart(String txt, List<Product> list) {
        lstitems = new ArrayList<>();
        
        try {
            if (txt != null && txt.length() != 0) {
                String[] s = txt.split("/");
                for (String i : s) {
                    String[] n = i.split("_");
                    
                    int id = Integer.parseInt(n[0]);
                    int quantity = Integer.parseInt(n[1]);
                    int size = Integer.parseInt(n[2]);
                    
                    Product p = getProductByID(id, list);
                    
                    ProductCart c = new ProductCart(quantity, p, size);
                    
                    addProductCart(c, size);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
}
