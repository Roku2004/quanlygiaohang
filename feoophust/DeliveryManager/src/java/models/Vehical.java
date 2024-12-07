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
public class Vehical {

    private int vehical_id;
    private String vehicalType;
    private double capacity;
    private String numberPlate;
    private ArrayList<Driver> driver;


    public Vehical() {
    }

    public Vehical(int vehical_id, String vehicalType, double capacity, String numberPlate, ArrayList<Driver> driver) {
        this.vehical_id = vehical_id;
        this.vehicalType = vehicalType;
        this.capacity = capacity;
        this.numberPlate = numberPlate;
        this.driver = driver;
    }

    

    public int getVehical_id() {
        return vehical_id;
    }

    public String getVehicalType() {
        return vehicalType;
    }

    public double getCapacity() {
        return capacity;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public ArrayList<Driver> getDriver() {
        return driver;
    }

    public void setVehical_id(int vehical_id) {
        this.vehical_id = vehical_id;
    }

    public void setVehicalType(String vehicalType) {
        this.vehicalType = vehicalType;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public void setDriver(ArrayList<Driver> driver) {
        this.driver = driver;
    }

}
