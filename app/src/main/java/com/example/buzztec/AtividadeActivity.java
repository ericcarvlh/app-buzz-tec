package com.example.buzztec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.buzztec.UpdateDelete.AgendaActivityUD;
import com.example.buzztec.dao.DaoAtividade;
import com.example.buzztec.dao.DaoBanco;
import com.example.buzztec.dto.DtoAtividade;
import com.example.buzztec.dto.DtoBanco;

public class AtividadeActivity extends AppCompatActivity
{
    Button buttonCadastrar;
    EditText editTextDataIni, editTextDataTer,
    editTextConsultor, editTextCliente, editTextDesc;
    DtoAtividade dto = new DtoAtividade();
    DaoAtividade dao = new DaoAtividade(this);
    DtoBanco dtoB = new DtoBanco();

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
                dto.setDataInicio(editTextDataIni.getText().toString());
                dto.setDataTermino(editTextDataTer.getText().toString());
                dto.setNm_cliente(editTextCliente.getText().toString());
                dto.setNm_consultor(editTextConsultor.getText().toString());
                dto.setDesc_atividade(editTextDesc.getText().toString());
                
                try
                {
                    long Query = dao.CadastrarAtividade(dto);
                    dtoB.RealizaComando(Query, AtividadeActivity.this, MenuActivity.class);

                }
                catch (Exception ex)
                {
                    Toast.makeText(AtividadeActivity.this, "Erro fatal" +ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}