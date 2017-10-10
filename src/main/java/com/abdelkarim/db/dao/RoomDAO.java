/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdelkarim.db.dao;

import com.abdelkarim.db.model_objects.Room;
import java.util.List;

/**
 *
 * @author abdelkarim
 */
public interface RoomDAO {
    public   List<Room> getAllRooms();
    public   List<Room> getSpecifiedRooms(String type);
    public   Room getRoom(Room ro);
    public   void addRoom(Room ro);
    public  Room getRoomByCategory(String id);
    public void updateRoom(Room ro);
    public void removeRoom(String id);
    public int totalRooms();
    public int availableRooms();
    public int occupiedRooms();
    public int totalRoomsByType(int typeId);
}
