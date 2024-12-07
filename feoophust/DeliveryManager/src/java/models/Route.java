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
public class Route {

    private int route_id;
    private String startPoint;
    private String endPoint;
    private ArrayList<Order> order;
    private Driver driver_id;

    public Route() {
    }

    public Route(int route_id, String startPoint, String endPoint, ArrayList<Order> order, Driver driver_id) {
        this.route_id = route_id;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.order = order;
        this.driver_id = driver_id;
    }

    

    public int getRoute_id() {
        return route_id;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public ArrayList<Order> getOrder() {
        return order;
    }

    public Driver getDriver_id() {
        return driver_id;
    }

    public void setRoute_id(int route_id) {
        this.route_id = route_id;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public void setOrder(ArrayList<Order> order) {
        this.order = order;
    }

    public void setDriver_id(Driver driver_id) {
        this.driver_id = driver_id;
    }

}
