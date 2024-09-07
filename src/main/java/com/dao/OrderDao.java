/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.connection.DBConnect;
import com.model.Cart;
import com.model.ProductCart;
import com.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class OrderDao {

    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void addOrder(User user, Cart cart, String phone , String address) {
        Date date = new Date();
        
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        
        String currentDay = String.valueOf(formater.format(date));

        try {
            connection = new DBConnect().getConnection();
            pst = connection.prepareStatement("insert into orders (Date,UserID,TotalMoney,Phone,Address) values (?,?,?,?,?)");
            pst.setString(1, currentDay);
            pst.setInt(2, user.getUserId());
            pst.setDouble(3, cart.getTotalMoney());
            pst.setString(4, phone);
            pst.setString(5, address);

            pst.executeUpdate();

        } catch (Exception e) {
        }

    }

    public int getOrderID() {
        int o_id = 0;
        try {
            connection = new DBConnect().getConnection();
            pst = connection.prepareStatement("select OrderID from orders ORDER BY OrderID DESC limit 1");
            rs = pst.executeQuery();
            if (rs.next()) {
                o_id = rs.getInt(1);
            }

            pst.executeUpdate();

        } catch (Exception e) {
        }
        return o_id;
    }

    public void createOderLine(Cart cart, int orderID) {
        try {
            connection = new DBConnect().getConnection();
            for (ProductCart pCart : cart.getLstitems()) {
                pst = connection.prepareStatement("insert into orderline (OderID,ProductID,Quantity,Price,Size) values (?,?,?,?,?)");
                pst.setInt(1, orderID);
                pst.setInt(2, pCart.getProduct().getProductID());
                pst.setInt(3, pCart.getQuantity());
                pst.setDouble(4, (pCart.getProduct().getProductPrice() * pCart.getQuantity()));
                pst.setInt(5, pCart.getSize());

                pst.executeUpdate();
            }
        } catch (Exception e) {
        }
    }

    public void updateAmountPro(Cart cart) {
        try {
            connection = new DBConnect().getConnection();
            for (ProductCart pCart : cart.getLstitems()) {
                pst = connection.prepareStatement("update product set Amount = Amount - ? where ProductID = ?");
                pst.setInt(1, pCart.getQuantity());
                pst.setInt(2, pCart.getProduct().getProductID());

                pst.executeUpdate();
            }
        } catch (Exception e) {
        }
    }
}
