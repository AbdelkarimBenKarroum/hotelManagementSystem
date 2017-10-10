/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdelkarim.db.model_objects;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author abdelkarim
 */
public class GuestInfo extends RecursiveTreeObject<GuestInfo> {
    private final SimpleStringProperty Id;
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty address;
    private final SimpleObjectProperty DOB;
    private final SimpleStringProperty gender;
    private final SimpleStringProperty phoneNumber;
    
    public GuestInfo(String Id, String firstName, String lastName, String address, Object DOB, String gender, String phoneNumber) {
        this.Id =new SimpleStringProperty(Id);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.address = new SimpleStringProperty(address);
        this.DOB = new SimpleObjectProperty(DOB);
        this.gender = new SimpleStringProperty(gender);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
    }

    
    public String getId() {
        return Id.get();
    }

    public void setId(String id) {
        Id.set(id);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String f) {
        firstName.set(f);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastname) {
        lastName.set(lastname);
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String ad) {
        address.set(ad);
    }

    public Object getDOB() {
        return DOB.get();
    }

    public void setDOB(Object dob) {
        DOB.set(dob);
    }

    public String getGender() {
        return gender.get();
    }

    public void setGender(String g) {
        gender.set(g);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(String phone) {
        phoneNumber.set(phone);
    }

    @Override
    public String toString() {
        return "GuestInfo{" + "Id=" + Id.get() 
                + ", firstName=" + firstName.get() 
                + ", lastName=" +  lastName .get()
                +", address=" + address.get()
                + ", DOB=" + DOB.get()
                + ", gender=" + gender.get()
                + ", phoneNumber=" + phoneNumber.get() + '}';
    }
    
    
    
    
}
