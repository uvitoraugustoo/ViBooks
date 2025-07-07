package com.vitoraugusto.vibooks.view;



import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.vitoraugusto.vibooks.R;
import com.vitoraugusto.vibooks.controller.DbController;
import com.vitoraugusto.vibooks.controller.LoginController;
import com.vitoraugusto.vibooks.controller.PessoaController;
import com.vitoraugusto.vibooks.model.Pessoa;


public class LoginActivity extends AppCompatActivity {
    private EditText emailL, senhaL;
    private Button realizarL, limpar2;
    Pessoa pessoa;
    private TextView cadastroNull;
    LoginController loginController;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        loginController = new LoginController(this);

        emailL = findViewById(R.id.emailL);
        senhaL = findViewById(R.id.senhaL);
        realizarL = findViewById(R.id.realizarL);
        cadastroNull = findViewById(R.id.cadastroNull);
        limpar2 = findViewById(R.id.limpar2);

        PessoaController pessoaController = new PessoaController(LoginActivity.this);
        pessoa = pessoaController.carregarLogin();

        realizarL.setOnClickListener(v -> {
            String email = emailL.getText().toString().trim();
            String senha = senhaL.getText().toString().trim();

            DbController dbController = new DbController(LoginActivity.this);

            if (email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Preencha todos os Campos", Toast.LENGTH_SHORT).show();
            } else if (dbController.verificarLogin(email, senha)) {
                Toast.makeText(LoginActivity.this, "Login Finalizado!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                pessoa = new Pessoa(

                        emailL.getText().toString(),
                        senhaL.getText().toString()

                );
                loginController.loginPessoa(pessoa);
            } else {
                Toast.makeText(LoginActivity.this, "O email ou a senha estão incorretos, tente novamente", Toast.LENGTH_SHORT).show();
            }
        });

        cadastroNull.setOnClickListener(v -> {
                    Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                    startActivity(intent);
                }

        );
        limpar2.setOnClickListener(v -> {
            emailL.setText("");
            senhaL.setText("");
        });


        carregarPessoaSalva();
    }

    public void carregarPessoaSalva() {
        Pessoa pessoa2 = loginController.carregarPessoa();
        emailL.setText(pessoa2.getEmail());
        senhaL.setText(pessoa2.getSenha());

    }
}


