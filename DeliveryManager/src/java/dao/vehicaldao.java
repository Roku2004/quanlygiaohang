/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Idao.ivehical;
import dbcontext.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Vehical;

/**
 *
 * @author ASUS
 */
public class vehicaldao implements ivehical{
    Connection connection;//Khai báo một đối tượng Connection dùng để kết nối với cơ sở dữ liệu.
    PreparedStatement psm = null;//thực thi các câu lệnh sql
    ResultSet rs = null;// lưu trữ và xử lý dữ liệu
    db db;
    public vehicaldao(){
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
    public void addVehicle(String vehicalType, double capacity, String numberPlate) {
        String sql = "INSERT INTO public.\"Vehical\"(\n" +
                     "\"Vehicaltype\", \"Capacity(KG)\", \"NumberPlate\")\n" +
                     "VALUES (?, ?, ?);";
        try {
            psm = connection.prepareStatement(sql);
            psm.setString(1, vehicalType);
            psm.setDouble(2, capacity);
            psm.setString(3, numberPlate);
            int status = psm.executeUpdate();
            if(status > 0){
                System.out.println("Vehical added successfully");
            }
        } catch (Exception e) {
            String msg = e.toString();
            System.out.println("Extra error" + msg);
        }
    }

    @Override
    public ArrayList<Vehical> getVehical() {
        String sql = "SELECT \"Vehical_id\", \"Vehicaltype\", \"Capacity(KG)\", \"NumberPlate\"\n" +
                    "FROM public.\"Vehical\";";
        try {
            ArrayList<Vehical> vehicalList = new ArrayList<>();
            psm = connection.prepareStatement(sql);
            ResultSet rs = psm.executeQuery();
            while(rs.next()){
                Vehical vehical = new Vehical();
                vehical.setVehical_id(rs.getInt("Vehical_id"));
                vehical.setVehicalType(rs.getString("Vehicaltype"));
                vehical.setCapacity(rs.getDouble("Capacity(KG)"));
                vehical.setNumberPlate(rs.getString("NumberPlate"));
                vehicalList.add(vehical);
            }
            return vehicalList;
        } catch (Exception e) {
            String msg = e.toString();
            System.out.println("Search vehical ERROR" + msg);
        }
        return null;       
    }
    
}
