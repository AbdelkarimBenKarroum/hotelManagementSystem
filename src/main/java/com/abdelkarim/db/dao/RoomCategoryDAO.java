/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdelkarim.db.dao;

import com.abdelkarim.db.model_objects.RoomCategory;
import java.util.List;

/**
 *
 * @author abdelkarim
 */
public interface RoomCategoryDAO {
    public List<RoomCategory> getAllRoomCategories();
    public RoomCategory getCategoryById(int id);
    public RoomCategory getCategoryIdByName(String type);
    
    public void add(RoomCategory category);
    public void update(RoomCategory category);
    public void removeUserRole(int id);
    
    
}
