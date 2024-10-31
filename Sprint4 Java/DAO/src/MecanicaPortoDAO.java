import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class MecanicaPortoDAO {
    public void insertMecanicaPorto(MecanicaPorto mecanica) throws SQLException {
        String sql = "INSERT INTO mecanica_porto (mao_de_obra, valor_da_peca) VALUES (?, ?)";
        try (Connection conn = ConexaoBD.criarConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, mecanica.getMaoDeObra());
            stmt.setDouble(2, mecanica.getValorDaPeca());
            stmt.executeUpdate();
        }
    }
}