/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.connection.DBConnect;
import com.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class ProductDao {

    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public List<Product> getAllProducts() {
        List<Product> lstAllProducts = new ArrayList<Product>();
        try {

            connection = new DBConnect().getConnection();
            pst = connection.prepareStatement("select * from product");
            rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getInt(7));

                lstAllProducts.add(p);
            }

        } catch (Exception e) {
        }
        return lstAllProducts;
    }

    public List<Product> getTop5Products() {
        List<Product> lst5Products = new ArrayList<Product>();
        try {

            connection = new DBConnect().getConnection();
            pst = connection.prepareStatement("select * from product where Amount > 0 order by Amount DESC limit 5");
            rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getInt(7));

                lst5Products.add(p);
            }

        } catch (Exception e) {
        }
        return lst5Products;
    }

    public List<Product> get4Products() {
        List<Product> lst4Products = new ArrayList<Product>();
        try {

            connection = new DBConnect().getConnection();
            pst = connection.prepareStatement("select * from product ORDER BY Amount DESC limit 4 offset 0");
            rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getInt(7));

                lst4Products.add(p);
            }

        } catch (Exception e) {
        }
        return lst4Products;
    }

    public List<Product> getNext4Products(int amount) {
        List<Product> lst4Products = new ArrayList<Product>();
        try {

            connection = new DBConnect().getConnection();
            pst = connection.prepareStatement("select * from product ORDER BY Amount DESC limit 4 offset ?");
            pst.setInt(1, amount);
            rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getInt(7));

                lst4Products.add(p);
            }

        } catch (Exception e) {
        }
        return lst4Products;
    }

    public Product getLastProduct() {
        Product p = null;
        try {
            connection = new DBConnect().getConnection();
            pst = connection.prepareStatement("select * from product order by ProductID DESC limit 1");
            rs = pst.executeQuery();
            while (rs.next()) {
                p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return p;
    }

    public List<Product> getProductsByBrand(String brandID) {
        List<Product> lstProducts = new ArrayList<Product>();
        try {

            connection = new DBConnect().getConnection();
            pst = connection.prepareStatement("select * from product where CategoryID = ?");
            pst.setString(1, brandID);
            rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getInt(7));

                lstProducts.add(p);
            }

        } catch (Exception e) {
        }
        return lstProducts;
    }

    public Product getProductByID(String id) {
        Product p = null;
        try {
            connection = new DBConnect().getConnection();
            pst = connection.prepareStatement("select * from product where ProductID = ?");
            pst.setString(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getString(2) != null) {
                    p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
                }
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return p;
    }

    public int amountProduct() {
        int amount = 0;

        try {
            connection = new DBConnect().getConnection();
            pst = connection.prepareStatement("select count(*) from product");
            rs = pst.executeQuery();

            while (rs.next()) {
                amount = rs.getInt(1);
            }
            connection.close();
        } catch (Exception e) {
        }
        return amount;
    }

    public List<Product> loadProductPage(int pageIndex) {
        List<Product> lstProducts = new ArrayList<Product>();

        try {

            connection = new DBConnect().getConnection();
            pst = connection.prepareStatement("select * from product limit 9 offset ?");
            pst.setInt(1, (pageIndex - 1) * 9);
            rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getInt(7));

                lstProducts.add(p);
            }

        } catch (Exception e) {
        }

        return lstProducts;
    }

    public List<Product> loadProductPageByBrand(String prandID, int pageIndex) {
        List<Product> lstProducts = new ArrayList<Product>();

        try {
            connection = new DBConnect().getConnection();
            pst = connection.prepareStatement("SELECT * FROM product where CategoryID = ? limit 9 offset ?");
            pst.setString(1, prandID);
            pst.setInt(2, (pageIndex - 1) * 9);
            rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getInt(7));

                lstProducts.add(p);
            }
        } catch (Exception e) {
        }
        return lstProducts;
    }

    public List<Product> getAllProductBySeacrh(String pName) {
        List<Product> lstProducts = new ArrayList<Product>();
        try {
            connection = new DBConnect().getConnection();
            pst = connection.prepareStatement("select * from product WHERE ProductName like ?");
            pst.setString(1, "%" + pName + "%");
            rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getInt(7));

                if (p.getProductName() != null) {
                    lstProducts.add(p);
                }
            }
        } catch (Exception e) {
        }
        return lstProducts;
    }

    public List<Product> get6ProductBySeacrh(String pName, double min, double max) {
        List<Product> lstProducts = new ArrayList<Product>();
        try {
            connection = new DBConnect().getConnection();
            pst = connection.prepareStatement("select * from product WHERE Price between ? and ? and ProductName like ? limit 6 offset 0");
            pst.setDouble(1, min);
            pst.setDouble(2, max);
            pst.setString(3, "%" + pName + "%");
            rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getInt(7));

                if (p.getProductName() != null) {
                    lstProducts.add(p);
                }
            }
        } catch (Exception e) {
        }
        return lstProducts;
    }

    public List<Product> loadMoreProductBySeacrh(String pName, int amount, double min, double max) {
        List<Product> lstProducts = new ArrayList<Product>();
        try {
            connection = new DBConnect().getConnection();
            pst = connection.prepareStatement("select * from product WHERE Price between ? and ? and ProductName like ? limit 3 offset ?");
            pst.setDouble(1, min);
            pst.setDouble(2, max);
            pst.setString(3, "%" + pName + "%");
            pst.setInt(4, amount);
            rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getInt(7));

                lstProducts.add(p);
            }
        } catch (Exception e) {
        }
        return lstProducts;
    }

    public int countProductBySearch(double min, double max, String name) {
        int amount = 0;
        try {
            connection = new DBConnect().getConnection();
            pst = connection.prepareStatement("select count(*) from product WHERE Price between ? and ? and ProductName like ?");
            pst.setDouble(1, min);
            pst.setDouble(2, max);
            pst.setString(3, "%" + name + "%");
            rs = pst.executeQuery();

            while (rs.next()) {
                amount = rs.getInt(1);
            }
            connection.close();
        } catch (Exception e) {
        }
        return amount;
    }

