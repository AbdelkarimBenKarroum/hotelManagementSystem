/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdelkarim.db.dao;

//import com.abdelkarim.db.model_objects.Guest;
import com.abdelkarim.db.model_objects.GuestInfo;
import java.util.List;

/**
 *
 * @author abdelkarim
 */
public interface GuestDAO {
    public   List<GuestInfo> getAllGuets();
    public   GuestInfo getGuest(GuestInfo guest);
    public   boolean addGuest(GuestInfo guest);
    public  GuestInfo getUserById(String id);
    public void updateUser(GuestInfo guest);
    public void removeUser(String id);
}
