package com.example.appaniversario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import Models.Birthday;

public class MainActivity extends AppCompatActivity {

    List<Birthday> lstBirthday = new ArrayList<Birthday>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarLista();
    }
    private void inicializarLista() {
        lstBirthday.add(new Birthday("Aline", "Rua dos bobos", "1995-05-02"));
        lstBirthday.add(new Birthday("José", "Rua Feliz", "2000-05-02"));
        lstBirthday.add(new Birthday("Manuel", "Rua bobos", "1997-05-02"));
        lstBirthday.add(new Birthday("Babi", "Rua Azul", "1958-05-02"));

        bindListBirthday();
    }
    private void bindListBirthday() {
        ArrayAdapter<Birthday> aa = new ArrayAdapter<Birthday>(this, android.R.layout.simple_list_item_1, lstBirthday);
        ListView lv = (ListView) findViewById(R.id.listaContactos);
        lv.setAdapter(aa);

    }
}