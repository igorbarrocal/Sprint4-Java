import java.util.ArrayList;
import java.util.List;

class Carro {
    private String modelo;
    private String chassi;
    private List<String> pecas;
    private static final List<String> pecasObrigatorias = List.of("Motor", "Rodas", "Freios");

    // Construtor da classe Carro
    public Carro(String modelo, String chassi) {
        this.modelo = modelo;
        this.chassi = chassi;
        this.pecas = new ArrayList<>();
    }

    // Getters e Setters
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public List<String> getPecas() {
        return pecas;
    }

    // Método para adicionar uma peça, se ainda não existir na lista
    public boolean adicionarPecaSeNaoExistir(String peca) {
        if (!pecas.contains(peca)) {
            pecas.add(peca);
            return true;
        }
        return false;
    }

    // Método para remover uma peça da lista
    public void removerPeca(String peca) {
        pecas.remove(peca);
    }

    // Verifica se o carro possui todas as peças obrigatórias
    public boolean possuiPecasObrigatorias() {
        return pecas.containsAll(pecasObrigatorias);
    }

    // Método para limpar todas as peças do carro
    public void limparPecas() {
        pecas.clear();
    }

    // Método toString para retornar uma representação textual do carro
    @Override
    public String toString() {
        return "Carro{modelo='" + modelo + "', chassi='" + chassi + "', pecas=" + pecas + '}';
    }
}






