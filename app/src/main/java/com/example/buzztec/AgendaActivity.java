package com.example.buzztec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.buzztec.dao.DaoAgenda;
import com.example.buzztec.dao.DaoBanco;
import com.example.buzztec.dto.DtoAgenda;


public class AgendaActivity extends AppCompatActivity
{
    Button buttonCadastrar;
    EditText editTextData, editTextCliente,
    editTextConsultor, editTextLocal, editTextDesc;
    DaoAgenda dao = new DaoAgenda(this);
    DtoAgenda dto = new DtoAgenda();
    DaoBanco daoB = new DaoBanco(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        this.setTitle("Agenda");

        buttonCadastrar   = findViewById(R.id.buttonCadastrarAgenda_agenda);

        editTextCliente   = findViewById(R.id.editTextNmCliente_agenda);
        editTextConsultor = findViewById(R.id.editTextNmConsultor_agenda);
        editTextData      = findViewById(R.id.editTextData_agenda);
        editTextLocal     = findViewById(R.id.editTextLocal_agenda);
        editTextDesc      = findViewById(R.id.editTextDesc_agenda);

        buttonCadastrar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                dto.setData_agenda(editTextData.getText().toString());
                dto.setNm_cliente(editTextCliente.getText().toString());
                dto.setNm_consultor(editTextConsultor.getText().toString());
                dto.setLocal_agenda(editTextLocal.getText().toString());
                dto.setDesc_agenda(editTextDesc.getText().toString());

                try
                {
                    long Query = dao.CadastrarAgenda(dto);
                    daoB.RealizaComando(Query, AgendaActivity.this, MenuActivity.class);
                }
                catch (Exception ex)
                {
                    Toast.makeText(AgendaActivity.this, "Erro fatal" +ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}