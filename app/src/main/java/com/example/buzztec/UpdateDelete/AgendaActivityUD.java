package com.example.buzztec.UpdateDelete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.buzztec.ConsultaActivity;
import com.example.buzztec.R;
import com.example.buzztec.dao.DaoAgenda;
import com.example.buzztec.dao.DaoBanco;
import com.example.buzztec.dto.DtoAgenda;
import com.example.buzztec.dto.DtoBanco;

public class AgendaActivityUD extends AppCompatActivity
{
    ImageButton buttonAlterar, buttonDeletar;
    int Id;
    EditText editTextData, editTextCliente,
    editTextConsultor, editTextLocal, editTextDesc;
    DaoAgenda dao = new DaoAgenda(this);
    DtoBanco dtoB = new DtoBanco();
    DaoBanco daoB = new DaoBanco(this);
    DtoAgenda dto = new DtoAgenda();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_ud);

        editTextCliente   = findViewById(R.id.editTextNmCliente_agenda);
        editTextConsultor = findViewById(R.id.editTextNmConsultor_agenda);
        editTextData      = findViewById(R.id.editTextData_agenda);
        editTextLocal     = findViewById(R.id.editTextLocal_agenda);
        editTextDesc      = findViewById(R.id.editTextDesc_agenda);

        buttonAlterar = findViewById(R.id.buttonAlterar_UD);
        buttonDeletar = findViewById(R.id.buttonDeletar_UD);

        Bundle puxarDados = getIntent().getExtras();
        Id = puxarDados.getInt("Id");
        editTextData.setText(puxarDados.getString("Data_agenda"));
        editTextLocal.setText(puxarDados.getString("Local_agenda"));
        editTextCliente.setText(puxarDados.getString("Nm_cliente"));
        editTextConsultor.setText(puxarDados.getString("Nm_consultor"));
        editTextDesc.setText(puxarDados.getString("Desc_agenda"));

        buttonAlterar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dto.setId(Id);
                dto.setNm_consultor(editTextConsultor.getText().toString());
                dto.setDesc_agenda(editTextDesc.getText().toString());
                dto.setLocal_agenda(editTextLocal.getText().toString());
                dto.setData_agenda(editTextData.getText().toString());
                dto.setNm_cliente(editTextCliente.getText().toString());

                try
                {
                    long strQuery = dao.Alterar(dto);
                    dtoB.RealizaComando(strQuery, AgendaActivityUD.this, ConsultaActivity.class);
                }
                catch (Exception ex)
                {
                    Toast.makeText(AgendaActivityUD.this, "Erro fatal" + ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        buttonDeletar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                long Query = dao.Excluir(Id);
                daoB.AlertaExclusao(AgendaActivityUD.this, ConsultaActivity.class, Query);
            }
        });
    }

}