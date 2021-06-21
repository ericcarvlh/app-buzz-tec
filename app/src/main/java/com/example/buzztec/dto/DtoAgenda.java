package com.example.buzztec.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DtoAgenda
{
    private int id;
    private String nm_cliente, local_agenda, nm_consultor, desc_agenda, data_agenda;

    public String toString()
    {
        return nm_cliente + " - " + nm_consultor + " - " + data_agenda;
    }

    public String getData_agenda() {
        return data_agenda;
    }

    public void setData_agenda(String data_agenda) {
        this.data_agenda = data_agenda;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNm_cliente() {
        return nm_cliente;
    }

    public void setNm_cliente(String nm_cliente) {
        this.nm_cliente = nm_cliente;
    }

    public String getLocal_agenda() {
        return local_agenda;
    }

    public void setLocal_agenda(String local_agenda) {
        this.local_agenda = local_agenda;
    }

    public String getNm_consultor() {
        return nm_consultor;
    }

    public void setNm_consultor(String nm_consultor) {
        this.nm_consultor = nm_consultor;
    }

    public String getDesc_agenda() {
        return desc_agenda;
    }

    public void setDesc_agenda(String desc_agenda) {
        this.desc_agenda = desc_agenda;
    }
}
