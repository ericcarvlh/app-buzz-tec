package com.example.buzztec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    Button buttonEntrar;
    EditText editTextUsuario, editTextSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEntrar    = findViewById(R.id.buttonEntrar_login);

        editTextSenha   = findViewById(R.id.editTextSenha_login);
        editTextUsuario = findViewById(R.id.editTextUsuario_login);

    }
}