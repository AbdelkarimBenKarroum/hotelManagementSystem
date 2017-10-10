/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdelkarim.db.dao;

import com.abdelkarim.db.model_objects.User;
import java.util.List;

/**
 *
 * @author abdelkarim
 */
public interface UserDAO {
    public   List<User> getAllUsers();
    public   User getUser(User user);
    public   boolean addUser(User user);
    public  User getUserById(String id);
    public void updateUser(User user);
    public void removeUser(String id);
}
