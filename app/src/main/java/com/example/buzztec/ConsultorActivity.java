package com.example.buzztec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.buzztec.UpdateDelete.ConsultorActivityUD;
import com.example.buzztec.dao.DaoBanco;
import com.example.buzztec.dao.DaoConsultor;
import com.example.buzztec.dto.DtoBanco;
import com.example.buzztec.dto.DtoConsultor;

public class ConsultorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    Spinner spinnerCargo;
    Button buttonCadastrar;
    EditText editTextNome, editTextEmail, editTextTelefone;
    String escolha;
    DtoConsultor dto = new DtoConsultor();
    DaoConsultor dao = new DaoConsultor(this);
    DtoBanco    dtoB = new DtoBanco();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultor);

        this.setTitle("Consultor");

        buttonCadastrar  = findViewById(R.id.buttonCadastrarConsultor_Consultor);

        spinnerCargo     = findViewById(R.id.spinnerCargo_Consultor);

        editTextNome     = findViewById(R.id.editTextNome_Consultor);
        editTextEmail    = findViewById(R.id.editTextEmail_Consultor);
        editTextTelefone = findViewById(R.id.editTextTelefone_Consultor);

        buttonCadastrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dto.setCargo(escolha);
                dto.setNome(editTextNome.getText().toString());
                dto.setTelefone(editTextTelefone.getText().toString());
                dto.setEmail(editTextEmail.getText().toString());

                try
                {
                    long Query = dao.CadastrarConsultor(dto);
                    dtoB.RealizaComando(Query, ConsultorActivity.this, MenuActivity.class);
                }
                catch (Exception ex)
                {
                    Toast.makeText(ConsultorActivity.this, "Erro fatal" + ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_cargo, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCargo.setAdapter(adapter);
        spinnerCargo.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        escolha = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
}