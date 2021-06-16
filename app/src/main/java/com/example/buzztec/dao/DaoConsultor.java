package com.example.buzztec.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.buzztec.dto.DtoConsultor;

public class DaoConsultor extends SQLiteOpenHelper
{
    public final String TABELA_CONSULTOR = "TB_CONSULTOR";
    // public final String TABELA_LOGIN     = "TB_LOGIN";

    public DaoConsultor(@Nullable Context context)
    {
        super(context, "db_buzztec", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db_buzztec)
    {
        String strquery = "Create table " +TABELA_CONSULTOR+ "(" +
                "Id MEDIUMINT primary key autoincrement," +
                "Nm_consultor VARCHAR(60) not null," +
                "Tell_consultor VARCHAR(10) not null," +
                "Email_consultor VARCHAR(60) not null, " +
                "Cargo_consultor VARCHAR(30) not null)";
        db_buzztec.execSQL(strquery);
//        strquery = "CREATE TABLE " +TABELA_LOGIN+ "(" +
//                "Id MEDIUMINT primary key autoincrement," +
//                "Usuario_login varchar(20) not null," +
//                "Senha_login varchar(20) not null)";
//        db_buzztec.execSQL(strquery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
    public long CadastrarConsultor(DtoConsultor dtoConsultor)
    {
        ContentValues dados = Colunas(dtoConsultor);

        return getWritableDatabase().insert(TABELA_CONSULTOR, null, dados);
    }


    private ContentValues Colunas(DtoConsultor dtoConsultor)
    {
        ContentValues dados = new ContentValues();
        dados.put("Nome", dtoConsultor.getNome());
        dados.put("Telefone", dtoConsultor.getTelefone());
        dados.put("Email", dtoConsultor.getEmail());
        dados.put("Cargo", dtoConsultor.getCargo());
        return dados;
    }
}