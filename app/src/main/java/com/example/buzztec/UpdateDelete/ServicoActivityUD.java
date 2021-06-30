package com.example.buzztec.UpdateDelete;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.buzztec.ConsultaActivity;
import com.example.buzztec.MenuActivity;
import com.example.buzztec.R;
import com.example.buzztec.dao.DaoBanco;
import com.example.buzztec.dao.DaoServico;
import com.example.buzztec.dto.DtoBanco;
import com.example.buzztec.dto.DtoServico;

public class ServicoActivityUD extends AppCompatActivity
{
    EditText editTextDesc, editTextTipo, editTextNomeS;
    ImageButton buttonAlterar, buttonDeletar;
    int Id;
    DaoServico dao = new DaoServico(this);
    DtoServico dto = new DtoServico();
    DaoBanco  daoB = new DaoBanco(this);
    DtoBanco  dtoB = new DtoBanco();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servico_ud);

        editTextDesc    = findViewById(R.id.editTextDesc_servico);
        editTextTipo    = findViewById(R.id.editTextTipo_servico);
        editTextNomeS   = findViewById(R.id.editTextNmServico_servico);

        buttonAlterar = findViewById(R.id.buttonAlterar_UD);
        buttonDeletar = findViewById(R.id.buttonDeletar_UD);

        Bundle puxarDados = getIntent().getExtras();
        Id = puxarDados.getInt("Id");
        editTextDesc.setText(puxarDados.getString("Desc_servico"));
        editTextNomeS.setText(puxarDados.getString("Nm_servico"));
        editTextTipo.setText(puxarDados.getString("Tp_servico"));

        buttonAlterar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dto.setId(Id);
                dto.setDesc_servico(editTextDesc.getText().toString());
                dto.setNm_servico(editTextNomeS.getText().toString());
                dto.setTp_servico(editTextTipo.getText().toString());

                try
                {
                    long Query = dao.Alterar(dto);
                    dtoB.RealizaComando(Query,ServicoActivityUD.this, ConsultaActivity.class);
                }
                catch (Exception ex)
                {
                    Toast.makeText(ServicoActivityUD.this, "Erro fatal" + ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        buttonDeletar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                long Query = dao.Excluir(Id);
                daoB.AlertaExclusao(ServicoActivityUD.this, ConsultaActivity.class, Query);
            }
        });

    }
}