package com.vitoraugusto.vibooks.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vitoraugusto.vibooks.R;
import com.vitoraugusto.vibooks.adapter.LivroAdapter;
import com.vitoraugusto.vibooks.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class LivrosCadastrados extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LivroAdapter livroAdapter;
    private List<Livro> livros = new ArrayList<>();
    private ImageView add;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livroscadastrados);

        recyclerView = findViewById(R.id.recyclerLivros);
        add = findViewById(R.id.add);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        livroAdapter = new LivroAdapter(this, livros);
        recyclerView.setAdapter(livroAdapter);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("titulo")) {
            String titulo = intent.getStringExtra("titulo");
            String autor = intent.getStringExtra("autor");
            String resumo = intent.getStringExtra("resumo");
            String imagemUri = intent.getStringExtra("imagem_uri");

            livros.add(new Livro(titulo, autor, resumo, imagemUri));
            livroAdapter.notifyItemInserted(livros.size() - 1);
        }
        add.setOnClickListener(v -> startActivity(new Intent(this, MainActivity.class)));
        }
        
    }