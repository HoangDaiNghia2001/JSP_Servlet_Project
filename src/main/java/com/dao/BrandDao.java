/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.connection.DBConnect;
import com.model.Brand;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class BrandDao {

    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public List<Brand> getBrand() {
        List<Brand> lstBrand = new ArrayList<Brand>();
        try {

            connection = new DBConnect().getConnection();
            pst = connection.prepareStatement("select * from category");
            rs = pst.executeQuery();

            while (rs.next()) {
                Brand b = new Brand(rs.getInt(1), rs.getString(2));

                lstBrand.add(b);
            }

        } catch (Exception e) {
        }
        return lstBrand;
    }

    public Brand getBrandByIdProduct(String pID) {
        Brand b = null;
        try {
            connection = new DBConnect().getConnection();
            pst = connection.prepareStatement("select * from category WHERE categoryID = ?");
            pst.setString(1, pID);
            rs = pst.executeQuery();
            while (rs.next()) {
                b = new Brand(rs.getInt(1), rs.getString(2));
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return b;
    }

    public int getAmountProductOfBrand(String bID) {
        int amout = 0;
        try {
            connection = new DBConnect().getConnection();
            pst = connection.prepareStatement("select count(*) from product where categoryID= ?");
            pst.setString(1, bID);
            rs = pst.executeQuery();
            while (rs.next()) {
                amout = rs.getInt(1);
            }
            connection.close();
        } catch (Exception e) {
        }
        return amout;
    }

    public String getBrandByIDProduct(int proCID) {
        String brandName = "";
        try {
            connection = new DBConnect().getConnection();
            pst = connection.prepareStatement("select CategoryName from category where categoryID = ?");
            pst.setInt(1, proCID);
            rs = pst.executeQuery();

            while (rs.next()) {
                brandName = rs.getString(1);
            }
            connection.close();
        } catch (Exception e) {
        }
        return brandName;
    }
}
