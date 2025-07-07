package com.vitoraugusto.vibooks.BancoDeDados;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoDeDados extends SQLiteOpenHelper {

    private static final String NOME_DATABASE = "dados_usuarios";
    private static final int VERSAO_DATABASE = 3;

    public static final String NOME_TABELA = "usuarios";

    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String EMAIL = "email";
    public static final String SENHA = "senha";
    public static final String CPF = "cpf";

    private static final String SQL_CRIAR_TABELA =
            "CREATE TABLE " + NOME_TABELA + " (" +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NOME + " TEXT, " +
                    EMAIL + " TEXT, " +
                    SENHA + " TEXT, " +
                    CPF + " TEXT)";


    public BancoDeDados(Context context) {
        super(context, NOME_DATABASE, null, VERSAO_DATABASE);
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
