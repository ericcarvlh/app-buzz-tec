package com.example.buzztec.UpdateDelete;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.buzztec.MenuActivity;
import com.example.buzztec.R;
import com.example.buzztec.dao.DaoServico;
import com.example.buzztec.dto.DtoServico;

public class ServicoActivityUD extends AppCompatActivity
{
    EditText editTextDesc, editTextTipo, editTextNomeS;
    ImageButton buttonAlterar, buttonDeletar;
    int Id;
    DaoServico dao = new DaoServico(this);
    DtoServico dto = new DtoServico();

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
                dto.setId(Id);
                dto.setDesc_servico(editTextDesc.getText().toString());
                dto.setNm_servico(editTextNomeS.getText().toString());
                dto.setTp_servico(editTextTipo.getText().toString());

                try
                {
                    long strQuery = dao.Alterar(dto);
                    RealizaComando(strQuery,ServicoActivityUD.this, MenuActivity.class);
                }
                catch (Exception ex)
                {
                    Toast.makeText(ServicoActivityUD.this, "Erro fatal" + ex.toString(), Toast.LENGTH_SHORT).show();
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
                    RealizaComando(Query, ServicoActivityUD.this, MenuActivity.class);
                }
                catch (Exception ex)
                {
                    Toast.makeText(ServicoActivityUD.this, "Erro fatal" + ex.toString(), Toast.LENGTH_SHORT).show();
                }
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
    public void RealizaComando(long Query, Context context, Class clas)
    {
        if (Query > 0) {
            Toast.makeText(context, "Sucesso", Toast.LENGTH_SHORT).show();
            Intent voltar = new Intent(context, clas);
            startActivity(voltar);
        } else
            Toast.makeText(context, "Erro ao cadastrar", Toast.LENGTH_SHORT).show();
    }
}