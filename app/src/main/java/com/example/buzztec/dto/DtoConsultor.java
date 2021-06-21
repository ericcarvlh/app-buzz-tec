package com.example.buzztec.dto;

public class DtoConsultor
{
    private int id;
    private String nome, telefone, email, cargo;

    public String toString()
    {
        //Locale ptBr = new Locale("pt","BR");
        //Date format = new SimpleDateFormat("dd/MM/yyyy").parse(dataInicio);

        return nome +" - "+ telefone +" - "+ cargo;
    }

    public String getCargo()
    {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
