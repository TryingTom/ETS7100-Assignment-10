package com.example.assignment10;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.text.DateFormat;
import java.util.Calendar;

public class IntentPalvelu extends IntentService {

    public IntentPalvelu() {
        super("IntentPalvelu");
        setIntentRedelivery(false);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        RoomDao dao = Tietokanta.getInstance(this).myDao();

        // lisää tieto
        Taulu t = new Taulu();

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateTimeInstance().format(calendar.getTime());

        t.timestamp = currentDate;
        t.opened = "Opened";
        dao.insert(t);
    }



    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        // do supposedly nothing but do still something
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        RoomDao dao = Tietokanta.getInstance(this).myDao();

        // lisää tieto
        Taulu t = new Taulu();

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateTimeInstance().format(calendar.getTime());

        t.timestamp = currentDate;
        t.opened = "Closed";
        dao.insert(t);
    }

}