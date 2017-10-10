/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdelkarim.db.impl;

import com.abdelkarim.db.DbConnectivity;
import com.abdelkarim.db.dao.UserDAO;
import com.abdelkarim.db.model_objects.User;
import com.abdelkarim.db.model_objects.UserRole;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abdelkarim
 */
public class UserDAOImp implements UserDAO{
    private Connection con=null;
    private PreparedStatement stmt=null;
    private String query=null;
    private ResultSet rs=null;
    DbConnectivity db=new DbConnectivity();
    private static UserDAOImp userManager;
    private UserDAOImp(){}
    public static UserDAOImp getInstance(){
        if (userManager==null) {
            userManager=new UserDAOImp();
        }
        return userManager;
    
    }
    @Override
    public  List<User> getAllUsers() {
        query="select * from users";
        List<User> users=new ArrayList<User>();
        try {
            con=db.getConnection();
            stmt=con.prepareStatement(query);
            rs=stmt.executeQuery();
            while(rs.next()){
                UserRole user_role=new UserRole();
                User user=new User();
                user.setUser_id(rs.getString("user_id"));
                user.setUser_name(rs.getString("user_name"));
                user.setUser_password(rs.getString("user_password"));
                user_role.setRole_id(rs.getInt("user_role_id"));
                user.setUser_role(user_role);
                
                users.add(user);
            
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
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAOImp.class.getName()).log(Level.SEVERE, null, ex);
                }
           
        }
        
        
       return users;
    }

    @Override
    public boolean addUser(User user) {
        String id=user.getUser_id();
        String user_name=user.getUser_name();
        int roleId=user.getUser_role().getRole_id();
        String password=user.getUser_password();
        boolean flag=false;
        query="INSERT INTO users VALUES(?,?,?,?)";
        try {
            con=db.getConnection();
            stmt=con.prepareStatement(query);
            stmt.setString(1,id);
            stmt.setString(2, user_name);
            stmt.setInt(3, roleId);
            stmt.setString(4, password);
            int i=stmt.executeUpdate();        
            if (i>0 ) {
                flag=true;
            }
        } catch (Exception e) {
            e.getStackTrace();
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
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAOImp.class.getName()).log(Level.SEVERE, null, ex);
                }
           
        }
        return flag;
          }

    @Override
    public User getUserById(String id) {
        
        
        return null;
         }

    @Override
    public void updateUser(User user) {
       
    }

    @Override
    public void removeUser(String id) {
      
    }

    @Override
    public  User getUser(User user) {
        query="SELECT * FROM users WHERE user_name='"+user.getUser_name()+
                "' AND user_password='"+user.getUser_password()+"'";
        User returnedUser=null;
        UserRoleDAOImp URManager=UserRoleDAOImp.getInstance();
        try {
            con=db.getConnection();
            stmt=con.prepareStatement(query);
            rs=stmt.executeQuery();
            while (rs.next()) {
                returnedUser=new User();
                returnedUser.setUser_id(rs.getString("user_id"));
                returnedUser.setUser_name(rs.getString("user_name"));
                returnedUser.setUser_role(URManager.getUserRoleById(rs.getInt("user_role_id")));
                returnedUser.setUser_password(rs.getString("user_password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnedUser;
    }
    
}
