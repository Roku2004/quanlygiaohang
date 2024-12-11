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
    private Order order;
    private Driver driver;
    private Vehical vehical;
    
    public Route() {
    }

    public Route(int route_id, String startPoint, String endPoint, Order order, Driver driver, Vehical vehical) {
        this.route_id = route_id;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.order = order;
        this.driver = driver;
        this.vehical = vehical;
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

    public void setRoute_id(int route_id) {
        this.route_id = route_id;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Vehical getVehical() {
        return vehical;
    }

    public void setVehical(Vehical vehical) {
        this.vehical = vehical;
    }

}
