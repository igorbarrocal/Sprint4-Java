// Classe de Teste do ChatBot
class ChatBotTest {

    public static void main(String[] args) {
        // Criando instâncias de ChatBot e ChatBotDAO
        ChatBot chatBot = new ChatBot("Assistente 1", "Cliente 1", "Como faço login?");
        ChatBotDAO chatBotDAO = new ChatBotDAO();

        // Testando a inserção de ChatBot no banco de dados
        chatBotDAO.inserirChatBot(chatBot);
        System.out.println("ChatBot inserido no banco de dados!");

        // Testando a busca do ChatBot no banco de dados pelo nome do cliente
        ChatBot chatBotBuscado = chatBotDAO.buscarChatBot("Cliente 1");
        if (chatBotBuscado != null) {
            System.out.println("ChatBot buscado: " + chatBotBuscado);
        } else {
            System.out.println("ChatBot com cliente 'Cliente 1' não encontrado.");
        }

        // Testando a atualização do assistente e da dúvida do ChatBot no banco de dados
        chatBot.setAssistente("Assistente Atualizado");
        chatBot.setDuvida("Qual a senha padrão?");
        chatBotDAO.atualizarChatBot(chatBot);
        System.out.println("ChatBot atualizado!");

        // Testando a remoção do ChatBot do banco de dados
        chatBotDAO.deletarChatBot("Cliente 1");
        System.out.println("ChatBot deletado do banco de dados!");
    }
}
