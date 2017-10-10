/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdelkarim.hotelmanagementsystem;

import com.abdelkarim.db.model_objects.User;

/**
 *
 * @author abdelkarim
 */
public class Context {
    private static Context context;
    private User user;
    private Context(){
    }
    public static Context getInstance(){
        if (context==null) {
            context= new Context();
        }
        return context;
    }
    public  User getCurrentUser(){
        return new User();
    }
}
