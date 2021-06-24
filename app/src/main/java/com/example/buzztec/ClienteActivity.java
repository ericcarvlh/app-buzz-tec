package com.example.buzztec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.buzztec.dao.DaoBanco;
import com.example.buzztec.dao.DaoCliente;
import com.example.buzztec.dto.DtoCliente;

public class ClienteActivity extends AppCompatActivity
{
    Button buttonCadastrar;
    EditText editTextNome, editTextEmail, editTextTelefone, editTextCodigo;
    DtoCliente dto = new DtoCliente();
    DaoCliente dao = new DaoCliente(this);
    DaoBanco  daoB = new DaoBanco(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);

        this.setTitle("Cliente");

        buttonCadastrar  = findViewById(R.id.buttonCadastrarConsultor_cliente);

        editTextEmail    = findViewById(R.id.editTextEmail_cliente);
        editTextNome     = findViewById(R.id.editTextNome_cliente);
        editTextTelefone = findViewById(R.id.editTextTelefone_cliente);
        editTextCodigo   = findViewById(R.id.editTextCodigo_cliente);

        buttonCadastrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dto.setCd_cliente(Integer.parseInt(editTextCodigo.getText().toString()));
                dto.setNome(editTextNome.getText().toString());
                dto.setTelefone(editTextTelefone.getText().toString());
                dto.setEmail(editTextEmail.getText().toString());

                try
                {
                    long Query = dao.CadastrarCliente(dto);
                    daoB.RealizaComando(Query, ClienteActivity.this, MenuActivity.class);
                }
                catch (Exception ex)
                {
                    Toast.makeText(ClienteActivity.this, "Erro fatal" + ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}