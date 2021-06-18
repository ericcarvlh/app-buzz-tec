package com.example.buzztec.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.buzztec.dto.DtoCliente;

public class DaoCliente extends SQLiteOpenHelper
{
    public final String TABELA_CLIENTE   = "TB_CLIENTE";

    public DaoCliente(@Nullable Context context)
    {
        super(context, "db_buzztec", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db_buzztec)
    {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db_buzztec, int oldVersion, int newVersion)
    {
    }

    public long CadastrarCliente(DtoCliente dtoCliente)
    {
        ContentValues dados = Colunas(dtoCliente);

        return getWritableDatabase().insert(TABELA_CLIENTE, null, dados);
    }

    private ContentValues Colunas(DtoCliente dtoCliente)
    {
        ContentValues dados = new ContentValues();
        dados.put("Cd_cliente", dtoCliente.getCd_cliente());
        dados.put("Nm_cliente", dtoCliente.getNome());
        dados.put("Tell_cliente", dtoCliente.getTelefone());
        dados.put("Email_cliente", dtoCliente.getEmail());
        return dados;
    }
}
