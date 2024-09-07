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
public class ResetPassDao {
    Connection connection = null;
    PreparedStatement pst = null;
    
    public boolean ResetPass(String pass, String email)
    {
        try {
            connection = new DBConnect().getConnection();
            
            pst = connection.prepareStatement("update users set Password = ? where UserEmail = ? ");
            pst.setString(1, pass);
            pst.setString(2, email);
            int check = pst.executeUpdate();
            
            if(check > 0)
            {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
}
