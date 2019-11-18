package com.example.assignment10;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class JulistuksenKuuntelija extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        // toimii mutta miten?

        //Toast.makeText(context, "Apua!", Toast.LENGTH_LONG).show();

        Intent palvelu = new Intent(context, IntentPalvelu.class);
        context.startService(palvelu);


        // Jotenkin heitä tietokantaan nämä?



        // myös opened homma myös, jotenkin stringiksi
    }
}