/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Idao;

import java.util.ArrayList;
import models.Driver;

/**
 *
 * @author ASUS
 */
public interface idrive {
    public void addDrive(String Dvier_name,boolean Status);
    
    public ArrayList<Driver> driver();
    
    public void updateDrive(int driver_id,String Driver_name,boolean Status);
}
