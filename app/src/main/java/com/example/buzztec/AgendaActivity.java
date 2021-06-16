package com.example.buzztec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AgendaActivity extends AppCompatActivity
{
    Button buttonCadastrar;
    EditText editTextData, editTextCliente,
    editTextConsultor, editTextLocal, editTextDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        buttonCadastrar   = findViewById(R.id.buttonCadastrarAgenda_agenda);

        editTextCliente   = findViewById(R.id.editTextNmCliente_agenda);
        editTextConsultor = findViewById(R.id.editTextNmConsultor_agenda);
        editTextData      = findViewById(R.id.editTextData_agenda);
        editTextLocal     = findViewById(R.id.editTextLocal_agenda);
        editTextDesc      = findViewById(R.id.editTextDesc_agenda);
    }
}