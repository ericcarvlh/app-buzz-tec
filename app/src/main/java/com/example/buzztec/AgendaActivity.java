package com.example.buzztec;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.DateFormat;
import android.os.Build;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.buzztec.dao.DaoAgenda;
import com.example.buzztec.dto.DtoAgenda;

import java.text.ParseException;


public class AgendaActivity extends AppCompatActivity
{
    Button buttonCadastrar;
    EditText editTextData, editTextCliente,
    editTextConsultor, editTextLocal, editTextDesc;
    DaoAgenda daoAgenda = new DaoAgenda(this);
    DtoAgenda dtoAgenda = new DtoAgenda();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        buttonCadastrar   = findViewById(R.id.buttonCadastrarAgenda_agenda);

        editTextCliente   = findViewById(R.id.editTextNmCliente_agenda);
        editTextConsultor = findViewById(R.id.editTextNmConsultor_agenda);
        editTextData      = findViewById(R.id.editTextData_agenda);
        editTextLocal     = findViewById(R.id.editTextLocal_agenda);
        editTextDesc      = findViewById(R.id.editTextDesc_agenda);

        buttonCadastrar.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v)
            {
                dtoAgenda.setNm_cliente(editTextCliente.getText().toString());
                dtoAgenda.setNm_consultor(editTextConsultor.getText().toString());
                try {
                    dtoAgenda.setData(DateFormat.getTimeInstance().parse(editTextData.getText().toString()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                dtoAgenda.setLocal_agenda(editTextLocal.getText().toString());
                dtoAgenda.setDesc_agenda(editTextDesc.getText().toString());

                try
                {
                    long addAgenda = daoAgenda.CadastrarConsultor(dtoAgenda);
                    if(addAgenda > 0)
                    {
                        Toast.makeText(AgendaActivity.this, "Sucesso!", Toast.LENGTH_SHORT).show();
                        Intent voltar = new Intent(AgendaActivity.this, MenuActivity.class);
                        startActivity(voltar);
                    }
                    else
                        Toast.makeText(AgendaActivity.this, "Erro ao casastrar", Toast.LENGTH_SHORT).show();
                }
                catch (Exception ex)
                {
                    Toast.makeText(AgendaActivity.this, "Erro fatal" +ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}