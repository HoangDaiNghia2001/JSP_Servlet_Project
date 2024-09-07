/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

/**
 *
 * @author Administrator
 */
public class User {

    private int UserId;
    private String UserName;
    private String UserEmail;
    private String UserPassword;
    private int UserAdmin;

    public User() {
    }

    public User(String UserName, String UserPassword, String UserEmail) {
        this.UserName = UserName;
        this.UserEmail = UserEmail;
        this.UserPassword = UserPassword;
    }

    public User(int UserId, String UserName, String UserPassword, String UserEmail, int UserAdmin) {
        this.UserId = UserId;
        this.UserName = UserName;
        this.UserEmail = UserEmail;
        this.UserPassword = UserPassword;
        this.UserAdmin = UserAdmin;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String UserEmail) {
        this.UserEmail = UserEmail;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String UserPassword) {
        this.UserPassword = UserPassword;
    }

    public int getUserAdmin() {
        return UserAdmin;
    }

    public void setUserAdmin(int UserAdmin) {
        this.UserAdmin = UserAdmin;
    }

    @Override
    public String toString() {
        return "User{" + "UserId=" + UserId + ", UserName=" + UserName + ", UserEmail=" + UserEmail + ", UserPassword=" + UserPassword + '}';
    }

}
