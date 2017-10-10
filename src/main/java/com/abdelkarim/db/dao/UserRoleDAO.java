/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdelkarim.db.dao;

import com.abdelkarim.db.model_objects.UserRole;
import java.util.List;

/**
 *
 * @author abdelkarim
 */
public interface UserRoleDAO {
    public List<UserRole> getAllUserRoles();
    public UserRole getUserRoleById(int id);
    public void addUserRole(UserRole userRole);
    public void updateUserRole(UserRole userRole);
    public void removeUserRole(int id);
}
