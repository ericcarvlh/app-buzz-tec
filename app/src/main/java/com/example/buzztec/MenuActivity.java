package com.example.buzztec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MenuActivity extends AppCompatActivity
{
    ImageButton buttonCliente, buttonServico, buttonConsulta, buttonConsultor;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        buttonCliente = findViewById(R.id.buttonCliente_menu);
        buttonServico = findViewById(R.id.buttonServico_menu);
        buttonConsulta = findViewById(R.id.buttonConsulta_menu);
        buttonConsultor = findViewById(R.id.buttonConsultor_menu);

        buttonCliente.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent tela_cliente = new Intent(MenuActivity.this, ClienteActivity.class);
                startActivity(tela_cliente);
            }
        });
        buttonServico.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent tela_servico = new Intent(MenuActivity.this, ServicoActivity.class);
                startActivity(tela_servico);
            }
        });
        buttonConsulta.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent tela_consulta = new Intent(MenuActivity.this, ConsultorActivity.class);
                startActivity(tela_consulta);
            }
        });
        buttonConsultor.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent tela_consultor = new Intent(MenuActivity.this, ConsultorActivity.class);
                startActivity(tela_consultor);
            }
        });
    }
}