package com.example.buzztec.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.buzztec.dto.DtoLogin;
import com.example.buzztec.dto.DtoServico;

import java.util.ArrayList;
import java.util.List;

public class DaoBanco extends SQLiteOpenHelper
{
    public DaoBanco(@Nullable Context context)
    {
        super(context, "db_buzztec", null, 1);
    }
    public final String TABELA_AGENDA    = "TB_AGENDA";
    public final String TABELA_SERVICO   = "TB_SERVICOS";
    public final String TABELA_CLIENTE   = "TB_CLIENTE";
    public final String TABELA_ATIVIDADE = "TB_ATIVIDADE";
    public final String TABELA_CONSULTOR = "TB_CONSULTOR";
    public final String TABELA_LOGIN     = "TB_LOGIN";

    @Override
    public void onCreate(SQLiteDatabase db_buzztec)
    {
        String strquery = "CREATE TABLE " +TABELA_LOGIN+ "(" +
                "Id INTEGER primary key," +
                "Usuario_login varchar(10) not null UNIQUE," +
                "Senha_login varchar(10) not null)";
        db_buzztec.execSQL(strquery);
        strquery = "CREATE TABLE " +TABELA_AGENDA+ "(" +
                "Id INTEGER primary key," +
                "Data_agenda DATE not null," +
                "Nm_cliente VARCHAR(60) not null," +
                "Local_agenda VARCHAR(100) not null," +
                "Nm_consultor VARCHAR(60) not null," +
                "Desc_agenda VARCHAR(255) not null)";
        db_buzztec.execSQL(strquery);
        strquery = "Create Table " +TABELA_ATIVIDADE+ "(" +
                "Id INTEGER primary key," +
                "Data_inicio DATE not null," +
                "Data_termino DATE not null," +
                "Nm_consultor VARCHAR(60) not null," +
                "Nm_cliente VARCHAR(60) not null," +
                "Desc_atividade VARCHAR(255) not null)";
        db_buzztec.execSQL(strquery);
        strquery = "Create Table " +TABELA_CLIENTE+ "(" +
                "Id INTEGER primary key," +
                "Cd_cliente MEDIUMINT not null," +
                "Nm_cliente VARCHAR(60) not null," +
                "Tell_cliente VARCHAR(10) not null," +
                "Email_cliente VARCHAR(60) not null)";
        db_buzztec.execSQL(strquery);
        strquery = "Create table " +TABELA_CONSULTOR+ "(" +
                "Id INTEGER primary key," +
                "Nm_consultor VARCHAR(60) not null," +
                "Tell_consultor VARCHAR(10) not null," +
                "Email_consultor VARCHAR(60) not null, " +
                "Cargo_consultor VARCHAR(30) not null)";
        db_buzztec.execSQL(strquery);
        strquery = "Create Table " +TABELA_SERVICO+ "(" +
                "Id INTEGER primary key," +
                "Tp_servico VARCHAR(60) not null," +
                "Nm_servico VARCHAR(60) not null," +
                "Desc_servico VARCHAR(255) not null)";
        db_buzztec.execSQL(strquery);
        strquery = "INSERT INTO "+TABELA_LOGIN+" VALUES" +
                "(1, 'eriquin', '1234567')," +
                "(2, 'leozin', '12345678')";
        db_buzztec.execSQL(strquery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db_buzztec, int oldVersion, int newVersion)
    {

    }

    public long ConsultarLogin(String usuario, String senha)
    {
        String comando = "select * from "+TABELA_LOGIN+" where usuario_Login = ? and senha_login = ?";
        String[] args = {""+usuario+"", ""+senha+""};
        Cursor analise = getReadableDatabase().rawQuery(comando, args);
        if(analise.getCount() > 0)
        {return 1;}
        else
        {return 0;}
    }
}
