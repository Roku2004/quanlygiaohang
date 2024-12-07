/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Admin
 */
public class Order {

    private int order_id;
    private String sender;
    private String receiver;
    private String originAddress;
    private String destinationAddress;
    private String status;
    private String sender_phone;
    private String receiver_phone;

    public Order() {
    }

    public Order(int order_id, String sender, String receiver, String originAddress, String destinationAddress, String status, String sender_phone, String receiver_phone) {
        this.order_id = order_id;
        this.sender = sender;
        this.receiver = receiver;
        this.originAddress = originAddress;
        this.destinationAddress = destinationAddress;
        this.status = status;
        this.sender_phone = sender_phone;
        this.receiver_phone = receiver_phone;
    }

    
    public int getOrder_id() {
        return order_id;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getOriginAddress() {
        return originAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public String getStatus() {
        return status;
    }

    public String getSender_phone() {
        return sender_phone;
    }

    public String getReceiver_phone() {
        return receiver_phone;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setOriginAddress(String originAddress) {
        this.originAddress = originAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSender_phone(String sender_phone) {
        this.sender_phone = sender_phone;
    }

    public void setReceiver_phone(String receiver_phone) {
        this.receiver_phone = receiver_phone;
    }

}
