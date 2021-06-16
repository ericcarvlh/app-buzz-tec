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
        String strquery = "CREATE TABLE " +TABELA_AGENDA+ "(" +
                "Id MEDIUMINT primary key autoincrement," +
                "Data_agenda DATE not null," +
                "Nm_cliente VARCHAR(60) not null," +
                "Local_agenda VARCHAR(100) not null," +
                "Nm_consultor VARCHAR(60) not null," +
                "Desc_agenda VARCHAR(255) not null)";
        db_buzztec.execSQL(strquery);
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
        dados.put("Cliente", dtoAgenda.getNm_cliente());
        dados.put("Consultor", dtoAgenda.getNm_consultor());
        dados.put("Local", dtoAgenda.getLocal_agenda());
        dados.put("Data", String.valueOf(dtoAgenda.getData()));
        dados.put("DescAgenda", dtoAgenda.getDesc_agenda());
        return dados;
    }
}
