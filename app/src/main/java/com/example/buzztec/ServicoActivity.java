package com.example.buzztec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.buzztec.dao.DaoBanco;
import com.example.buzztec.dao.DaoServico;
import com.example.buzztec.dto.DtoBanco;
import com.example.buzztec.dto.DtoServico;

public class ServicoActivity extends AppCompatActivity
{
    Button buttonCadastrar;
    EditText editTextTipo, editTextNomeS, editTextDesc;
    DtoServico dto = new DtoServico();
    DaoServico dao = new DaoServico(this);
    DtoBanco   dtoB = new DtoBanco();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servico);

        buttonCadastrar = findViewById(R.id.buttonCadastrarAtividade_servico);

        editTextDesc    = findViewById(R.id.editTextDesc_servico);
        editTextTipo    = findViewById(R.id.editTextTipo_servico);
        editTextNomeS   = findViewById(R.id.editTextNmServico_servico);

        buttonCadastrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dto.setDesc_servico(editTextDesc.getText().toString());
                dto.setTp_servico(editTextTipo.getText().toString());
                dto.setNm_servico(editTextNomeS.getText().toString());

                try
                {
                    long Query = dao.CadastrarServico(dto);
                    dtoB.RealizaComando(Query, ServicoActivity.this, MenuActivity.class);
                }
                catch (Exception ex)
                {
                    Toast.makeText(ServicoActivity.this, "Erro fatal" + ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}