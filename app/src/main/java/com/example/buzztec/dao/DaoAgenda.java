package com.example.buzztec.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.buzztec.dto.DtoAgenda;

import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;

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


    public long CadastrarConsultor(DtoAgenda dto)
    {
        ContentValues dados = Colunas(dto);

        return getWritableDatabase().insert(TABELA_AGENDA, null, dados);
    }

    public ArrayList<DtoAgenda> ConsultarTodos()
    {
        String comando = "SELECT * FROM " + TABELA_AGENDA;
        Cursor analise = getReadableDatabase().rawQuery(comando, null);
        ArrayList<DtoAgenda> arraylist = new ArrayList<>();
        LeituraDeDados(analise, arraylist);

        return arraylist;
    }

    public int Excluir(DtoAgenda dto)
    {
        String id = "id = ?";
        String[] Dellonde = {dto.getId()+""};
        return getReadableDatabase().delete(TABELA_AGENDA, id, Dellonde);
    }

    public long Alterar(DtoAgenda dto)
    {
        ContentValues dados = Colunas(dto);
        String id = "id = ?";
        String[] args = {dto.getId()+""};

        return getWritableDatabase().update(TABELA_AGENDA, dados, id, args);
    }

    private void LeituraDeDados(Cursor analise, ArrayList arraylistAgenda)
    {
        while (analise.moveToNext())
        {
            DtoAgenda dto = new DtoAgenda();

            dto.setId(analise.getInt(0));
            dto.setData_agenda(analise.getString(1));
            dto.setNm_cliente(analise.getString(2));
            dto.setLocal_agenda(analise.getString(3));
            dto.setNm_consultor(analise.getString(4));
            dto.setDesc_agenda(analise.getString(5));

            arraylistAgenda.add(dto);
        }
    }

    private ContentValues Colunas(DtoAgenda dtoAgenda)
    {
        ContentValues dados = new ContentValues();
        dados.put("Nm_cliente", dtoAgenda.getNm_cliente());
        dados.put("Nm_consultor", dtoAgenda.getNm_consultor());
        dados.put("Local_agenda", dtoAgenda.getLocal_agenda());
        dados.put("Data_agenda", dtoAgenda.getData_agenda());
        dados.put("Data", dtoAgenda.getData_agenda());
        dados.put("Desc_agenda", dtoAgenda.getDesc_agenda());
        return dados;
    }
}
