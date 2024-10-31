import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;


// Classe Seguro
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

    @Override
    public String toString() {
        return "Seguro{tipoSeguro='" + this.tipoSeguro + '\'' + ", valorSeguro=" + this.valorSeguro + '}';
    }

    // Método main para teste inicial
    public static void main(String[] args) {
        Seguro seguro = new Seguro("Cobertura Completa", 1500.0);
        System.out.println("Tipo de Seguro: " + seguro.getTipoSeguro());
        System.out.println("Valor do Seguro: $" + seguro.getValorSeguro());
    }
}


    // Método para inserir um Seguro no banco de dados
    public void insertSeguro(Seguro seguro) throws SQLException {
        String sql = "INSERT INTO seguro (tipo_seguro, valor_seguro) VALUES (?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, seguro.getTipoSeguro());
            stmt.setDouble(2, seguro.getValorSeguro());
            stmt.executeUpdate();
        }
    }

    // Outros métodos CRUD podem ser implementados aqui (e.g., update, delete, select)
}





