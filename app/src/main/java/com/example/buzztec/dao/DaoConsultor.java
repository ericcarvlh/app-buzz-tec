package com.example.buzztec.dao;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.buzztec.dto.DtoCliente;
import com.example.buzztec.dto.DtoConsultor;
import com.example.buzztec.dto.DtoServico;

import java.util.ArrayList;

public class DaoConsultor extends SQLiteOpenHelper
{
    public final String TABELA_CONSULTOR = "TB_CONSULTOR";

    public DaoConsultor(@Nullable Context context)
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
    public long CadastrarConsultor(DtoConsultor dtoConsultor)
    {
        ContentValues dados = Colunas(dtoConsultor);

        return getWritableDatabase().insert(TABELA_CONSULTOR, null, dados);
    }

    public ArrayList<DtoConsultor> ConsultarTodos()
    {
        String comando = "SELECT * FROM " + TABELA_CONSULTOR;
        Cursor analise = getReadableDatabase().rawQuery(comando, null);
        ArrayList<DtoConsultor> arraylist = new ArrayList<>();
        LeituraDeDados(analise, arraylist);

        return arraylist;
    }

    public int Excluir(DtoConsultor dto)
    {
        String id = "id = ?";
        String[] Dellonde = {dto.getId()+""};
        return getReadableDatabase().delete(TABELA_CONSULTOR, id, Dellonde);
    }

    public long Alterar(DtoConsultor dto)
    {
        ContentValues dados = Colunas(dto);
        String id = "id = ?";
        String[] args = {dto.getId()+""};

        return getWritableDatabase().update(TABELA_CONSULTOR, dados, id, args);
    }

    private void LeituraDeDados(Cursor analise, ArrayList arraylist)
    {
        while (analise.moveToNext())
        {
            DtoConsultor dto = new DtoConsultor();

            dto.setId(analise.getInt(0));
            dto.setNome(analise.getString(1));
            dto.setTelefone(analise.getString(2));
            dto.setEmail(analise.getString(3));
            dto.setCargo(analise.getString(4));

            arraylist.add(dto);
        }
    }

    private ContentValues Colunas(DtoConsultor dtoConsultor)
    {
        ContentValues dados = new ContentValues();
        dados.put("Nm_consultor", dtoConsultor.getNome());
        dados.put("Tell_consultor", dtoConsultor.getTelefone());
        dados.put("Email_consultor", dtoConsultor.getEmail());
        dados.put("Cargo_consultor", dtoConsultor.getCargo());
        return dados;
    }

    public void EnviaColunasUD(Intent detalhes, DtoConsultor dto)
    {
        detalhes.putExtra("Id", dto.getId());
        detalhes.putExtra("Nm_consultor", dto.getNome());
        detalhes.putExtra("Tell_consultor", dto.getTelefone());
        detalhes.putExtra("Email_consultor", dto.getEmail());
        detalhes.putExtra("Cargo_consultor", dto.getCargo());
    }
}
