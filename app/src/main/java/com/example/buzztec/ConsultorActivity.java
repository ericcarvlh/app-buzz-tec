package com.example.buzztec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.buzztec.dao.DaoConsultor;
import com.example.buzztec.dto.DtoConsultor;

public class ConsultorActivity extends AppCompatActivity
{
    Spinner spinnerCargo;
    Button buttonCadastrar;
    EditText editTextNome, editTextEmail, editTextTelefone;
    DtoConsultor dtoConsultor = new DtoConsultor();
    DaoConsultor daoConsultor = new DaoConsultor(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultor);

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
                dtoConsultor.setNome(editTextNome.getText().toString());
                dtoConsultor.setTelefone(editTextTelefone.getText().toString());
                dtoConsultor.setEmail(editTextEmail.getText().toString());

                try
                {
                    long addConsultor = daoConsultor.CadastrarConsultor(dtoConsultor);
                    if(addConsultor > 0)
                    {
                        Toast.makeText(ConsultorActivity.this, "Sucesso", Toast.LENGTH_SHORT).show();
                        //Intent voltar = new Intent(AdicionarActivity.this, MainActivity.class);
                        //startActivity(voltar);
                    }
                    else
                        Toast.makeText(ConsultorActivity.this, "Erro ao cadastrar", Toast.LENGTH_SHORT).show();
                }
                catch (Exception ex)
                {
                    Toast.makeText(ConsultorActivity.this, "Erro ao cadastrar" + ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
//    private void ColetadeDados()
//    {
//        dtoConsultor.setNome(editTextNome.getText().toString());
//        dtoConsultor.setTelefone(editTextTelefone.getText().toString());
//        dtoConsultor.setEmail(editTextEmail.getText().toString());
//    }
}