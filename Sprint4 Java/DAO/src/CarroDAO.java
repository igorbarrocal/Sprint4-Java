import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class CarroDAO {

    // Método para inserir um carro no banco de dados
    public void inserirCarro(Carro carro) {
        String sql = "INSERT INTO carros (modelo, chassi) VALUES (?, ?)";

        // Tentando abrir a conexão e preparar a instrução SQL
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, carro.getModelo());  // Define o modelo do carro
            stmt.setString(2, carro.getChassi());  // Define o chassi do carro
            stmt.executeUpdate();  // Executa a inserção no banco de dados

        } catch (SQLException e) {
            // Tratamento de exceção em caso de erro no banco de dados
            throw new RuntimeException("Erro ao inserir carro: " + e.getMessage(), e);
        }
    }

    // Método para buscar um carro pelo chassi
    public Carro buscarCarro(String chassi) {
        String sql = "SELECT * FROM carros WHERE chassi = ?";

        // Tentando abrir a conexão e preparar a instrução SQL
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, chassi);  // Define o chassi do carro para a busca
            ResultSet rs = stmt.executeQuery();  // Executa a consulta

            if (rs.next()) {
                String modelo = rs.getString("modelo");  // Obtém o modelo do carro
                return new Carro(modelo, chassi);  // Retorna o objeto Carro encontrado
            }
            return null;  // Retorna null se nenhum carro for encontrado

        } catch (SQLException e) {
            // Tratamento de exceção em caso de erro no banco de dados
            throw new RuntimeException("Erro ao buscar carro: " + e.getMessage(), e);
        }
    }

    // Método para atualizar os dados de um carro
    public void atualizarCarro(Carro carro) {
        String sql = "UPDATE carros SET modelo = ? WHERE chassi = ?";

        // Tentando abrir a conexão e preparar a instrução SQL
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, carro.getModelo());  // Define o novo modelo do carro
            stmt.setString(2, carro.getChassi());  // Define o chassi do carro
            stmt.executeUpdate();  // Executa a atualização no banco de dados

        } catch (SQLException e) {
            // Tratamento de exceção em caso de erro no banco de dados
            throw new RuntimeException("Erro ao atualizar carro: " + e.getMessage(), e);
        }
    }

    // Método para deletar um carro pelo chassi
    public void deletarCarro(String chassi) {
        String sql = "DELETE FROM carros WHERE chassi = ?";

        // Tentando abrir a conexão e preparar a instrução SQL
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, chassi);  // Define o chassi do carro para exclusão
            stmt.executeUpdate();  // Executa a exclusão no banco de dados

        } catch (SQLException e) {
            // Tratamento de exceção em caso de erro no banco de dados
            throw new RuntimeException("Erro ao deletar carro: " + e.getMessage(), e);
        }
    }
}
