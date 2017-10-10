/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdelkarim.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abdelkarim
 */
public class DbConnectivity {
    private static final String driver="com.mysql.jdbc.Driver";
    private static final String url="jdbc:mysql://localhost/hoteldb";
    private static final String user="root";
    private static final String password="1234";
    
    public   Connection getConnection() throws SQLException{
        try {
            Class.forName(driver);
            Connection con=DriverManager.getConnection(url,user,password);
            if (con!=null) {
              // JOptionPane.showMessageDialog(null, "connected");
                return con;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnectivity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public  void closeConnection(Connection con) throws SQLException{
        if (con!=null) {
            con.close();
        }
    }
}
