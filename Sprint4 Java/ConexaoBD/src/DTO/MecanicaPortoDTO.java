package org.example.Model.DTO;

public class MecanicaPorto {
    private double maoDeObra;
    private double valorDaPeca;

    // Construtor
    public MecanicaPorto(double maoDeObra, double valorDaPeca) {
        this.maoDeObra = maoDeObra;
        this.valorDaPeca = valorDaPeca;
    }

    // Getters e Setters
    public double getMaoDeObra() {
        return maoDeObra;
    }

    public void setMaoDeObra(double maoDeObra) {
        this.maoDeObra = maoDeObra;
    }

    public double getValorDaPeca() {
        return valorDaPeca;
    }

    public void setValorDaPeca(double valorDaPeca) {
        this.valorDaPeca = valorDaPeca;
    }

    // Método para calcular o custo total do serviço
    public double calcularCustoTotal(double valorPecasAdicionais) {
        return this.maoDeObra + this.valorDaPeca + valorPecasAdicionais;
    }

    // Método main para teste inicial
    public static void main(String[] args) {
        MecanicaPorto mecanica = new MecanicaPorto(100.0, 50.0);
        double valorPecasAdicionais = 30.0;
        double custoTotal = mecanica.calcularCustoTotal(valorPecasAdicionais);
        System.out.println("Custo total do serviço: $" + custoTotal);
    }
}
