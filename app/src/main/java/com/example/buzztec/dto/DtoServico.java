package com.example.buzztec.dto;

public class DtoServico
{
    private int id;
    private String nm_servico, tp_servico, desc_servico;

    public String getDesc_servico() {
        return desc_servico;
    }

    public void setDesc_servico(String desc_servico) {
        this.desc_servico = desc_servico;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNm_servico() {
        return nm_servico;
    }

    public void setNm_servico(String nm_servico) {
        this.nm_servico = nm_servico;
    }

    public String getTp_servico() {
        return tp_servico;
    }

    public void setTp_servico(String tp_servico) {
        this.tp_servico = tp_servico;
    }
}
