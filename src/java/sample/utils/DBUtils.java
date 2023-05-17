/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dell
 */
public class DBUtils implements Serializable{
    public static Connection makeConnection() 
            throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433"
                + ";databaseName=StoreManagement";
        Connection con = DriverManager.getConnection(url, "sa", "12345");
        return con;
    }
}
