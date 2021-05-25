package com.android.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.recyclerview.R;
import com.android.recyclerview.adapter.AdapterFilmes;
import com.android.recyclerview.model.Filme;
import com.android.recyclerview.model.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_filmes;
    private List<Filme> listaFilme = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_filmes = findViewById(R.id.rv_filmes);
        // Listagem de filmes
        this.criarFilmes();

        //Configurar adapter
        AdapterFilmes adapterFilmes = new AdapterFilmes(listaFilme);

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rv_filmes.setLayoutManager(layoutManager);

        // Otimizar o recyclerView
        rv_filmes.setHasFixedSize(true);
        rv_filmes.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        rv_filmes.setAdapter(adapterFilmes);

        //Evento de click
        rv_filmes.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getApplicationContext(),
                    rv_filmes,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Filme filme = listaFilme.get(position);
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Item pressionado " + filme.getTitulo(),
                                    Toast.LENGTH_SHORT
                            ).show();
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            Filme filme = listaFilme.get(position);
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Click longo " + filme.getTitulo(),
                                    Toast.LENGTH_LONG
                            ).show();
                        }

                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        }
                    }
            )
        );
    }
    public void criarFilmes(){
        Filme filme = new Filme("Homem Aranha - De volta ao lar", "Aventura", "2017");
        this.listaFilme.add(filme);
        filme = new Filme("Mulher Maravilha", "Fantasia", "2017");
        this.listaFilme.add(filme);
        filme = new Filme("Liga da Justiça", "Ficção", "2017");
        this.listaFilme.add(filme);
        filme = new Filme("Capitão América - Guerra Civil", "Aventura/Ficção", "2016");
        this.listaFilme.add(filme);
        filme = new Filme("It: A Coisa", "Drama/Terror", "2017");
        this.listaFilme.add(filme);
        filme = new Filme("Pica Pau: O Filme", "Comédia/Animação", "2017");
        this.listaFilme.add(filme);
        filme = new Filme("A Múmia", "Terror", "2017");
        this.listaFilme.add(filme);
        filme = new Filme("A Bela e a Fera", "Romance", "2017");
        this.listaFilme.add(filme);
        filme = new Filme("Meu Malvado Favorito", "Comédia", "2017");
        this.listaFilme.add(filme);
        filme = new Filme("Carros 3", "Comédia", "2017");
        this.listaFilme.add(filme);
    }
}