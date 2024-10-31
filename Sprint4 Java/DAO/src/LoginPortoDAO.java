import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class LoginPortoDAO {

    // Método para inserir um LoginPorto no banco de dados
    public void inserirLoginPorto(LoginPorto login) {
        String sql = "INSERT INTO login_porto (usuario, senha, email) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login.getUsuario());
            stmt.setString(2, login.getSenha());
            stmt.setString(3, login.getEmail());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir login: " + e.getMessage(), e);
        }
    }

    // Método para buscar um LoginPorto pelo usuário
    public LoginPorto buscarLoginPorto(String usuario) {
        String sql = "SELECT * FROM login_porto WHERE usuario = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String senha = rs.getString("senha");
                String email = rs.getString("email");
                return new LoginPorto(usuario, senha, email);
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar login: " + e.getMessage(), e);
        }
    }

    // Método para atualizar um LoginPorto
    public void atualizarLoginPorto(LoginPorto login) {
        String sql = "UPDATE login_porto SET senha = ?, email = ? WHERE usuario = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login.getSenha());
            stmt.setString(2, login.getEmail());
            stmt.setString(3, login.getUsuario());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar login: " + e.getMessage(), e);
        }
    }

    // Método para deletar um LoginPorto
    public void deletarLoginPorto(String usuario) {
        String sql = "DELETE FROM login_porto WHERE usuario = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar login: " + e.getMessage(), e);
        }
    }
}
