/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdelkarim.db.impl;

import com.abdelkarim.db.DbConnectivity;
import com.abdelkarim.db.dao.RoomCategoryDAO;
import com.abdelkarim.db.model_objects.RoomCategory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abdelkarim
 */
public class RoomCategoryDAOImp implements RoomCategoryDAO {
    private static RoomCategoryDAOImp rCategoryManager;
    private Connection con=null;
    private PreparedStatement stmt=null;
    private String query=null;
    private ResultSet rs=null;
    DbConnectivity db=new DbConnectivity();
    
    private RoomCategoryDAOImp(){}
    public static RoomCategoryDAOImp getInstance(){
        if (rCategoryManager==null) {
            rCategoryManager=new RoomCategoryDAOImp();
        }
        return rCategoryManager;
    }
    
    
    @Override
    public List<RoomCategory> getAllRoomCategories() {
        query="select * from room_category";
        List<RoomCategory> categories=new ArrayList<>();
        RoomCategory category=null;
        try {
            con=db.getConnection();
            stmt=con.prepareStatement(query);
            rs=stmt.executeQuery();
            while (rs.next()) {      
                category=new RoomCategory();
                category.setCategory_id(rs.getByte("category_id"));
                category.setCategory_name(rs.getString("category_name"));
                categories.add(category);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                if (con!=null) {
                    con.close();
                }
                if (stmt!=null) {
                    stmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return categories;
        
    }

    @Override
    public RoomCategory getCategoryById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public void add(RoomCategory category) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(RoomCategory category) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeUserRole(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RoomCategory getCategoryIdByName(String type) {
        query="select * from room_category where category_name='"+type+"'";
        RoomCategory cat=null;
       
        try {
            con=db.getConnection();
            stmt=con.prepareStatement(query);
            rs=stmt.executeQuery();
            while (rs.next()) {                
               cat=new RoomCategory();
               cat.setCategory_id(rs.getByte("category_id"));
               cat.setCategory_name(rs.getString("category_name"));
            }
        } catch (Exception e) {
        }
        return cat;
    }
    
}
