package com.example.buzztec.UpdateDelete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.buzztec.R;
import com.example.buzztec.dao.DaoConsultor;
import com.example.buzztec.dto.DtoConsultor;

public class ConsultorActivityUD extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinnerCargo;
    ImageButton buttonAlterar, buttonDeletar;
    EditText editTextNome, editTextEmail, editTextTelefone;
    int Id, cd;
    String escolha;
    DtoConsultor dtoConsultor = new DtoConsultor();
    DaoConsultor daoConsultor = new DaoConsultor(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultor_ud);

        this.setTitle("Consultor");

        buttonAlterar = findViewById(R.id.buttonAlterar_UD);
        buttonDeletar = findViewById(R.id.buttonDeletar_UD);
        //
        spinnerCargo     = findViewById(R.id.spinnerCargo_Consultor);

        editTextNome     = findViewById(R.id.editTextNome_Consultor);
        editTextEmail    = findViewById(R.id.editTextEmail_Consultor);
        editTextTelefone = findViewById(R.id.editTextTelefone_Consultor);

        Bundle puxarDados = getIntent().getExtras();
        Id = puxarDados.getInt("Id");
        editTextNome.setText(puxarDados.getString("Nm_consultor"));
        editTextEmail.setText(puxarDados.getString("Email_consultor"));
        editTextTelefone.setText(puxarDados.getString("Tell_consultor"));
        escolha = puxarDados.getString("Cargo_consultor");
        switch (escolha)
        {
            case "Banco de dados":
                cd = 1;
                spinnerCargo.setId(cd);
                break;
            case "Analista mobile":
                cd = 2;
                spinnerCargo.setId(cd);
                break;
            case "Analista de sistemas":
                cd = 3;
                spinnerCargo.setId(cd);
                break;
            case "Dev. Back-end":
                cd = 4;
                spinnerCargo.setId(cd);
                break;
            case "Dev. Front-end":
                cd = 5;
                spinnerCargo.setId(cd);
                break;
            default:
                break;
        }

        buttonAlterar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });
        buttonDeletar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_cargo, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCargo.setAdapter(adapter);
        spinnerCargo.setOnItemSelectedListener(this);
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