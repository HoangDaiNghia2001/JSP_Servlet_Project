/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.connection.DBConnect;
import com.model.Information;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class InformationDao  {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public Information getinfor()
    {
        Information inf = null;
        try {
            conn = new DBConnect().getConnection();
            pst = conn.prepareStatement("select * from information");
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                inf = new Information(rs.getString(1),rs.getString(2),rs.getString(3));
            }

            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return inf;
    }
}
