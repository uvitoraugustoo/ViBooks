package com.vitoraugusto.vibooks.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.vitoraugusto.vibooks.R;

public class MainActivity extends AppCompatActivity {
    Button btnEscolherImagem, cadastrar;
    Uri imagemUriSelecionada;
    EditText titulo, nomeAutor, resumo;
    private static final int PICK_IMAGE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEscolherImagem = findViewById(R.id.btnEscolherImagem);
        cadastrar = findViewById(R.id.cadastrar);
        titulo = findViewById(R.id.titulo);
        nomeAutor = findViewById(R.id.nomeAutor);
        resumo = findViewById(R.id.resumo);


        btnEscolherImagem.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            startActivityForResult(Intent.createChooser(intent, "Selecione a imagem"), PICK_IMAGE_REQUEST);
        });

        cadastrar.setOnClickListener(v -> {
            String tituloLivro = titulo.getText().toString();
            String autor = nomeAutor.getText().toString();
            String resumoLivro = resumo.getText().toString();

            Intent intent = new Intent(MainActivity.this, livrosCadastrados.class);

            intent.putExtra("titulo", tituloLivro);
            intent.putExtra("autor", autor);
            intent.putExtra("resumo", resumoLivro);
            if (imagemUriSelecionada != null) {
                intent.putExtra("imagem_uri", imagemUriSelecionada.toString());
            }

            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imagemUriSelecionada = data.getData();
        }
    }
}


