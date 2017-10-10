/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdelkarim.db.impl;

import com.abdelkarim.db.DbConnectivity;
import com.abdelkarim.db.dao.GuestDAO;
import com.abdelkarim.db.model_objects.GuestInfo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abdelkarim
 */
public class GuestDAOImp implements GuestDAO {

    private Connection con=null;
    private PreparedStatement stmt=null;
    private String query=null;
    private ResultSet rs=null;
    DbConnectivity db=new DbConnectivity();
    private static GuestDAOImp guestManager;
    private GuestDAOImp(){}
    public static GuestDAOImp getInstance(){
        if (guestManager==null) {
            guestManager=new GuestDAOImp();
        }
        return guestManager;
    
    }
    
    @Override
    public List<GuestInfo> getAllGuets() {
        query="SELECT * FROM customers";
        List<GuestInfo> guests=new ArrayList<>();
        GuestInfo guest=null;
        try {
            con=db.getConnection();
            stmt=con.prepareStatement(query);
            rs=stmt.executeQuery();
            while (rs.next()) {                
                String id=rs.getString("customer_id");
                String firstname=rs.getString("customer_first_name");
                String lastname=rs.getString("customer_last_name");
                String address=rs.getString("customer_address");
                Object dob=rs.getDate("customer_DOB");
                String gender=rs.getString("customer_gender");
                String phone=rs.getString("customer_phoneNumber");
                guest=new GuestInfo(id, firstname, lastname, address, dob, gender, phone);
                
                guests.add(guest);
            }       
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return guests;
        }

    @Override
    public GuestInfo getGuest(GuestInfo guest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addGuest(GuestInfo guest) {
        boolean addedFlag=false;
        query="INSERT INTO customers VALUES(?,?,?,?,?,?,?)";
        try {
            con=db.getConnection();
            stmt=con.prepareStatement(query);
            stmt.setString(1, guest.getId());
            stmt.setString(2, guest.getFirstName());
            stmt.setString(3, guest.getLastName());
            stmt.setString(4, guest.getAddress());
            stmt.setDate(5, (Date) guest.getDOB());
            stmt.setString(6, guest.getGender());
            stmt.setString(7, guest.getPhoneNumber());
            int i=stmt.executeUpdate();
            if (i>0) {
                addedFlag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return addedFlag;
    
    }

    @Override
    public GuestInfo getUserById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateUser(GuestInfo guest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeUser(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
