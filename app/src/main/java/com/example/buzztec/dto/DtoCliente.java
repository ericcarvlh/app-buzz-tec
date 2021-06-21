package com.example.buzztec.dto;

public class DtoCliente
{
    private int id, Cd_cliente;
    private String Nome, Telefone, Email;

    public String toString()
    {
        //Locale ptBr = new Locale("pt","BR");
        //Date format = new SimpleDateFormat("dd/MM/yyyy").parse(dataInicio);

        return Nome +" - "+ Cd_cliente +" - "+ Telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCd_cliente() {
        return Cd_cliente;
    }

    public void setCd_cliente(int cd_cliente) {
        Cd_cliente = cd_cliente;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
