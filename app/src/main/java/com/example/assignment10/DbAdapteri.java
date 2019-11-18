package com.example.assignment10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

class DbAdapteri extends ArrayAdapter {
    private List<Taulu> lista;
    private Context context;

    public DbAdapteri(@NonNull Context context, int resource, @NonNull List<Taulu> taulu){
        super(context, resource, taulu);
        lista = (List<Taulu>) taulu;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if (convertView == null) {
            View v = LayoutInflater.from(context).inflate(R.layout.adapter_layout, parent, false);
            TextView timestamp = v.findViewById(R.id.timestamp);
            TextView status = v.findViewById(R.id.status);

            timestamp.setText(lista.get(position).getTimestamp());
            status.setText(lista.get(position).getOpened());

            convertView = v;
        }

        return  convertView;
    }
}
