package com.example.buzztec.UpdateDelete;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.buzztec.ConsultaActivity;
import com.example.buzztec.MenuActivity;
import com.example.buzztec.R;
import com.example.buzztec.dao.DaoAtividade;
import com.example.buzztec.dao.DaoBanco;
import com.example.buzztec.dto.DtoAtividade;
import com.example.buzztec.dto.DtoBanco;

public class AtividadeActivityUD extends AppCompatActivity
{
    ImageButton buttonAlterar, buttonDeletar;
    int Id;
    EditText editTextDataIni, editTextDataTer,
    editTextConsultor, editTextCliente, editTextDesc;
    DtoAtividade dto = new DtoAtividade();
    DaoAtividade dao = new DaoAtividade(this);
    DaoBanco    daoB = new DaoBanco(this);
    DtoBanco    dtoB = new DtoBanco();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade_ud);

        editTextDataIni   = findViewById(R.id.editTextDataInicio_atividade);
        editTextDataTer   = findViewById(R.id.editTextDataTermino_atividade);
        editTextCliente   = findViewById(R.id.editTextNmCliente_atividade);
        editTextConsultor = findViewById(R.id.editTextNmConsultor_atividade);
        editTextDesc      = findViewById(R.id.editTextDesc_atividade);

        buttonAlterar = findViewById(R.id.buttonAlterar_UD);
        buttonDeletar = findViewById(R.id.buttonDeletar_UD);

        Bundle puxarDados = getIntent().getExtras();
        Id = puxarDados.getInt("Id");
        editTextDataIni.setText(puxarDados.getString("Data_inicio"));
        editTextDataTer.setText(puxarDados.getString("Data_termino"));
        editTextCliente.setText(puxarDados.getString("Nm_cliente"));
        editTextConsultor.setText(puxarDados.getString("Nm_consultor"));
        editTextDesc.setText(puxarDados.getString("Desc_atividade"));

        buttonAlterar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dto.setId(Id);
                dto.setDataTermino(editTextDataTer.getText().toString());
                dto.setDataInicio(editTextDataIni.getText().toString());
                dto.setNm_cliente(editTextCliente.getText().toString());
                dto.setNm_consultor(editTextConsultor.getText().toString());
                dto.setDesc_atividade(editTextDesc.getText().toString());

                try
                {
                    long Query = dao.Alterar(dto);
                    dtoB.RealizaComando(Query, AtividadeActivityUD.this, ConsultaActivity.class);
                }
                catch (Exception ex)
                {
                    Toast.makeText(AtividadeActivityUD.this, "Erro fatal" + ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        buttonDeletar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                long Query = dao.Excluir(Id);
                daoB.AlertaExclusao(AtividadeActivityUD.this, ConsultaActivity.class, Query);
            }
        });
    }
}