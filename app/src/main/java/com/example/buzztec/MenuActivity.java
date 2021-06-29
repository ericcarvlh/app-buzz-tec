package com.example.buzztec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity
{
    Button buttonCliente, buttonServico, buttonConsulta,
    buttonConsultor, buttonAgenda, buttonAtividade, buttonSobre,
    buttonLocalizacao;
    String nome  = "";
    TextView textviewNome;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        buttonCliente     = findViewById(R.id.buttonCliente_menu);
        buttonServico     = findViewById(R.id.buttonServico_menu);
        buttonConsulta    = findViewById(R.id.buttonConsulta_menu);
        buttonConsultor   = findViewById(R.id.buttonConsultor_menu);
        buttonAgenda      = findViewById(R.id.buttonAgenda_menu);
        buttonAtividade   = findViewById(R.id.buttonAtividade_menu);
        buttonSobre       = findViewById(R.id.buttonSobre_menu);
        buttonLocalizacao = findViewById(R.id.buttonLocalizacao_menu);

        textviewNome     = findViewById(R.id.textviewNome);

        Intent menu = getIntent();
        Bundle Nm = menu.getExtras();
        nome      = Nm.getString("name");

        if(!nome.equals(""))
            textviewNome.setText((nome));

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
                Intent tela_consulta = new Intent(MenuActivity.this, ConsultaActivity.class);
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
        buttonAgenda.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent tela_agenda = new Intent(MenuActivity.this, AgendaActivity.class);
                startActivity(tela_agenda);
            }
        });
        buttonAtividade.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent tela_atividade = new Intent(MenuActivity.this, AtividadeActivity.class);
                startActivity(tela_atividade);
            }
        });
        buttonSobre.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent tela_sobre = new Intent(MenuActivity.this, SobreActivity.class);
                startActivity(tela_sobre);
            }
        });
        buttonLocalizacao.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent tela_localizacao = new Intent(MenuActivity.this, LocalizacaoActivity.class);
                startActivity(tela_localizacao);
            }
        });
    }
}