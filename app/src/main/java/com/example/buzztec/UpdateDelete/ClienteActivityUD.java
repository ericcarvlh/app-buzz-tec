package com.example.buzztec.UpdateDelete;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.buzztec.MenuActivity;
import com.example.buzztec.R;
import com.example.buzztec.dao.DaoCliente;
import com.example.buzztec.dto.DtoCliente;

public class ClienteActivityUD extends AppCompatActivity
{
    ImageButton buttonAlterar, buttonDeletar;
    EditText editTextNome, editTextEmail, editTextTelefone, editTextCodigo;
    int Id;
    DtoCliente dto = new DtoCliente();
    DaoCliente dao = new DaoCliente(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_ud);

        this.setTitle("Cliente");

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
        editTextCodigo.setText(puxarDados.getString("Cd_cliente"));

        buttonAlterar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dto.setId(Id);
                dto.setEmail(editTextEmail.getText().toString());
                dto.setNome(editTextNome.getText().toString());
                dto.setTelefone(editTextTelefone.getText().toString());
                dto.setCd_cliente(editTextCodigo.getInputType());

                try
                {
                    long strQuery = dao.Alterar(dto);
                    RealizaComando(strQuery, ClienteActivityUD.this, MenuActivity.class);
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
                try
                {
                    long Query = dao.Excluir(Id);
                    RealizaComando(Query, ClienteActivityUD.this, MenuActivity.class);
                }
                catch (Exception ex)
                {
                    Toast.makeText(ClienteActivityUD.this, "Erro fatal" + ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void RealizaComando(long Query, Context context, Class clas)
    {
        if (Query > 0) {
            Toast.makeText(context, "Sucesso", Toast.LENGTH_SHORT).show();
            Intent voltar = new Intent(context, clas);
            startActivity(voltar);
        } else
            Toast.makeText(context, "Erro ao cadastrar", Toast.LENGTH_SHORT).show();
    }
}