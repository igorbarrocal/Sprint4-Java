import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


class PecaCarroDAO {
    // Método para inserir uma PecaCarro no banco de dados
    public void insertPecaCarro(PecaCarro peca) throws SQLException {
        String sql = "INSERT INTO peca_carro (peca_alterada, valor_da_peca) VALUES (?, ?)";
        try (Connection conn = ConexaoBD.criarConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, peca.getPecaAlterada());
            stmt.setDouble(2, peca.getValorDaPeca());
            stmt.executeUpdate();
        }
    }
}
