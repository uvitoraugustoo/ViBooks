package com.vitoraugusto.vibooks.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.vitoraugusto.vibooks.R;



public class livrosCadastrados extends AppCompatActivity {
    ImageView imgLivro;
    TextView tituloLivro, autor, resumoLivro;

    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livroscadastrados);

        imgLivro = findViewById(R.id.imgLivro);
        tituloLivro = findViewById(R.id.tituloLivro);
        autor = findViewById(R.id.autor);
        resumoLivro = findViewById(R.id.resumoLivro);

        Intent intent = getIntent();

        tituloLivro.setText(intent.getStringExtra("titulo"));

        String nomeAutor = intent.getStringExtra("autor");
        String resumo = intent.getStringExtra("resumo");

        autor.setText("Autor: " + nomeAutor);
        resumoLivro.setText("Resumo: " + resumo);

        String uriStr = intent.getStringExtra("imagem_uri");
        if (uriStr != null) {
            Uri uri = Uri.parse(uriStr);
            imgLivro.setImageURI(uri);
        }
    }
}
