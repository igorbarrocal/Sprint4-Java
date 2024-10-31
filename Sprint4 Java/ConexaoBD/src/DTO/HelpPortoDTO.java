package org.example.Model.DTO;
class HelpPorto {
    private List<String> duvidas;
    private String assistente;

    public HelpPorto(String assistente) {
        this.assistente = assistente;
        this.duvidas = new ArrayList<>();
    }

    public List<String> getDuvidas() {
        return duvidas;
    }

    public String getAssistente() {
        return assistente;
    }

    public void adicionarDuvida(String duvida) {
        this.duvidas.add(duvida);
    }

    public void removerDuvida(String duvida) {
        this.duvidas.remove(duvida);
    }