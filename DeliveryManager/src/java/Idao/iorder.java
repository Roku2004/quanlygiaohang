/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Idao;

import java.util.ArrayList;
import models.Account;
import models.Order;

/**
 *
 * @author ASUS
 */
public interface iorder {
    public void AddOrder(Order order);
    
    public void UpdateOrderUser(int order_id,String sender, String receiver, String originAddress, String destinationAddres, String sender_phone, String receiver_phone,int weight);
    
    public void UpdateOrderAdmin(int order_id, String sender, String receiver, String originAddress, String destinationAddres, String sender_phone, String receiver_phone,int weight,String status,float total_cost,boolean payment_status);
    
    public void AddOrderAdmin(Order order);
    
    public ArrayList<Order> getOrder();
    
    public ArrayList<Order> getOrderAdmin();
    
    public ArrayList<Order> searchOrder(int order_id);
}
