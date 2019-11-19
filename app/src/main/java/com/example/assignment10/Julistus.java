package com.example.assignment10;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class Julistus extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        // kokeilin jos toimisi tällä, mutta ei näköjään

        Intent palvelu = new Intent(context, IntentPalvelu2.class);
        context.startService(palvelu);
    }
}