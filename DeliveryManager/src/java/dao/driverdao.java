/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Idao.idrive;
import dbcontext.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Driver;

/**
 *
 * @author ASUS
 */
public class driverdao implements idrive{
    Connection connection;//Khai báo một đối tượng Connection dùng để kết nối với cơ sở dữ liệu.
    PreparedStatement psm = null;//thực thi các câu lệnh sql
    ResultSet rs = null;// lưu trữ và xử lý dữ liệu
    db db;
    public driverdao(){
        try{
            db = new db();
            connection = db.getConnection();
            System.out.println("ok");
        }
        catch(Exception e){
            System.out.println("loi" + e);
        }
    } //check kết nối 
    @Override
    public void addDrive(String Dvier_name, boolean Status) {
        String sql = "INSERT INTO public.\"Driver\"(\n" +
                     "\"Dvier_name\", \"Status\")\n" +
                     "VALUES (?, ?);";
        try {
            psm = connection.prepareStatement(sql);
            psm.setString(1, Dvier_name);
            psm.setBoolean(2, Status);
            int state = psm.executeUpdate();
            if(state > 0)
            {
                System.out.println("Vehical added successfully");
            }
        } catch (Exception e) {
            String msg = e.toString();
            System.out.println("Extra error" + msg);
        }
    }

    @Override
    public ArrayList<Driver> driver() {
        String sql = "SELECT \"Driver_id\", \"Dvier_name\", \"Status\"\n" +
                     "FROM public.\"Driver\";";
        try {
            ArrayList<Driver> driverList = new ArrayList<>();
            psm = connection.prepareStatement(sql);
            ResultSet rs = psm.executeQuery();
            while(rs.next()){
                Driver driver = new Driver();
                driver.setDriver_id(rs.getInt("Driver_id"));
                driver.setName(rs.getString("Driver_name"));
                driver.setStatus(true);
                driverList.add(driver);
            }
            return driverList;
        } catch (Exception e) {
            String msg = e.toString();
            System.out.println("Search vehical ERROR" + msg);
        }
        return null;
    }

    @Override
    public void updateDrive(int driver_id,String Driver_name, boolean Status) {
        String sql = "UPDATE public.\"Driver\"\n" +
"	SET\"Dvier_name\"=?, \"Status\"=?\n" +
"	WHERE  \"Driver_id\"=?;";
        try {
            psm = connection.prepareStatement(sql);
            psm.setString(1, Driver_name);
            psm.setBoolean(2, Status);
            psm.setInt(3, driver_id);
            int state = psm.executeUpdate();
            if(state > 0)
            {
                System.out.println("Vehical added successfully");
            }
        } catch (Exception e) {
            String msg = e.toString();
            System.out.println("Extra error" + msg);
        }
    }
    
}
