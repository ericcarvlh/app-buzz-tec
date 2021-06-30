package com.example.buzztec.UpdateDelete;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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
import com.example.buzztec.dao.DaoCliente;
import com.example.buzztec.dto.DtoBanco;
import com.example.buzztec.dto.DtoCliente;

public class ClienteActivityUD extends AppCompatActivity
{
    ImageButton buttonAlterar, buttonDeletar;
    EditText editTextNome, editTextEmail, editTextTelefone, editTextCodigo;
    int Id;
    DtoCliente dto = new DtoCliente();
    DaoCliente dao = new DaoCliente(this);
    DaoBanco  daoB = new DaoBanco(this);
    DtoBanco  dtoB = new DtoBanco();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_ud);

        editTextEmail    = findViewById(R.id.editTextEmail_cliente);
        editTextNome     = findViewById(R.id.editTextNome_cliente);
        editTextTelefone = findViewById(R.id.editTextTelefone_cliente);
        editTextCodigo   = findViewById(R.id.editTextCodigo_cliente);

        buttonAlterar = findViewById(R.id.buttonAlterar_UD);
        buttonDeletar = findViewById(R.id.buttonDeletar_UD);

        Bundle puxarDados = getIntent().getExtras();
        Id = puxarDados.getInt("Id");
        editTextEmail.setText(puxarDados.getString("Email_cliente"));
        editTextNome.setText(puxarDados.getString("Nm_cliente"));
        editTextTelefone.setText(puxarDados.getString("Tell_cliente"));
        editTextCodigo.setText(puxarDados.getInt("Cd_cliente")+"");

        buttonAlterar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dto.setId(Id);
                dto.setEmail(editTextEmail.getText().toString());
                dto.setNome(editTextNome.getText().toString());
                dto.setTelefone(editTextTelefone.getText().toString());
                dto.setCd_cliente(Integer.parseInt(editTextCodigo.getText().toString()));

                try
                {
                    long strQuery = dao.Alterar(dto);
                    dtoB.RealizaComando(strQuery, ClienteActivityUD.this, ConsultaActivity.class);
                }
                catch (Exception ex)
                {
                    Toast.makeText(ClienteActivityUD.this, "Erro fatal" + ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        buttonDeletar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                long Query = dao.Excluir(Id);
                daoB.AlertaExclusao(ClienteActivityUD.this, ConsultaActivity.class, Query);
            }
        });
    }
}