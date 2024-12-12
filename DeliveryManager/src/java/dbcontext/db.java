/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbcontext;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ASUS
 */
public class db {
    public Connection getConnection()throws Exception {
        String url = "jdbc:postgresql://"+serverName+":"+portNumber + "\\" + instance +";databaseName="+dbName;
        if(instance == null || instance.trim().isEmpty())
            url = "jdbc:postgresql://"+serverName+":"+portNumber +";databaseName="+dbName;
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, userID, password);
    }
    
    
    private final String serverName = "localhost";
    private final String dbName = "giaohang";//tên database
    private final String portNumber = "5432";    
    private final String instance="";//LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
    private final String userID = "postgres";
    private final String password = "1";//mk postgresql
    
    
}
