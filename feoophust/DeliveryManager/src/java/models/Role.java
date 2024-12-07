/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Role {

    private int role_id;
    private String role_name;
    private ArrayList<Account> account;

    public Role() {
    }

    public Role(int role_id, String role_name, ArrayList<Account> account) {
        this.role_id = role_id;
        this.role_name = role_name;
        this.account = account;
    }

    
    public int getRole_id() {
        return role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public ArrayList<Account> getAccount() {
        return account;
    }

    public void setAccount(ArrayList<Account> account) {
        this.account = account;
    }
   
}
