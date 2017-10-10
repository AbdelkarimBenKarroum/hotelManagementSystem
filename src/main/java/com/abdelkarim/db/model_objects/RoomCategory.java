/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdelkarim.db.model_objects;

/**
 *
 * @author abdelkarim
 */
public class RoomCategory {
    private Byte category_id;
    private String category_name;

    public RoomCategory(Byte category_id, String category_name) {
        this.category_id = category_id;
        this.category_name = category_name;
    }

    public RoomCategory() {
    }
    @Override
    public String toString() {
        return "RoomCategory{" + "category_id=" + category_id + ", category_name=" + category_name + '}';
    }
    

    public Byte getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Byte category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
    
}
