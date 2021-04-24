package com.android.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.recyclerview.R;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_filmes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_filmes = findViewById(R.id.rv_filmes);
        //Configurar adapter

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rv_filmes.setLayoutManager(layoutManager);
        // otimizar o recyclerView
        rv_filmes.setHasFixedSize(true);
        //rv_filmes.setAdapter();
    }
}