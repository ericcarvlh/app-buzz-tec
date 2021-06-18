package com.example.buzztec.dto;

import java.util.Date;

public class DtoAtividade
{
    private int id;
    private String nm_consultor, nm_cliente, desc_atividade, dataInicio, dataTermino;

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNm_consultor() {
        return nm_consultor;
    }

    public void setNm_consultor(String nm_consultor) {
        this.nm_consultor = nm_consultor;
    }

    public String getNm_cliente() {
        return nm_cliente;
    }

    public void setNm_cliente(String nm_cliente) {
        this.nm_cliente = nm_cliente;
    }

    public String getDesc_atividade() {
        return desc_atividade;
    }

    public void setDesc_atividade(String desc_atividade) {
        this.desc_atividade = desc_atividade;
    }
}
