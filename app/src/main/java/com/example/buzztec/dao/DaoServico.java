package com.example.buzztec.dao;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.example.buzztec.dto.DtoCliente;
import com.example.buzztec.dto.DtoServico;

import java.util.ArrayList;

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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    public long CadastrarServico(DtoServico dto)
    {
        ContentValues dados = Colunas(dto);

        return getWritableDatabase().insert(TABELA_SERVICO, null, dados);
    }

    public ArrayList<DtoServico> ConsultarTodos()
    {
        String comando = "SELECT * FROM " + TABELA_SERVICO;
        Cursor analise = getReadableDatabase().rawQuery(comando, null);
        ArrayList<DtoServico> arraylist = new ArrayList<>();
        LeituraDeDados(analise, arraylist);

        return arraylist;
    }

    public int Excluir(int id)
    {
        String where = "id = "+id;
        return getReadableDatabase().delete(TABELA_SERVICO, where, null);
    }

    public long Alterar(DtoServico dto)
    {
        ContentValues dados = Colunas(dto);
        String id = "id = ?";
        String[] args = {dto.getId()+""};

        return getWritableDatabase().update(TABELA_SERVICO, dados, id, args);
    }

    private void LeituraDeDados(Cursor analise, ArrayList arraylist)
    {
        while (analise.moveToNext())
        {
            DtoServico dto = new DtoServico();

            dto.setId(analise.getInt(0));
            dto.setTp_servico(analise.getString(1));
            dto.setNm_servico(analise.getString(2));
            dto.setDesc_servico(analise.getString(3));

            arraylist.add(dto);
        }
    }

    private ContentValues Colunas(DtoServico dtoServico)
    {
        ContentValues dados = new ContentValues();
        dados.put("Tp_servico", dtoServico.getTp_servico());
        dados.put("Nm_servico", dtoServico.getNm_servico());
        dados.put("Desc_servico", dtoServico.getDesc_servico());
        return dados;
    }

    public void EnviaColunasUD(Intent detalhes, DtoServico dto)
    {
        detalhes.putExtra("Id", dto.getId());
        detalhes.putExtra("Nm_servico", dto.getNm_servico());
        detalhes.putExtra("Tp_servico", dto.getTp_servico());
        detalhes.putExtra("Desc_servico", dto.getDesc_servico());
    }
}
