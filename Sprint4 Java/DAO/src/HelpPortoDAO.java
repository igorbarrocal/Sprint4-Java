import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class HelpPortoDAO {

    // Método para inserir HelpPorto no banco de dados
    public void inserirHelpPorto(HelpPorto helpPorto) {
        String sql = "INSERT INTO help_porto (assistente, duvidas) VALUES (?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, helpPorto.getAssistente());
            stmt.setString(2, String.join(",", helpPorto.getDuvidas()));
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir HelpPorto: " + e.getMessage(), e);
        }
    }

    // Método para buscar HelpPorto pelo assistente
    public HelpPorto buscarHelpPorto(String assistente) {
        String sql = "SELECT * FROM help_porto WHERE assistente = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, assistente);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String duvidas = rs.getString("duvidas");
                HelpPorto helpPorto = new HelpPorto(assistente);

                // Converter a string de dúvidas para uma lista
                if (duvidas != null && !duvidas.isEmpty()) {
                    for (String duvida : duvidas.split(",")) {
                        helpPorto.adicionarDuvida(duvida.trim());
                    }
                }

                return helpPorto;
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar HelpPorto: " + e.getMessage(), e);
        }
    }

    // Método para atualizar HelpPorto
    public void atualizarHelpPorto(HelpPorto helpPorto) {
        String sql = "UPDATE help_porto SET duvidas = ? WHERE assistente = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, String.join(",", helpPorto.getDuvidas()));
            stmt.setString(2, helpPorto.getAssistente());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar HelpPorto: " + e.getMessage(), e);
        }
    }

    // Método para deletar HelpPorto
    public void deletarHelpPorto(String assistente) {
        String sql = "DELETE FROM help_porto WHERE assistente = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, assistente);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar HelpPorto: " + e.getMessage(), e);
        }
    }
}