//    public List<Product> getProductByPriceUseJavax(double min, double max, String name) {
//        List<Product> lstProducts = new ArrayList<Product>();
//        try {
//            connection = new DBConnect().getConnection();
//            pst = connection.prepareStatement("SELECT * FROM product where Price between ? and ? and ProductName like ?");
//            pst.setDouble(1, min);
//            pst.setDouble(2, max);
//            pst.setString(3, "%" + name + "%");
//            rs = pst.executeQuery();
//
//            while (rs.next()) {
//                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getInt(8));
//
//                lstProducts.add(p);
//            }
//        } catch (Exception e) {
//        }
//        return lstProducts;
//    }
    public int getMaxPrice() {
        int max = 0;
        try {
            connection = new DBConnect().getConnection();
            pst = connection.prepareStatement("SELECT Max(price) FROM product");
            rs = pst.executeQuery();

            if (rs.next()) {
                max = rs.getInt(1);
            }
            connection.close();
        } catch (Exception e) {
        }
        return max;
    }

    public int getMinPrice() {
        int min = 0;
        try {
            connection = new DBConnect().getConnection();
            pst = connection.prepareStatement("SELECT min(price) FROM product");
            rs = pst.executeQuery();

            if (rs.next()) {
                min = rs.getInt(1);
            }
            connection.close();
        } catch (Exception e) {
        }
        return min;
    }

//    Page admin
    public List<Product> loadProductPageAdmin(int pageIndex) {
        List<Product> lstProducts = new ArrayList<Product>();

        try {

            connection = new DBConnect().getConnection();
            pst = connection.prepareStatement("select * from product limit 7 offset ?");
            pst.setInt(1, (pageIndex - 1) * 7);
            rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getInt(7));

                lstProducts.add(p);
            }

        } catch (Exception e) {
        }

        return lstProducts;
    }

    public void RemoveProduct(String id) {
        try {
            connection = new DBConnect().getConnection();
            pst = connection.prepareStatement("delete from product where productID = ?");
            pst.setString(1, id);
            pst.executeUpdate();
        } catch (Exception e) {
        }
    }

    public boolean AddProduct(String name, String descrip, double price, String imgLink, int categoryID, int amount) {
        try {
            connection = new DBConnect().getConnection();
            pst = connection.prepareStatement("insert into product (ProductName,Description,Price,imageLink,CategoryID,Amount) values(?,?,?,?,?,?)");
            pst.setString(1, name);
            pst.setString(2, descrip);
            pst.setDouble(3, price);
            pst.setString(4, imgLink);
            pst.setInt(5, categoryID);
            pst.setInt(6, amount);

            int check = pst.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public boolean updateProduct(int id, String name, String descrip, double price, String imgLink, int categoryID, int amount) {
        try {
            connection = new DBConnect().getConnection();
            pst = connection.prepareStatement("UPDATE product SET productName = ?, Description = ?, Price = ?, imageLink = ?, CategoryID = ?, Amount = ? WHERE ProductID = ?");
            pst.setString(1, name);
            pst.setString(2, descrip);
            pst.setDouble(3, price);
            pst.setString(4, imgLink);
            pst.setInt(5, categoryID);
            pst.setInt(6, amount);
            pst.setInt(7, id);

            int check = pst.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
}
