package com.example.assignment10;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

// tietokannan voi tyhjentää versionvaihdolla
@Database(entities = Taulu.class, version = 26)
public abstract class Tietokanta extends RoomDatabase {

    public static final String NIMI = "TIETOKANTA";

    private static Tietokanta instance;

    public static synchronized Tietokanta getInstance(Context context){
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), Tietokanta.class, NIMI)
                    .fallbackToDestructiveMigration().allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract RoomDao myDao();
}
