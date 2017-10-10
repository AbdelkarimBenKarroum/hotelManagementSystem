/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdelkarim.db.impl;

import com.abdelkarim.db.DbConnectivity;
import com.abdelkarim.db.dao.RoomDAO;
import com.abdelkarim.db.model_objects.Room;
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
public class RoomDAOImp implements RoomDAO{
private Connection con=null;
    private PreparedStatement stmt=null;
    private String query=null;
    private ResultSet rs=null;
    DbConnectivity db=new DbConnectivity();
    private static RoomDAOImp roomManager;
    private RoomDAOImp(){}
    public static RoomDAOImp getInstance(){
        if (roomManager==null) {
            roomManager=new RoomDAOImp();
        }
        return roomManager;
    
    }
    @Override
    public List<Room> getAllRooms() {
        query="select r.id,r.room_price,r.room_floor,c.category_name,r.available \n" +
               "from rooms as r join room_category as c \n" +
                "on r.room_category_id=c.category_id;";
        List<Room> rooms=new ArrayList<>();
        Room room=null;
        RoomCategory category=null;
        try {
                con=db.getConnection();
                stmt=con.prepareStatement(query);
                rs=stmt.executeQuery();
                while (rs.next()) {  
                    String id=rs.getString("id");
                    Double price=rs.getDouble("room_price");
                    Byte floor=rs.getByte("room_floor");
                    String category_name=rs.getString("category_name");
                    Boolean avail=(rs.getInt("available"))==1;
                    room=new Room(id, price, category, floor,category_name,avail);
                    
                    rooms.add(room);       
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
            }
        
        }
        return rooms;
         }

    @Override
    public Room getRoom(Room ro) {
        return null;
         }

    @Override
    public void addRoom(Room ro) {
      
        query="INSERT INTO rooms VALUES(?,?,?,?,?)";
        try {
            con=db.getConnection();
            stmt=con.prepareStatement(query);
            String id=ro.getId();
            Double price=ro.getPrice();
            Byte floor=ro.getFloor();
            int categoryId=ro.getCategory().getCategory_id();
            int avail=(ro.getIsAvailable()==true)? 1:0;
            stmt.setString(1, id);
            stmt.setDouble(2,price);
            stmt.setInt(3,categoryId);
            stmt.setByte(4,floor);
            stmt.setInt(5, avail);
            
          //execute the query
          stmt.executeUpdate();
          
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
            }
        
        }
    }

    @Override
    public Room getRoomByCategory(String id) {
    return null;    
    }

    @Override
    public void updateRoom(Room ro) {
        query="UPDATE rooms SET id=? , room_price=? , room_category_id=?, room_floor=? , available=? WHERE id=?";
        try {
            con=db.getConnection();
            stmt=con.prepareStatement(query);
            String id=ro.getId();
            Double price=ro.getPrice();
            Byte floor=ro.getFloor();
            int categoryId=ro.getCategory().getCategory_id();
            int avail=(ro.getIsAvailable()==true)? 1:0;
            stmt.setString(1, id);
            stmt.setDouble(2,price);
            stmt.setInt(3,categoryId);
            stmt.setByte(4,floor);
            stmt.setInt(5, avail);
            stmt.setString(6,id);
          //execute the query
          stmt.executeUpdate();
          
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
            }
        
        }
      
    }

    @Override
    public void removeRoom(String id) {
        query="DELETE FROM rooms WHERE id=?";
        try {
            con=db.getConnection();
            stmt=con.prepareStatement(query);
            String ID=id;
            stmt.setString(1, ID);
          //execute the query
          stmt.executeUpdate();
          
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
            }
        
        }
    
    
    }

    @Override
    public List<Room> getSpecifiedRooms(String type) {
        query="select r.id,r.room_price,r.room_floor,c.category_name,r.available \n" +
               "from rooms as r join room_category as c \n" +
                "on r.room_category_id=c.category_id where c.category_name='"+type+"';";
        List<Room> rooms=new ArrayList<>();
        Room room=null;
        RoomCategory category=null;
        try {
                con=db.getConnection();
                stmt=con.prepareStatement(query);
                rs=stmt.executeQuery();
                while (rs.next()) {  
                    String id=rs.getString("id");
                    Double price=rs.getDouble("room_price");
                    Byte floor=rs.getByte("room_floor");
                    String category_name=rs.getString("category_name");
                    Boolean avail=rs.getInt("available")==1;
                    room=new Room(id, price, category, floor,category_name,avail);
                    rooms.add(room);        
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
            }
        
        }
        return rooms;
    }

    @Override
    public int totalRooms() {
        int totalRooms=0;
            query="select count(id) as total_rooms from rooms";
            try {
                con=db.getConnection();
                stmt=con.prepareStatement(query);
                rs=stmt.executeQuery();
                while (rs.next()) {                    
                    totalRooms=rs.getInt("total_rooms");
                }
            
        } catch (Exception e) {
        }
        return totalRooms;
         }

    @Override
    public int availableRooms() {
        int availableRooms=0;
            query="select count(id) as available_rooms from rooms where available=1;";
            try {
                con=db.getConnection();
                stmt=con.prepareStatement(query);
                rs=stmt.executeQuery();
                while (rs.next()) {                    
                    availableRooms=rs.getInt("available_rooms");
                }
            
        } catch (Exception e) {
        }
        return availableRooms;
    }

    @Override
    public int occupiedRooms() {
         int unavailableRooms=0;
            query="select count(id) as unavailable_rooms from rooms where available=0;";
            try {
                con=db.getConnection();
                stmt=con.prepareStatement(query);
                rs=stmt.executeQuery();
                while (rs.next()) {                    
                    unavailableRooms=rs.getInt("unavailable_rooms");
                }
            
        } catch (Exception e) {
        }
        return unavailableRooms;
           }

    @Override
    public int totalRoomsByType(int typeId) {
            int roomsByType=0;
               query="select count(id) as roomsByType from rooms where room_category_id='"+typeId+"' and available= 1";
            try {
                con=db.getConnection();
                stmt=con.prepareStatement(query);
                rs=stmt.executeQuery();
                while (rs.next()) {                    
                   roomsByType=rs.getInt("roomsByType");
                }
            
        } catch (Exception e) {
        }
        return roomsByType;
         }
    
}
