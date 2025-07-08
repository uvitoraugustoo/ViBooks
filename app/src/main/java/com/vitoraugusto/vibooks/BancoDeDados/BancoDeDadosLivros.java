package com.vitoraugusto.vibooks.BancoDeDados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BancoDeDadosLivros extends SQLiteOpenHelper {
    private static final String NOME_DATABASE = "dados_livros";
    private static final int VERSAO_DATABASE = 1;

    public static final String NOME_TABELA = "livros";

    public static final String ID = "id";
    public static final String TITULO = "titulo";
    public static final String AUTOR = "autor";
    public static final String RESUMO = "resumo";


    private static final String SQL_CRIAR_TABELA =
            "CREATE TABLE " + NOME_TABELA + " (" +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    TITULO + " TEXT, " +
                    AUTOR + " TEXT, " +
                    RESUMO + " TEXT)" ;


    public BancoDeDadosLivros(Context context) {
        super(context, NOME_DATABASE, null, VERSAO_DATABASE);
    }

    public BancoDeDadosLivros(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CRIAR_TABELA);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + NOME_TABELA);
        onCreate(db);
    }
}

