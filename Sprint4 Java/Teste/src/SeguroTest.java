import java.sql.SQLException;

public class SeguroTest {
    public static void main(String[] args) {
        // Testa a criação da classe Seguro
        Seguro seguro = new Seguro("Cobertura Completa", 1500.0);
        System.out.println("Tipo de Seguro: " + seguro.getTipoSeguro());
        System.out.println("Valor do Seguro: $" + seguro.getValorSeguro());

        // Testa a persistência com SeguroDAO
        try {
            SeguroDAO dao = new SeguroDAO();
            dao.insertSeguro(seguro);
            System.out.println("Seguro inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao inserir Seguro: " + e.getMessage());
        }
    }
}