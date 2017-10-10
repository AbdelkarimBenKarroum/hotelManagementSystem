/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdelkarim.db.model_objects;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author abdelkarim
 */
public class Room {
    private SimpleStringProperty id;
    private SimpleDoubleProperty price;
    private SimpleObjectProperty<RoomCategory> category;
    private SimpleObjectProperty<Byte> floor;
    //this is going to be used when we read data from room category table using a join
    private SimpleStringProperty category_name;
    //test room's availability
    private SimpleBooleanProperty isAvailable;
    public Room(){}

    public Room(String id, Double price, RoomCategory category, Byte floor,String category_name,Boolean available) {
        this.id =new SimpleStringProperty(id);
        this.price = new SimpleDoubleProperty(price);
        this.category =new SimpleObjectProperty<>(category);
        this.floor = new SimpleObjectProperty<>(floor);
        this.category_name=new SimpleStringProperty(category_name);
        this.isAvailable=new SimpleBooleanProperty(available);
    }
    public Boolean getIsAvailable() {
        return isAvailable.get();
    }

    public void setIsAvailable(Boolean avail) {
        isAvailable.set(avail);
    }
    public String getId() {
        return id.get();
    }
    public void setId(String ID) {
        id.set(ID);
    }
    public String getCategory_name() {
        return category_name.get();
    }
    public void setCategory_name(String cat) {
        category_name.set(cat);
    }
    public Double getPrice() {
        return price.get();
    }
    public void setPrice(Double p) {
        price.set(p);
    }
    public RoomCategory getCategory() {
        return category.get();
    }
    public void setCategory(RoomCategory Category) {
       category.set(Category);
    }
    public Byte getFloor() {
        return floor.get();
    }
    public void setFloor(Byte f) {
        floor.set(f);
    }
    @Override
    public String toString() {
        return "Room{" + "id=" + id.get() + 
                ", price=" + price.get() +
                ", category=" + category.get() + 
                ", floor=" + floor.get() +
                ", floor=" + category_name.get() +
                ", floor=" + isAvailable.get() +'}';
    }  
}
