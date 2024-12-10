/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Idao.iorder;
import dbcontext.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Order;

/**
 *
 * @author ASUS
 */
public class orderdao implements iorder{
    Connection connection;//Khai báo một đối tượng Connection dùng để kết nối với cơ sở dữ liệu.
    PreparedStatement psm = null;//thực thi các câu lệnh sql
    ResultSet rs = null;// lưu trữ và xử lý dữ liệu
    db db;
    public orderdao(){
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
    public void AddOrder(Order order) {
        String sql = "INSERT INTO public.\"Order\"(\n" +
"	\"Sender\", \"Receiver\", \"Origin_address\", \"Destination_address\", \"Sender_phone\", \"Receiver_phone\",\"Weight\",\"Account_id\")\n" +
"	VALUES (?, ?, ?, ?, ?, ?, ?,?);";
        try {
            psm = connection.prepareStatement(sql);
            psm.setString(1, order.getSender());
            psm.setString(2, order.getReceiver());
            psm.setString(3, order.getOriginAddress());
            psm.setString(4,order.getDestinationAddress() );
            psm.setString(5, order.getSender_phone());
            psm.setString(6, order.getReceiver_phone());
            psm.setInt(7 , order.getWeight());
            psm.setInt(8, order.getAccount().getAccount_id());
            int status = psm.executeUpdate();
            if(status > 0){
                System.out.println("Order added successfully");
            }
            
        } catch (Exception e) {
            String msg = e.toString();
            System.out.println("Extra error" + msg);
        }
    }
    
    @Override
    public void AddOrderAdmin(Order order) {
        String sql = "INSERT INTO public.\"Order\"(\n" +
"	\"Sender\", \"Receiver\", \"Origin_address\", \"Destination_address\", \"Sender_phone\", \"Receiver_phone\", \"Status\", \"Weight\", \"Total Cost\", \"Payment status\", \"Account_id\")\n" +
"	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
        try {
            psm = connection.prepareStatement(sql);
            psm.setString(1, order.getSender());
            psm.setString(2, order.getReceiver());
            psm.setString(3, order.getOriginAddress());
            psm.setString(4,order.getDestinationAddress() );
            psm.setString(5, order.getSender_phone());
            psm.setString(6, order.getReceiver_phone());
            psm.setString(7, order.getStatus());
            psm.setInt(8 , order.getWeight());
            psm.setFloat(9, order.getTotal_cost());
            psm.setBoolean(10, true);
            psm.setInt(11, order.getAccount().getAccount_id());
            int status = psm.executeUpdate();
            if(status > 0){
                System.out.println("Order added successfully");
            }
            
        } catch (Exception e) {
            String msg = e.toString();
            System.out.println("Extra error" + msg);
        }
    }
    
    @Override
    public void UpdateOrderUser(int order_id, String sender, String receiver, String originAddress, String destinationAddres, String sender_phone, String receiver_phone,int weight) {
        String sql = "UPDATE public.\"Order\"\n" +
"	SET  \"Sender\"=?, \"Receiver\"=?, \"Origin_address\"=?, \"Destination_address\"=?, \"Sender_phone\"=?, \"Receiver_phone\"=?,\"Weight\" = ? " +
"	WHERE \"Order_id\"=?;";
        try {
            psm = connection.prepareStatement(sql);
            psm.setString(1, sender);
            psm.setString(2, receiver);
            psm.setString(3, originAddress);
            psm.setString(4, destinationAddres);
            psm.setString(5, sender_phone);
            psm.setString(6, receiver_phone);
            psm.setInt(7, weight);
            psm.setInt(8, order_id);
            int status = psm.executeUpdate();
            if(status > 0){
                System.out.println("Order updated successfully ");
            }
        } catch (Exception e) {
            String msg = e.toString();
            System.out.println("Update ERROR "+ msg);
        }
    }

    @Override
    public void UpdateOrderAdmin(int order_id,String status,float total_cost,boolean payment_status) {
        String sql = "UPDATE public.Order SET \"Status\"=? \"Total Cost\"=?, \"Payment status\"=? \n" +
"	WHERE \"Order_id\"=?;";
        try {
            psm = connection.prepareStatement(sql);
            psm.setString(1, status);
            psm.setFloat(2, total_cost);
            psm.setBoolean(3, payment_status);
            psm.setInt(4, order_id);
            int state = psm.executeUpdate();
            if(state > 0){
                System.out.println("Successfully updated order status");
            }
        } catch (Exception e) {
            String msg = e.toString();
            System.out.println("Update ERROR" + msg);
        }
    }

    @Override
    public ArrayList<Order> getOrder() {
        String sql = "SELECT \"Order_id\", \"Sender\", \"Receiver\", \"Origin_address\", \"Destination_address\", "
                   + "\"Sender_phone\", \"Receiver_phone\", \"Status\", \"Weight\", \"Total Cost\", \"Payment status\"\n" +
"                    FROM public.\"Order\" as o\n" +
                     "inner join public.\"Account\" as a on o.account_id = a.account_id";
        try {
            ArrayList<Order> orderList = new ArrayList<>();
            psm = connection.prepareStatement(sql);
            ResultSet rs = psm.executeQuery();
            while(rs.next()){
                Order order = new Order();
                order.setOrder_id(rs.getInt("Order_id"));
                order.setSender(rs.getString("Sender"));
                order.setReceiver(rs.getString("Receiver"));
                order.setOriginAddress(rs.getString("Origin_address"));
                order.setDestinationAddress(rs.getString("Destination_address"));
                order.setSender_phone(rs.getString("Sender_phone"));
                order.setReceiver_phone(rs.getString("Receiver_phone"));
                order.setStatus(rs.getString("Status"));
                order.setWeight(rs.getInt("Weight"));
                order.setTotal_cost(rs.getFloat("Total Cost"));
                order.setPayment_status(true);
                orderList.add(order);
            }
            return orderList;
        } catch (Exception e) {
            String msg = e.toString();
            System.out.println("Search order ERROR" + msg);
        }
        return null;
    }

    @Override
    public ArrayList<Order> getOrderAdmin() {
        String sql = "SELECT \"Order_id\", \"Sender\", \"Receiver\", \"Origin_address\", \"Destination_address\", "
                   + "\"Sender_phone\", \"Receiver_phone\", \"Status\", \"Weight\", \"Total Cost\", \"Payment status\"\n" +
"                    FROM public.\"Order\" as o";
        try {
            ArrayList<Order> orderList = new ArrayList<>();
            psm = connection.prepareStatement(sql);
            ResultSet rs = psm.executeQuery();
            while(rs.next()){
                Order order = new Order();
                order.setOrder_id(rs.getInt("Order_id"));
                order.setSender(rs.getString("Sender"));
                order.setReceiver(rs.getString("Receiver"));
                order.setOriginAddress(rs.getString("Origin_address"));
                order.setDestinationAddress(rs.getString("Destination_address"));
                order.setSender_phone(rs.getString("Sender_phone"));
                order.setReceiver_phone(rs.getString("Receiver_phone"));
                order.setStatus(rs.getString("Status"));
                order.setWeight(rs.getInt("Weight"));
                order.setTotal_cost(rs.getFloat("Total Cost"));
                order.setPayment_status(true);
                orderList.add(order);
            }
            return orderList;
        } catch (Exception e) {
            String msg = e.toString();
            System.out.println("Search order ERROR" + msg);
        }
        return null;
    }

    @Override
    public ArrayList<Order> searchOrder(int order_id) {
        String sql = "SELECT \"Order_id\", \"Sender\", \"Receiver\", \"Origin_address\", \"Destination_address\", "
                   + "\"Sender_phone\", \"Receiver_phone\", \"Status\", \"Weight\", \"Total Cost\", \"Payment status\"\n" +
"                    FROM public.\"Order\" as o where Order_id = ?";
        try {
            ArrayList<Order> orderList = new ArrayList<>();
            psm = connection.prepareStatement(sql);
            psm.setInt(1, order_id);
            ResultSet rs = psm.executeQuery();
            while(rs.next()){
                Order order = new Order();
                order.setOrder_id(rs.getInt("Order_id"));
                order.setSender(rs.getString("Sender"));
                order.setReceiver(rs.getString("Receiver"));
                order.setOriginAddress(rs.getString("Origin_address"));
                order.setDestinationAddress(rs.getString("Destination_address"));
                order.setSender_phone(rs.getString("Sender_phone"));
                order.setReceiver_phone(rs.getString("Receiver_phone"));
                order.setStatus(rs.getString("Status"));
                order.setWeight(rs.getInt("Weight"));
                order.setTotal_cost(rs.getFloat("Total Cost"));
                order.setPayment_status(true);
                orderList.add(order);
            }
            return orderList;
        } catch (Exception e) {
            String msg = e.toString();
            System.out.println("Search order ERROR" + msg);
        }
        return null;
    }

    
    

    
    
}
