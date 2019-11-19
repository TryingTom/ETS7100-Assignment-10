package com.example.assignment10;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.text.DateFormat;
import java.util.Calendar;

public class IntentPalvelu2 extends IntentService {

    public IntentPalvelu2() {
        super("IntentPalvelu");
        setIntentRedelivery(false);
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {


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