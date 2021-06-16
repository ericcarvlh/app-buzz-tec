package com.example.buzztec.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.buzztec.dto.DtoCliente;
import com.example.buzztec.dto.DtoConsultor;

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
        String strquery = "Create Table " +TABELA_CLIENTE+ "(" +
                "Id MEDIUMINT primary key autoincrement," +
                "Cd_cliente MEDIUMINT not null," +
                "Nm_cliente VARCHAR(60) not null," +
                "Tell_cliente VARCHAR(10) not null," +
                "Email_cliente VARCHAR(60) not null)";
        db_buzztec.execSQL(strquery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long CadastrarCliente(DtoCliente dtoCliente)
    {
        ContentValues dados = Colunas(dtoCliente);

        return getWritableDatabase().insert(TABELA_CLIENTE, null, dados);
    }

    private ContentValues Colunas(DtoCliente dtoCliente)
    {
        ContentValues dados = new ContentValues();
        dados.put("Codigo",  dtoCliente.getCd_cliente());
        dados.put("Nome", dtoCliente.getNome());
        dados.put("Telefone",  dtoCliente.getTelefone());
        dados.put("Email",  dtoCliente.getEmail());
        return dados;
    }
}
