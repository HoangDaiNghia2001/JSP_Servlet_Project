/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.connection.DBConnect;
import com.model.OrderDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class RevenueDao {

    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public List<OrderDetail> getOrderDetail() {
        List<OrderDetail> lst = new ArrayList<OrderDetail>();
        try {
            connection = new DBConnect().getConnection();
            pst = connection.prepareStatement("select ProductID from orderline group by ProductID");
            rs = pst.executeQuery();

            while (rs.next()) {

                lst.add(new OrderDetail(rs.getInt(1), 0, 0));
            }
        } catch (Exception e) {
        }
        return lst;
    }

    public int getAmountProductById(int id) {
        int amount = 0;
        try {
            connection = new DBConnect().getConnection();
            pst = connection.prepareStatement("SELECT  sum(Quantity)  from orderline where ProductID = ? ");
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                amount = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return amount;
    }

    public double getPriceProductById(int id) {
        double price = 0;
        try {
            connection = new DBConnect().getConnection();
            pst = connection.prepareStatement("SELECT  sum(Price)  from orderline where ProductID = ? ");
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                price = rs.getDouble(1);
            }
        } catch (Exception e) {
        }
        return price;
    }
    
    public double getTotalPrice() {
        double price = 0;
        try {
            connection = new DBConnect().getConnection();
            pst = connection.prepareStatement("SELECT  sum(Price)  from orderline");
            rs = pst.executeQuery();

            while (rs.next()) {
                price = rs.getDouble(1);
            }
        } catch (Exception e) {
        }
        return price;
    }
}
