package com.vitoraugusto.vibooks.controller;




import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.vitoraugusto.vibooks.BancoDeDados.BancoDeDados;


public class DbController {

    private final BancoDeDados banco;

    public DbController(Context context) {
        banco = new BancoDeDados(context);
    }

    public String insertData(String nome, String email, String senha, String cpf) {
        ContentValues valores = new ContentValues();
        SQLiteDatabase db = banco.getWritableDatabase();

        valores.put(BancoDeDados.NOME, nome);
        valores.put(BancoDeDados.EMAIL, email);
        valores.put(BancoDeDados.SENHA, senha);
        valores.put(BancoDeDados.CPF, cpf);

        long resultado = db.insert(BancoDeDados.NOME_TABELA, null, valores);

        if (resultado == -1) {
            return "Erro ao inserir registro";
        } else {
            return "Registro inserido com sucesso";
        }
    }
    public boolean verificarLogin(String email, String senha) {
        SQLiteDatabase db = banco.getReadableDatabase();
        String query = "SELECT * FROM " + BancoDeDados.NOME_TABELA + " WHERE email = ? AND senha = ?";
        String[] args = {email, senha};

        return db.rawQuery(query, args).getCount() > 0;
    }
}

