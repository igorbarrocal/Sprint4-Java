
import java.util.ArrayList;
import java.util.List;


// Classe Model HelpPorto
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

    @Override
    public String toString() {
        return "HelpPorto{duvidas=" + duvidas + ", assistente='" + assistente + "'}";
    }
}


