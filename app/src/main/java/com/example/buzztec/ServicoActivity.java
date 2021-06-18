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
import com.example.buzztec.dto.DtoServico;

public class ServicoActivity extends AppCompatActivity
{
    Button buttonCadastrar;
    EditText editTextTipo, editTextNomeS, editTextDesc;
    DtoServico dtoServico = new DtoServico();
    //DaoServico daoServico = new DaoServico(this);
    DaoBanco daoBanco = new DaoBanco(this);

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
                dtoServico.setDesc_servico(editTextDesc.getText().toString());
                dtoServico.setTp_servico(editTextTipo.getText().toString());
                dtoServico.setNm_servico(editTextNomeS.getText().toString());

                try
                {
                    long addServico = daoBanco.CadastrarServico(dtoServico);
                    if(addServico > 0)
                    {
                        Toast.makeText(ServicoActivity.this, "Sucesso", Toast.LENGTH_SHORT).show();
                        Intent voltar = new Intent(ServicoActivity.this, MenuActivity.class);
                        startActivity(voltar);
                    }
                    else
                        Toast.makeText(ServicoActivity.this, "Erro ao cadastrar", Toast.LENGTH_SHORT).show();
                }
                catch (Exception ex)
                {
                    Toast.makeText(ServicoActivity.this, "Erro fatal" + ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}