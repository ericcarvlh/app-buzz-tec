package com.example.buzztec.UpdateDelete;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.buzztec.ConsultaActivity;
import com.example.buzztec.R;
import com.example.buzztec.dao.DaoServico;
import com.example.buzztec.dto.DtoServico;

public class ServicoActivityUD extends AppCompatActivity
{
    EditText editTextDesc, editTextTipo, editTextNomeS;
    ImageButton buttonAlterar, buttonDeletar;
    int Id;
    Intent detalhes;
    DaoServico daoServico = new DaoServico(this);
    DtoServico dtoServico = new DtoServico();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servico_ud);

        this.setTitle("Servico");

        editTextDesc    = findViewById(R.id.editTextDesc_servico);
        editTextTipo    = findViewById(R.id.editTextTipo_servico);
        editTextNomeS   = findViewById(R.id.editTextNmServico_servico);

        buttonAlterar = findViewById(R.id.buttonAlterar_UD);
        buttonDeletar = findViewById(R.id.buttonDeletar_UD);

        Bundle puxarDados = getIntent().getExtras();
        Id = puxarDados.getInt("Id");
        editTextDesc.setText(puxarDados.getString("Desc_servico"));
        editTextNomeS.setText(puxarDados.getString("Nm_servico"));
        editTextTipo.setText(puxarDados.getString("Tp_servico"));

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

//        private void DellCarro()
//        {
//            AlertDialog.Builder Exc = new AlertDialog.Builder(this);
//            Exc.setMessage(sExcMsg);
//            Exc.setIcon(android.R.drawable.stat_notify_error);
//            Exc.setTitle(sExcTt);
//            Exc.setPositiveButton("Sim", new DialogInterface.OnClickListener()
//            {
//                @Override
//                public void onClick(DialogInterface dialog, int which)
//                {
//                    int dellCarro = daoServico.Excluir(dtoServico);
//                    if(dellCarro > 0)
//                    {
//                        Toast.makeText(ConsultaActivity.this, "Deleteado com sucesso.", Toast.LENGTH_SHORT).show();
//                        arrayListServico = daoServico.ConsultarTodos();
//                        UpdateListViewServico();
//                    }
//                    else
//                        Toast.makeText(ConsultaActivity.this, "Erro ao deletar", Toast.LENGTH_SHORT).show();
//                }
//            });
//            Exc.setNegativeButton("Não", null);
//            Exc.show();
//        }
    }
}