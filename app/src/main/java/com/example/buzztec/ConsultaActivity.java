package com.example.buzztec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

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
    ArrayList<DtoAgenda> arrayListAgenda;
    ArrayList<DtoAtividade> arrayListAtividade;
    ArrayList<DtoCliente> arrayListCliente;
    ArrayList<DtoConsultor> arrayListConsultor;
    ArrayList<DtoServico> arrayListServico;
    DaoAgenda daoAgenda = new DaoAgenda(this);
    DaoAtividade daoAtividade = new DaoAtividade(this);
    DaoCliente daoCliente = new DaoCliente(this);
    DaoConsultor daoConsultor = new DaoConsultor(this);
    DaoServico daoServico = new DaoServico(this);
    ListView listViewTds;
    Spinner spinnerConsulta;
    String escolha;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        this.setTitle("Consulta");

        spinnerConsulta = findViewById(R.id.spinnerCargo_Consulta);
        listViewTds = findViewById(R.id.listviewInfo);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_consulta, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerConsulta.setAdapter(adapter);
        spinnerConsulta.setOnItemSelectedListener(this);
    }

    private void UpdateListViewAgenda()
    {
        ArrayAdapter update = new ArrayAdapter(this,  android.R.layout.simple_list_item_1, arrayListAgenda);
        listViewTds.setAdapter(update);
    }

    private void UpdateListViewAtividade()
    {
        ArrayAdapter update = new ArrayAdapter(this,  android.R.layout.simple_list_item_1, arrayListAtividade);
        listViewTds.setAdapter(update);
    }

    private void UpdateListViewCliente()
    {
        ArrayAdapter update = new ArrayAdapter(this,  android.R.layout.simple_list_item_1, arrayListCliente);
        listViewTds.setAdapter(update);
    }

    private void UpdateListViewConsultor()
    {
        ArrayAdapter update = new ArrayAdapter(this,  android.R.layout.simple_list_item_1, arrayListConsultor);
        listViewTds.setAdapter(update);
    }

    private void UpdateListViewServico()
    {
        ArrayAdapter update = new ArrayAdapter(this,  android.R.layout.simple_list_item_1, arrayListServico);
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
                UpdateListViewAgenda();
                break;
            case "Atividade":
                arrayListAtividade = daoAtividade.ConsultarTodos();
                UpdateListViewAtividade();
                break;
            case "Cliente":
                arrayListCliente = daoCliente.ConsultarTodos();
                UpdateListViewCliente();
                break;
            case "Consultor":
                arrayListConsultor = daoConsultor.ConsultarTodos();
                UpdateListViewConsultor();
                break;
            case "Serviço":
                arrayListServico = daoServico.ConsultarTodos();
                UpdateListViewServico();
                break;
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}