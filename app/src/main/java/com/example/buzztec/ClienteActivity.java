package com.example.buzztec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.buzztec.dao.DaoCliente;
import com.example.buzztec.dto.DtoCliente;

public class ClienteActivity extends AppCompatActivity
{
    Button buttonCadastrar;
    EditText editTextNome, editTextEmail, editTextTelefone, editTextCodigo;
    DtoCliente dtoCliente = new DtoCliente();
    DaoCliente daoCliente = new DaoCliente(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);

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
                dtoCliente.setCd_cliente(Integer.parseInt(editTextCodigo.getText().toString()));
                dtoCliente.setNome(editTextNome.getText().toString());
                dtoCliente.setTelefone(editTextTelefone.getText().toString());
                dtoCliente.setEmail(editTextEmail.getText().toString());

                try
                {
                    long addCliente = daoCliente.CadastrarCliente(dtoCliente);
                    if(addCliente > 0)
                    {
                        Toast.makeText(ClienteActivity.this, "Sucesso", Toast.LENGTH_SHORT).show();
                        Intent voltar = new Intent(ClienteActivity.this, MenuActivity.class);
                        startActivity(voltar);
                    }
                    else
                        Toast.makeText(ClienteActivity.this, "Erro ao cadastrar", Toast.LENGTH_SHORT).show();
                }
                catch (Exception ex)
                {
                    Toast.makeText(ClienteActivity.this, "Erro fatal" + ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}