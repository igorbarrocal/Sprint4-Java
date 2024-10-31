package org.example.Model.DTO;
public class Seguro {
    private String tipoSeguro;
    private double valorSeguro;

    // Construtor
    public Seguro(String tipoSeguro, double valorSeguro) {
        this.tipoSeguro = tipoSeguro;
        this.valorSeguro = valorSeguro;
    }

    // Getters e Setters
    public String getTipoSeguro() {
        return this.tipoSeguro;
    }

    public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

    public double getValorSeguro() {
        return this.valorSeguro;
    }

    public void setValorSeguro(double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }
