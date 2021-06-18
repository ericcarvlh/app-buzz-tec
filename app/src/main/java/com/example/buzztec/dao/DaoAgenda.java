package com.example.buzztec.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.buzztec.dto.DtoAgenda;

public class DaoAgenda extends SQLiteOpenHelper
{
    public final String TABELA_AGENDA    = "TB_AGENDA";

    public DaoAgenda(@Nullable Context context) {
        super(context, "db_buzztec", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db_buzztec)
    {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
    }


    public long CadastrarConsultor(DtoAgenda dtoAgenda)
    {
        ContentValues dados = Colunas(dtoAgenda);

        return getWritableDatabase().insert(TABELA_AGENDA, null, dados);
    }

    private ContentValues Colunas(DtoAgenda dtoAgenda)
    {
        ContentValues dados = new ContentValues();
        dados.put("Nm_cliente", dtoAgenda.getNm_cliente());
        dados.put("Nm_consultor", dtoAgenda.getNm_consultor());
        dados.put("Local_agenda", dtoAgenda.getLocal_agenda());
        dados.put("Data_agenda", String.valueOf(dtoAgenda.getData()));
        dados.put("Desc_agenda", dtoAgenda.getDesc_agenda());
        return dados;
    }
}
