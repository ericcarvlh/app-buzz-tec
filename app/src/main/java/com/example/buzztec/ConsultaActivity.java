package com.example.buzztec;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.buzztec.UpdateDelete.AgendaActivityUD;
import com.example.buzztec.UpdateDelete.AtividadeActivityUD;
import com.example.buzztec.UpdateDelete.ClienteActivityUD;
import com.example.buzztec.UpdateDelete.ConsultorActivityUD;
import com.example.buzztec.UpdateDelete.ServicoActivityUD;
import com.example.buzztec.dao.DaoAgenda;
import com.example.buzztec.dao.DaoAtividade;
import com.example.buzztec.dao.DaoCliente;
import com.example.buzztec.dao.DaoConsultor;
import com.example.buzztec.dao.DaoServico;
import com.example.buzztec.dto.DtoAgenda;
import com.example.buzztec.dto.DtoAtividade;
import com.example.buzztec.dto.DtoCliente;
import com.example.buzztec.dto.DtoConsultor;
import com.example.buzztec.dto.DtoServico;

import java.util.ArrayList;

public class ConsultaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ArrayList<DtoAgenda>    arrayListAgenda;
    ArrayList<DtoAtividade> arrayListAtividade;
    ArrayList<DtoCliente>   arrayListCliente;
    ArrayList<DtoConsultor> arrayListConsultor;
    ArrayList<DtoServico>   arrayListServico;
    DaoAgenda daoAgenda       = new DaoAgenda(this);
    DaoAtividade daoAtividade = new DaoAtividade(this);
    DaoCliente daoCliente     = new DaoCliente(this);
    DaoConsultor daoConsultor = new DaoConsultor(this);
    DaoServico daoServico     = new DaoServico(this);
    DtoAgenda dtoAgenda;   DtoAtividade dtoAtividade;
    DtoCliente dtoCliente; DtoConsultor dtoConsultor;
    DtoServico dtoServico;
    ListView listViewTds;
    Spinner spinnerConsulta;
    String escolha, tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        this.setTitle("Consulta");

        spinnerConsulta = findViewById(R.id.spinnerCargo_Consulta);
        listViewTds     = findViewById(R.id.listviewInfo);

        tipo = spinnerConsulta.toString();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_consulta, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerConsulta.setAdapter(adapter);
        spinnerConsulta.setOnItemSelectedListener(this);

        listViewTds.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch (escolha)
                {
                    case "Agenda":
                        dtoAgenda    = arrayListAgenda.get(position);
                        break;
                    case "Atividade":
                        dtoAtividade = arrayListAtividade.get(position);
                        break;
                    case "Cliente":
                        dtoCliente   = arrayListCliente.get(position);
                        break;
                    case "Consultor":
                        dtoConsultor = arrayListConsultor.get(position);
                        break;
                    case "Serviço":
                        dtoServico = arrayListServico.get(position);
                }
                registerForContextMenu(listViewTds);
                return false;
            }
        });
    }

    private void UpdateListView(ArrayList arrayList)
    {
        ArrayAdapter update = new ArrayAdapter(this,  android.R.layout.simple_list_item_1, arrayList);
        listViewTds.setAdapter(update);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        escolha = parent.getItemAtPosition(position).toString();

        switch (escolha)
        {
            case "Consulta":
                break;
            case "Agenda":
                arrayListAgenda = daoAgenda.ConsultarTodos();
                UpdateListView(arrayListAgenda);
                break;
            case "Atividade":
                arrayListAtividade = daoAtividade.ConsultarTodos();
                UpdateListView(arrayListAtividade);
                break;
            case "Cliente":
                arrayListCliente = daoCliente.ConsultarTodos();
                UpdateListView(arrayListCliente);
                break;
            case "Consultor":
                arrayListConsultor = daoConsultor.ConsultarTodos();
                UpdateListView(arrayListConsultor);
                break;
            case "Serviço":
                arrayListServico = daoServico.ConsultarTodos();
                UpdateListView(arrayListServico);
                break;
            default:
                break;
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Detalhes/Alterar");
        menu.add(0, 1, 1, "Excluir");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item)
    {
        if(item.getItemId()==0 || item.getItemId()==1)
        {
            switch (escolha)
            {
                case "Agenda":
                    Intent agenda = new Intent(ConsultaActivity.this, AgendaActivityUD.class);
                    daoAgenda.EnviaColunasUD(agenda, dtoAgenda);
                    startActivity(agenda);
                    break;
                case "Atividade":
                    Intent atividade = new Intent(ConsultaActivity.this, AtividadeActivityUD.class);
                    daoAtividade.EnviaColunasUD(atividade, dtoAtividade);
                    startActivity(atividade);
                    break;
                case "Cliente":
                    Intent cliente = new Intent(ConsultaActivity.this, ClienteActivityUD.class);
                    daoCliente.EnviaColunasUD(cliente, dtoCliente);
                    startActivity(cliente);
                    break;
                case "Consultor":
                    Intent consultor = new Intent(ConsultaActivity.this, ConsultorActivityUD.class);
                    daoConsultor.EnviaColunasUD(consultor, dtoConsultor);
                    startActivity(consultor);
                    break;
                case "Serviço":
                    Intent servico = new Intent(ConsultaActivity.this, ServicoActivityUD.class);
                    daoServico.EnviaColunasUD(servico, dtoServico);
                    startActivity(servico);
                    break;
                default:
                    break;
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}