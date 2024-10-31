
public class PecaCarro {
    private String pecaAlterada;
    private double valorDaPeca;

    // Construtor
    public PecaCarro(String pecaAlterada, double valorDaPeca) {
        this.pecaAlterada = pecaAlterada;
        this.valorDaPeca = valorDaPeca;
    }

    // Getters e Setters
    public String getPecaAlterada() {
        return pecaAlterada;
    }

    public void setPecaAlterada(String pecaAlterada) {
        this.pecaAlterada = pecaAlterada;
    }

    public double getValorDaPeca() {
        return valorDaPeca;
    }

    public void setValorDaPeca(double valorDaPeca) {
        this.valorDaPeca = valorDaPeca;
    }

    // Método main para teste inicial
    public static void main(String[] args) {
        PecaCarro peca = new PecaCarro("Motor", 500.0);
        System.out.println("Peça Alterada: " + peca.getPecaAlterada());
        System.out.println("Valor da Peça: $" + peca.getValorDaPeca());
    }
}


