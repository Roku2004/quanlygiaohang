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
public class Driver {

    private int driver_id;
    private String name;
    private Vehical vehical_id;
    private boolean status;
    private ArrayList<Route> route;

    public Driver() {
    }

    public Driver(int driver_id, String name, Vehical vehical_id, boolean status, ArrayList<Route> route) {
        this.driver_id = driver_id;
        this.name = name;
        this.vehical_id = vehical_id;
        this.status = status;
        this.route = route;
    }


    public int getDriver_id() {
        return driver_id;
    }

    public String getName() {
        return name;
    }

    public Vehical getVehical_id() {
        return vehical_id;
    }

    public boolean isStatus() {
        return status;
    }

    public ArrayList<Route> getRoute() {
        return route;
    }


    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVehical_id(Vehical vehical_id) {
        this.vehical_id = vehical_id;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setRoute(ArrayList<Route> route) {
        this.route = route;
    }

    

}
