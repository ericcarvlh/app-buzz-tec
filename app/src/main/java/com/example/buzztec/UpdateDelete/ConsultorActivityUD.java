package com.example.buzztec.UpdateDelete;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.buzztec.ConsultaActivity;
import com.example.buzztec.MenuActivity;
import com.example.buzztec.R;
import com.example.buzztec.dao.DaoConsultor;
import com.example.buzztec.dto.DtoConsultor;

public class ConsultorActivityUD extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    Spinner spinnerCargo;
    ImageButton buttonAlterar, buttonDeletar;
    EditText editTextNome, editTextEmail, editTextTelefone;
    int Id;
    String escolha;
    DtoConsultor dto = new DtoConsultor();
    DaoConsultor dao = new DaoConsultor(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultor_ud);

        this.setTitle("Consultor");

        buttonAlterar = findViewById(R.id.buttonAlterar_UD);
        buttonDeletar = findViewById(R.id.buttonDeletar_UD);
        spinnerCargo     = findViewById(R.id.spinnerCargo_Consultor);

        editTextNome     = findViewById(R.id.editTextNome_Consultor);
        editTextEmail    = findViewById(R.id.editTextEmail_Consultor);
        editTextTelefone = findViewById(R.id.editTextTelefone_Consultor);

        Bundle puxarDados = getIntent().getExtras();
        Id = puxarDados.getInt("Id");
        editTextNome.setText(puxarDados.getString("Nm_consultor"));
        editTextEmail.setText(puxarDados.getString("Email_consultor"));
        editTextTelefone.setText(puxarDados.getString("Tell_consultor"));


        buttonAlterar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dto.setId(Id);
                dto.setCargo(escolha);
                dto.setNome(editTextNome.getText().toString());
                dto.setTelefone(editTextTelefone.getText().toString());
                dto.setEmail(editTextEmail.getText().toString());

                try
                {
                    long Query = dao.Alterar(dto);
                    RealizaComando(Query,ConsultorActivityUD.this, MenuActivity.class);
                }
                catch (Exception ex)
                {
                    Toast.makeText(ConsultorActivityUD.this, "Erro fatal" + ex.toString(), Toast.LENGTH_SHORT).show();
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
                    RealizaComando(Query, ConsultorActivityUD.this, MenuActivity.class);
                }
                catch (Exception ex)
                {
                    Toast.makeText(ConsultorActivityUD.this, "Erro fatal" + ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_cargo, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCargo.setAdapter(adapter);
        spinnerCargo.setOnItemSelectedListener(this);
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

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        escolha = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }

}