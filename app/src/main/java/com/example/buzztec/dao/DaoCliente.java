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
import com.example.buzztec.dto.DtoCliente;

import java.util.ArrayList;

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

    public long CadastrarCliente(DtoCliente dto)
    {
        ContentValues dados = Colunas(dto);

        return getWritableDatabase().insert(TABELA_CLIENTE, null, dados);
    }

    public ArrayList<DtoCliente> ConsultarTodos()
    {
        String comando = "SELECT * FROM " + TABELA_CLIENTE;
        Cursor analise = getReadableDatabase().rawQuery(comando, null);
        ArrayList<DtoCliente> arraylist = new ArrayList<>();
        LeituraDeDados(analise, arraylist);

        return arraylist;
    }

    public int Excluir(int id)
    {
        String where = "id = "+id;
        return getReadableDatabase().delete(TABELA_CLIENTE, where, null);
    }

    public long Alterar(DtoCliente dto)
    {
        ContentValues dados = Colunas(dto);
        String id = "id = ?";
        String[] args = {dto.getId()+""};

        return getWritableDatabase().update(TABELA_CLIENTE, dados, id, args);
    }

    private void LeituraDeDados(Cursor analise, ArrayList arraylist)
    {
        while (analise.moveToNext())
        {
            DtoCliente dto = new DtoCliente();

            dto.setId(analise.getInt(0));
            dto.setCd_cliente(analise.getInt(1));
            dto.setNome(analise.getString(2));
            dto.setTelefone(analise.getString(3));
            dto.setEmail(analise.getString(4));

            arraylist.add(dto);
        }
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

    public void EnviaColunasUD(Intent detalhes, DtoCliente dto)
    {
        detalhes.putExtra("Id", dto.getId());
        detalhes.putExtra("Nm_cliente", dto.getNome());
        detalhes.putExtra("Email_cliente", dto.getEmail());
        detalhes.putExtra("Tell_cliente", dto.getTelefone());
        detalhes.putExtra("Cd_cliente", dto.getCd_cliente());
    }
}
