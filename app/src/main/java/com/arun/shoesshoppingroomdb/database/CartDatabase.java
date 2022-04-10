package com.arun.shoesshoppingroomdb.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.arun.shoesshoppingroomdb.dao.CartDAO;
import com.arun.shoesshoppingroomdb.utils.model.ShoeCart;

@Database(entities = {ShoeCart.class} , version = 1)
public abstract class CartDatabase extends RoomDatabase {

    public abstract CartDAO cartDAO();
    public static CartDatabase instance;

    public static synchronized CartDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext()
                        ,CartDatabase.class,"CartDatabase")
                        .fallbackToDestructiveMigration().build();
        }
        return instance;
    }
}
