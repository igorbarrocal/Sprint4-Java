import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class ChatBotDAO {

    // Método para inserir um ChatBot no banco de dados
    public void inserirChatBot(ChatBot chatBot) {
        String sql = "INSERT INTO chatbots (assistente, cliente, duvida) VALUES (?, ?, ?)";

        // Tentando abrir a conexão e preparar a instrução SQL
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, chatBot.getAssistente());  // Define o assistente do ChatBot
            stmt.setString(2, chatBot.getCliente());     // Define o cliente do ChatBot
            stmt.setString(3, chatBot.getDuvida());      // Define a dúvida do ChatBot
            stmt.executeUpdate();                        // Executa a inserção no banco de dados

        } catch (SQLException e) {
            // Tratamento de exceção em caso de erro no banco de dados
            throw new RuntimeException("Erro ao inserir chatbot: " + e.getMessage(), e);
        }
    }

    // Método para buscar um ChatBot pelo cliente
    public ChatBot buscarChatBot(String cliente) {
        String sql = "SELECT * FROM chatbots WHERE cliente = ?";

        // Tentando abrir a conexão e preparar a instrução SQL
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente);                  // Define o cliente para busca
            ResultSet rs = stmt.executeQuery();          // Executa a busca

            if (rs.next()) {
                String assistente = rs.getString("assistente");  // Obtém o assistente do banco de dados
                String duvida = rs.getString("duvida");          // Obtém a dúvida do banco de dados
                return new ChatBot(assistente, cliente, duvida); // Retorna o ChatBot encontrado
            }
            return null;  // Retorna null se não encontrar o cliente

        } catch (SQLException e) {
            // Tratamento de exceção em caso de erro no banco de dados
            throw new RuntimeException("Erro ao buscar chatbot: " + e.getMessage(), e);
        }
    }

    // Método para atualizar os dados de um ChatBot
    public void atualizarChatBot(ChatBot chatBot) {
        String sql = "UPDATE chatbots SET assistente = ?, duvida = ? WHERE cliente = ?";

        // Tentando abrir a conexão e preparar a instrução SQL
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, chatBot.getAssistente());  // Define o novo assistente
            stmt.setString(2, chatBot.getDuvida());      // Define a nova dúvida
            stmt.setString(3, chatBot.getCliente());     // Define o cliente para atualização
            stmt.executeUpdate();                        // Executa a atualização

        } catch (SQLException e) {
            // Tratamento de exceção em caso de erro no banco de dados
            throw new RuntimeException("Erro ao atualizar chatbot: " + e.getMessage(), e);
        }
    }

    // Método para deletar um ChatBot pelo cliente
    public void deletarChatBot(String cliente) {
        String sql = "DELETE FROM chatbots WHERE cliente = ?";

        // Tentando abrir a conexão e preparar a instrução SQL
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente);                 // Define o cliente para remoção
            stmt.executeUpdate();                       // Executa a exclusão

        } catch (SQLException e) {
            // Tratamento de exceção em caso de erro no banco de dados
            throw new RuntimeException("Erro ao deletar chatbot: " + e.getMessage(), e);
        }
    }
}
