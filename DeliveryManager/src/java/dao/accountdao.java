/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Idao.iaccountdao;
import dbcontext.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import Idao.iaccountdao;
import models.Account;
import models.Role;
/**
 *
 * @author ASUS
 */
public class accountdao implements iaccountdao{
    Connection connection;//Khai báo một đối tượng Connection dùng để kết nối với cơ sở dữ liệu.
    PreparedStatement psm = null;//thực thi các câu lệnh sql
    ResultSet rs = null;// lưu trữ và xử lý dữ liệu
    db db;
    public accountdao(){
        try{
            db = new db();
            connection = db.getConnection();
            System.out.println("ok");
        }
        catch(Exception e){
            System.out.println("loi" + e);
        }
    } //check kết nối 

    //kiểm tra tài khoản có ko khi log in
    @Override
    public boolean checkAccount(String user_name, String password) {
        String sql = "select * from Account where user_name = ? and password = ?";
        try{
            psm = connection.prepareStatement(sql);
            psm.setString(1, user_name);
            psm.setString(2, password);
            ResultSet rs = psm.executeQuery();
            while(rs.next()){
                return true;
            }
        }
        catch(Exception e){
            String msg = e.toString();
            System.out.println("check account error" + msg);
        }
        return false;
    }
    
    //thêm vào account trong database
    @Override
    public void Addaccount(String user_name, String password) {
        String sql = "INSERT INTO public.Account(user_name, password, role_id, active) "
                + "VALUES (?, ?, ?, ?)";
        try {
            psm = connection.prepareStatement(sql);
            psm.setString(1, user_name);
            psm.setString(2, password);
            psm.setInt(3, 1);//role
            psm.setBoolean(4, true);
            
            int status = psm.executeUpdate();//thêm account
            if(status > 0){
                System.out.println("them account thanh cong");
            }
        } catch (Exception e) {
            String msg = e.toString();
            System.out.println("loi register" + msg);
        }
    }
    
    //tạo 1 acc ms 
    @Override
    public Account getAccount(String user_name, String password) {
        String sql = "select a.account_id ,full_name,password,active,role_name "
                + "from Account AS a inner join Role AS r on a.role_id = r.role_id "
                + "where user_name = ? and password = ?";
        try{
            psm = connection.prepareStatement(sql);
            psm.setString(1, user_name);
            psm.setString(2, password);//chuyền tham số khi trong truy vấn có "?"
            ResultSet rs = psm.executeQuery();
            Account acc = null;
            while(rs.next()){
                if(acc == null){
                    acc = new Account();
                    Role role = new Role();
                    
                    role.setRole_name(rs.getString("role_name"));
                    acc.setRole(role);
                    
                    acc.setAccount_id(rs.getInt("account_id"));
                    acc.setUser_name(rs.getString("full_name"));
                    acc.setPassword(rs.getString("password"));
                    acc.setActive(rs.getBoolean("active"));
                }
            }
            return acc;
        }
        catch(Exception e){
            String msg = e.toString();
            System.out.println("check account error" + msg);
        }
        return null;
    }
    
    //lấy hết các roll
    @Override
    public ArrayList<Role> getAllRole() {
       String sql = "select * from Role";
        try {
            ArrayList<Role> listRole = new ArrayList<>();
            
            psm = connection.prepareStatement(sql);
            ResultSet rs = psm.executeQuery();
            while(rs.next()){
                Role role = new Role();
                role.setRole_id(rs.getInt("role_id"));
                role.setRole_name(rs.getString("role_name"));
                listRole.add(role);
            }
            return listRole;
        } catch (Exception e) {
            String msg = e.toString();
            System.out.println("Get all role error: " + msg);
        }
        return null;
    }

    @Override
    public void Adduser(String full_name, String phone, int user_id) {
        String sql = "INSERT INTO public.User(full_name, phone, "
                + " account_id)VALUES (?, ?, ?)";
        try {
            psm = connection.prepareStatement(sql);
            psm.setString(1, full_name);
            psm.setString(2,phone);
            psm.setInt(3, user_id);
        } catch (Exception e) {
            String msg = e.toString();
            System.out.println("add user" + msg);
        }
    }

}
 