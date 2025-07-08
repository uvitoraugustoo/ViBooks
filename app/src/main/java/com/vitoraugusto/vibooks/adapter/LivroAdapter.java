package com.vitoraugusto.vibooks.adapter;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vitoraugusto.vibooks.R;
import com.vitoraugusto.vibooks.model.Livro;
import com.vitoraugusto.vibooks.view.MainActivity;

import java.util.List;

public class LivroAdapter extends RecyclerView.Adapter<LivroAdapter.LivroViewHolder> {
    private final Context context;
    private final List<Livro> livros;

    public LivroAdapter(Context context, List<Livro> livros) {
        this.context = context;
        this.livros = livros;
    }

    @NonNull
    @Override
    public LivroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_itemlivro, parent, false);
        return new LivroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LivroViewHolder holder, int position) {
        Livro livro = livros.get(position);
        holder.titulo.setText("Título: " + livro.getTitulo());
        holder.autor.setText("Autor: " + livro.getAutor());
        holder.resumo.setText("Resumo: " + livro.getResumo());
        holder.imgLivro.setImageURI(Uri.parse(livro.getImagemUri()));
        holder.itemView.setOnLongClickListener(v -> {
            livros.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, livros.size());
            return true;
        });
        holder.itemView.setOnClickListener(v ->{
            Intent intent = new Intent(context, MainActivity.class);
           intent.putExtra("título: ", livro.getTitulo());

          intent.putExtra("Autor: ", livro.getAutor());
           intent.putExtra("Resumo: ", livro.getResumo());
          intent.putExtra("Imagem:", livro.getImagemUri());
          intent.putExtra("Position:", holder.getAdapterPosition());
          context.startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return livros.size();
    }

    public static class LivroViewHolder extends RecyclerView.ViewHolder {
        TextView titulo, autor, resumo;
        ImageView imgLivro;

        public LivroViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.tituloLivro);
            autor = itemView.findViewById(R.id.autor);
            resumo = itemView.findViewById(R.id.resumoLivro);
            imgLivro = itemView.findViewById(R.id.imgLivro);
        }

    }

}
