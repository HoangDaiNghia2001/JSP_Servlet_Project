/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.connection.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class ViewDao {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public int getView() {
        int view = 0;
        try {
            conn = new DBConnect().getConnection();
            pst = conn.prepareStatement("select viewed from view");
            rs = pst.executeQuery();
            if (rs.next()) {
                view = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return view;
    }

    public void UpdateView() {
        try {
            conn = new DBConnect().getConnection();            
            pst = conn.prepareStatement("update view set viewed = viewed + 1");
            int kq = pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("");
        }
    }
}
