/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */

//Username: ulbQS6k7nS
//
//Database name: ulbQS6k7nS
//
//Password: 0Ze0OEGT14
//
//Server: remotemysql.com
//
//Port: 3306

//public class DBConnect {
//   private final String jdbcURL = "jdbc:mysql://remotemysql.com:3306/ulbQS6k7nS";
//    private final String jdbcUsername = "ulbQS6k7nS";
//    private final String jdbcPassword = "0Ze0OEGT14";
//    private final String jdbcDriver = "com.mysql.jdbc.Driver";//LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
//
//    Connection connection = null;
//
//    public Connection getConnection() throws ClassNotFoundException {
////        Connection connection = null;
//        try {
//            Class.forName(jdbcDriver);
//            connection = (Connection) DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return connection;
//    }
//
//    public void closeConnection() throws SQLException {
//        connection.close();
//    }
//}

public class DBConnect {
   private final String jdbcURL = "jdbc:mysql://localhost:3306/shopping-shoes";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "Dainghia2001";
    private final String jdbcDriver = "com.mysql.jdbc.Driver";//LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE

    Connection connection = null;

    public Connection getConnection() throws ClassNotFoundException {
//        Connection connection = null;
        try {
            Class.forName(jdbcDriver);
            connection = (Connection) DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}
