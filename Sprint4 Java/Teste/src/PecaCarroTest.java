import java.sql.SQLException;

public class PecaCarroTest {
    public static void main(String[] args) {
        // Testa a criação da classe PecaCarro
        PecaCarro peca = new PecaCarro("Motor", 500.0);
        System.out.println("Peça Alterada: " + peca.getPecaAlterada());
        System.out.println("Valor da Peça: $" + peca.getValorDaPeca());

        // Testa a persistência com PecaCarroDAO
        try {
            PecaCarroDAO dao = new PecaCarroDAO();
            dao.insertPecaCarro(peca);
            System.out.println("PecaCarro inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao inserir PecaCarro: " + e.getMessage());
        }
    }
}
