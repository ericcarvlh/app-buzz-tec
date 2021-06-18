package com.example.buzztec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.buzztec.dao.DaoAtividade;
import com.example.buzztec.dto.DtoAtividade;

public class AtividadeActivity extends AppCompatActivity
{
    Button buttonCadastrar;
    EditText editTextDataIni, editTextDataTer,
    editTextConsultor, editTextCliente, editTextDesc;
    DtoAtividade dtoAtividade = new DtoAtividade();
    DaoAtividade daoAtividade = new DaoAtividade(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade);

        buttonCadastrar   = findViewById(R.id.buttonCadastrarAtividade_atividade);

        editTextDataIni   = findViewById(R.id.editTextDataInicio_atividade);
        editTextDataTer   = findViewById(R.id.editTextDataTermino_atividade);
        editTextCliente   = findViewById(R.id.editTextNmCliente_atividade);
        editTextConsultor = findViewById(R.id.editTextNmConsultor_atividade);
        editTextDesc      = findViewById(R.id.editTextDesc_atividade);

        buttonCadastrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dtoAtividade.setDataInicio(editTextDataIni.getText().toString());
                dtoAtividade.setDataTermino(editTextDataTer.getText().toString());
                dtoAtividade.setNm_cliente(editTextCliente.getText().toString());
                dtoAtividade.setNm_consultor(editTextConsultor.getText().toString());
                dtoAtividade.setDesc_atividade(editTextDesc.getText().toString());
                
                try
                {
                    long addAtividade = daoAtividade.CadastrarAtividade(dtoAtividade);
                    if(addAtividade > 0)
                    {
                        Toast.makeText(AtividadeActivity.this, "Sucesso!", Toast.LENGTH_SHORT).show();
                        Intent voltar = new Intent(AtividadeActivity.this, MenuActivity.class);
                        startActivity(voltar);
                    }
                    else
                        Toast.makeText(AtividadeActivity.this, "Erro ao cadastrar.", Toast.LENGTH_SHORT).show();
                }
                catch (Exception ex)
                {
                    Toast.makeText(AtividadeActivity.this, "Erro fatal" +ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}