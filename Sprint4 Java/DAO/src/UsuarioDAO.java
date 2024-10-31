import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class UsuarioDAO {
    public void inserir(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (ano_nascimento, nome, cpf, endereco) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuario.getAnoNascimento());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getCpf());
            stmt.setString(4, usuario.getEndereco());
            stmt.executeUpdate();
        }
    }

    public void atualizar(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuarios SET nome = ?, cpf = ?, endereco = ? WHERE ano_nascimento = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getEndereco());
            stmt.setInt(4, usuario.getAnoNascimento());
            stmt.executeUpdate();
        }
    }

    public void deletar(int anoNascimento) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE ano_nascimento = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, anoNascimento);
            stmt.executeUpdate();
        }
    }
}
