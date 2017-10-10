/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdelkarim.db.impl;

import com.abdelkarim.db.DbConnectivity;
import com.abdelkarim.db.dao.UserRoleDAO;
import com.abdelkarim.db.model_objects.UserRole;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abdelkarim
 */
public class UserRoleDAOImp implements UserRoleDAO {
    private Connection con=null;
    private PreparedStatement stmt=null;
    private String query=null;
    private ResultSet rs=null;
    DbConnectivity db=new DbConnectivity();
    private static UserRoleDAOImp userRoleManager;
    private UserRoleDAOImp(){}
    
    public static UserRoleDAOImp getInstance(){
        if (userRoleManager==null) {
            userRoleManager=new UserRoleDAOImp();
        }
        return userRoleManager;
    }
    
    @Override
    public List<UserRole> getAllUserRoles() {
        query="select * from user_roles";
        List<UserRole> userRoles=new ArrayList<>();
        try {
            con=db.getConnection();
            stmt=con.prepareStatement(query);
            rs=stmt.executeQuery();
            while(rs.next()){
                UserRole user_role=new UserRole();
                user_role.setRole_id(rs.getInt("role_id"));
                user_role.setRole_name(rs.getString("role_name"));
                
                userRoles.add(user_role);
            }
        } catch (Exception e) {
        }
        finally{
            try {
                if (con!=null) {
                con.close();
            }
                if (stmt!=null) {
                    stmt.close();
                }
                if (rs!=null) {
                    rs.close();
                }
            } catch (Exception e) {
            }
        
        }
        return userRoles;
        
    }

    @Override
    public UserRole getUserRoleById(int id) {
        query="SELECT * FROM user_roles WHERE role_id='"+id+"'";
        UserRole user_role=null;
        
        try {
            con=db.getConnection();
            stmt=con.prepareStatement(query);
            rs=stmt.executeQuery();
            while (rs.next()) {                
                user_role=new UserRole();
                user_role.setRole_id(rs.getInt("role_id"));
                user_role.setRole_name(rs.getString("role_name"));       
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
                if (rs!=null) {
                    rs.close();
                }
            } catch (Exception e) {
            }
        
        }
        return user_role;
        }

    @Override
    public void addUserRole(UserRole userRole) {
           query="INSERT INTO user_roles VALUES(?,?)"; 
        try {
           con=db.getConnection();
           stmt=con.prepareStatement(query);
           stmt.setInt(1,userRole.getRole_id());
           stmt.setString(2, userRole.getRole_name());
               
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
                if (rs!=null) {
                    rs.close();
                }
            } catch (Exception e) {
            }
        
        }       
          
    }
    

    @Override
    public void updateUserRole(UserRole userRole) {
       
    }

    @Override
    public void removeUserRole(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
