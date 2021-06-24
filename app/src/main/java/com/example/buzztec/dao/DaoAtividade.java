package com.example.buzztec.dao;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.buzztec.dto.DtoAgenda;
import com.example.buzztec.dto.DtoAtividade;

import java.util.ArrayList;

public class DaoAtividade extends SQLiteOpenHelper
{
    public final String TABELA_ATIVIDADE = "TB_ATIVIDADE";

    public DaoAtividade(@Nullable Context context) {
        super(context, "db_buzztec", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db_buzztec)
    {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db_buzztec, int oldVersion, int newVersion) {

    }

    public long CadastrarAtividade(DtoAtividade dto)
    {
        ContentValues dados = Colunas(dto);

        return getWritableDatabase().insert(TABELA_ATIVIDADE, null, dados);
    }

    public ArrayList<DtoAtividade> ConsultarTodos()
    {
        String comando = "SELECT * FROM " + TABELA_ATIVIDADE;
        Cursor analise = getReadableDatabase().rawQuery(comando, null);
        ArrayList<DtoAtividade> arraylist = new ArrayList<>();
        LeituraDeDados(analise, arraylist);

        return arraylist;
    }

    public int Excluir(int id)
    {
        String where = "id = "+id;
        return getReadableDatabase().delete(TABELA_ATIVIDADE, where, null);
    }

    public long Alterar(DtoAtividade dto)
    {
        ContentValues dados = Colunas(dto);
        String id = "id = ?";
        String[] args = {dto.getId()+""};

        return getWritableDatabase().update(TABELA_ATIVIDADE, dados, id, args);
    }


    private void LeituraDeDados(Cursor analise, ArrayList arraylist)
    {
        while (analise.moveToNext())
        {
            DtoAtividade dto = new DtoAtividade();

            dto.setId(analise.getInt(0));
            dto.setDataInicio(analise.getString(1));
            dto.setDataTermino(analise.getString(2));
            dto.setNm_consultor(analise.getString(3));
            dto.setNm_cliente(analise.getString(4));
            dto.setDesc_atividade(analise.getString(5));

            arraylist.add(dto);
        }
    }

    private ContentValues Colunas(DtoAtividade dtoAtividade)
    {
        ContentValues dados = new ContentValues();
        dados.put("Data_inicio", dtoAtividade.getDataInicio());
        dados.put("Data_termino", dtoAtividade.getDataTermino());
        dados.put("Nm_consultor",  dtoAtividade.getNm_consultor());
        dados.put("Nm_cliente",  dtoAtividade.getNm_cliente());
        dados.put("Desc_atividade",  dtoAtividade.getDesc_atividade());
        return dados;
    }

    public void EnviaColunasUD(Intent detalhes, DtoAtividade dto)
    {
        detalhes.putExtra("Id", dto.getId());
        detalhes.putExtra("Nm_cliente", dto.getNm_cliente());
        detalhes.putExtra("Nm_consultor", dto.getNm_consultor());
        detalhes.putExtra("Data_inicio", dto.getDataInicio());
        detalhes.putExtra("Data_termino", dto.getDataTermino());
        detalhes.putExtra("Desc_atividade", dto.getDesc_atividade());
    }

}
