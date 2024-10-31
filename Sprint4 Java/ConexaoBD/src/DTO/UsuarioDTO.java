package org.example.Model.DTO;
class Usuario {
    private int anoNascimento;
    private String nome;
    private String cpf;
    private String endereco;

    public Usuario(int anoNascimento, String nome, String cpf, String endereco) {
        this.anoNascimento = anoNascimento;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }