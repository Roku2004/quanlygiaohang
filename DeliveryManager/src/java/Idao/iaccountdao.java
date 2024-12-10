/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Idao;

import java.util.ArrayList;
import java.util.Date;
import models.Account;
import models.Role;


/**
 *
 * @author ASUS
 */
public interface iaccountdao {
    public boolean checkAccount(String user_name, String password);
    
    public void Addaccount(String user_name, String password);
    
    public Account getAccount(String user_name, String password);
    
    public ArrayList<Role> getAllRole();
    
    public void Adduser(String full_name,String phone,int user_id );
}
