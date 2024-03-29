package com.android.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.recyclerview.R;
import com.android.recyclerview.model.Filme;

import java.util.List;

public class AdapterFilmes extends RecyclerView.Adapter<AdapterFilmes.MyViewHolder> {
    private List<Filme> listaFilmes;
    public AdapterFilmes(List<Filme> lista) {
        this.listaFilmes = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item_lista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista, parent, false);
        return new MyViewHolder(item_lista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Filme filme = listaFilmes.get(position);
        holder.titulo.setText(filme.getTitulo());
        holder.genero.setText(filme.getGenero());
        holder.ano.setText(filme.getAno());
    }

    @Override
    public int getItemCount()
    {
        return listaFilmes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView titulo, ano, genero;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.tv_titulo);
            ano = itemView.findViewById(R.id.tv_ano);
            genero = itemView.findViewById(R.id.tv_genero);
        }
    }
}
