package com.example.assignment10;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.text.DateFormat;
import java.util.Calendar;

@Entity(tableName = "taulukko")
public class Taulu {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int id;
    public String timestamp;
    public String opened;
/*
    public Taulu(String timestamp, String opened){
        //Calendar calendar = Calendar.getInstance();
        //String currentDate = DateFormat.getDateInstance(DateFormat.SHORT).format((calendar.getTime()));
        this.timestamp = timestamp;
        this.opened = opened;

        /*
        if(opened){
            this.opened = "Aukaistu";
        }
        else{
            this.opened = "Suljettu";
        }
    }*/

    public String getTimestamp() {
        return timestamp;
    }

    public String getOpened() {
        return opened;
    }
}
