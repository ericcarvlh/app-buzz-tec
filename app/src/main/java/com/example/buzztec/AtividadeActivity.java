package com.example.buzztec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AtividadeActivity extends AppCompatActivity
{
    Button buttonCadastrar;
    EditText editTextDataIni, editTextDataTer,
    editTextConsultor, editTextCliente, editTextDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade);

        buttonCadastrar   = findViewById(R.id.buttonCadastrarAtividade_atividade);

        editTextDataIni   = findViewById(R.id.editTextDataInicio_atividade);
        editTextDataTer   = findViewById(R.id.editTextDataTermino_atividade);
        editTextCliente   = findViewById(R.id.editTextNmCliente_atividade);
        editTextConsultor = findViewById(R.id.editTextNmConsultor_atividade);
        editTextDesc      = findViewById(R.id.editTextDesc_atividade);
    }
}