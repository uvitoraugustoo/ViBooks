package com.vitoraugusto.vibooks.controller;



import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.vitoraugusto.vibooks.model.Pessoa;


public class LoginController {
    SharedPreferences sharedPreferences;
    public static final String NOMES_PREFERENCES = "dados_login";
    public LoginController(Context context) {
        sharedPreferences = context.getSharedPreferences(NOMES_PREFERENCES, 0);
    }
    public void loginPessoa(Pessoa pessoa) {
        SharedPreferences.Editor listaVip = sharedPreferences.edit();
        listaVip.putString("email", pessoa.getEmail());
        listaVip.putString("senha", pessoa.getSenha());
        listaVip.apply();
    }
    public Pessoa carregarPessoa() {
        String email = sharedPreferences.getString("email", "");
        String senha = sharedPreferences.getString("senha", "");
        return new Pessoa(email, senha);
    }
    @NonNull
    public String toString() {
        Log.d("MVC Controller ", "Controller Iniciado...");
        return super.toString();

    }
}


