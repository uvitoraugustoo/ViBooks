package com.vitoraugusto.vibooks.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.vitoraugusto.vibooks.BancoDeDados.BancoDeDados;
import com.vitoraugusto.vibooks.BancoDeDados.BancoDeDadosLivros;

public class DbLivrosController {
    private final BancoDeDadosLivros banco;

    public DbLivrosController(Context context) {
        banco = new BancoDeDadosLivros(context);
    }

    public String insertData(String titulo, String autor, String resumo) {
        ContentValues valores = new ContentValues();
        SQLiteDatabase db = banco.getWritableDatabase();

        valores.put(BancoDeDadosLivros.TITULO, titulo);
        valores.put(BancoDeDadosLivros.AUTOR, autor);
        valores.put(BancoDeDadosLivros.RESUMO, resumo);


        long resultado = db.insert(BancoDeDadosLivros.NOME_TABELA, null, valores);

        if (resultado == -1) {
            return "Erro ao inserir registro";
        } else {
            return "Registro inserido com sucesso";
        }
    }
}
