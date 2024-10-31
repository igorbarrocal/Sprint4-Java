package org.example.Model.DTO;

class ChatBot {
    private String assistente;
    private String cliente;
    private String duvida;

    public ChatBot(String assistente, String cliente, String duvida) {
        this.assistente = assistente;
        this.cliente = cliente;
        this.duvida = duvida;
    }

    public String getAssistente() {
        return assistente;
    }

    public String getCliente() {
        return cliente;
    }

    public String getDuvida() {
        return duvida;
    }

    public void setAssistente(String assistente) {
        this.assistente = assistente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setDuvida(String duvida) {
        this.duvida = duvida;
    }