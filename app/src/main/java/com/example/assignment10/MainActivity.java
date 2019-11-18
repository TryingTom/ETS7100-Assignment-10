package com.example.assignment10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.room.Room;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ArrayList<Taulu> lista = new ArrayList<>();
    DbAdapteri adapteri;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listaView);
        adapteri = new DbAdapteri(this, R.layout.adapter_layout, lista);
        listView.setAdapter(adapteri);


    }

    @Override
    protected void onResume() {
        // kun palataan ohjelmaan
        super.onResume();

        // tämä ei toimi jostain syystä...
        lista.clear();
        adapteri.notifyDataSetChanged();

        // tämä heitettiin tänne mainista...
        JulistuksenKuuntelija julistuksenKuuntelija = new JulistuksenKuuntelija();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        getApplicationContext().registerReceiver(julistuksenKuuntelija, intentFilter);

        RoomDao dao = Tietokanta.getInstance(this).myDao();

        lista = (ArrayList<Taulu>) dao.getAllEntitys();
        adapteri.addAll(lista);


        adapteri.notifyDataSetChanged();
    }
}
