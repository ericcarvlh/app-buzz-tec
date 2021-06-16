package com.example.buzztec.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.buzztec.dto.DtoServico;

public class DaoServico extends SQLiteOpenHelper
{
    public final String TABELA_SERVICO = "TB_SERVICOS";

    public DaoServico(@Nullable Context context)
    {
        super(context, "db_buzztec", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db_buzztec)
    {
        String strquery = "Create Table " +TABELA_SERVICO+ "(" +
                "Id MEDIUMINT primary key autoincrement," +
                "Nm_servico VARCHAR(60) not null," +
                "Desc_servico VARCHAR(255) not null)";
        db_buzztec.execSQL(strquery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long CadastrarServico(DtoServico dtoServico)
    {
        ContentValues dados = Colunas(dtoServico);

        return getWritableDatabase().insert(TABELA_SERVICO, null, dados);
    }

    private ContentValues Colunas(DtoServico dtoServico)
    {
        ContentValues dados = new ContentValues();
        dados.put("Tipo", dtoServico.getTp_servico());
        dados.put("Servico", dtoServico.getNm_servico());
        dados.put("DescServico", dtoServico.getDesc_servico());
        return dados;
    }
}