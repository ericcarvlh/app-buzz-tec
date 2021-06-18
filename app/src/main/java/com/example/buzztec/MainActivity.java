package com.example.buzztec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.buzztec.dao.DaoBanco;
import com.example.buzztec.dto.DtoLogin;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    Button buttonEntrar;
    EditText editTextUsuario, editTextSenha;
    DaoBanco daoBanco = new DaoBanco(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEntrar    = findViewById(R.id.buttonEntrar_login);

        editTextSenha   = findViewById(R.id.editTextSenha_login);
        editTextUsuario = findViewById(R.id.editTextUsuario_login);

        buttonEntrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String usuario = editTextUsuario.getText().toString();
                String senha = editTextSenha.getText().toString();
                Long ConsultaUsu = daoBanco.ConsultarUsuario(usuario, senha);
                if(ConsultaUsu > 0 )
                {
                        Intent prox = new Intent(MainActivity.this, MenuActivity.class);
                        Toast.makeText(MainActivity.this, "sucesso", Toast.LENGTH_SHORT).show();
                        startActivity(prox);
                }
                else
                    Toast.makeText(MainActivity.this, "usuario inválido", Toast.LENGTH_SHORT).show();
            }
        });
    }
}