class HelpPortoTest {

    public static void main(String[] args) {
        // Criando instâncias de HelpPorto e HelpPortoDAO
        HelpPorto helpPorto = new HelpPorto("Assistente 1");
        HelpPortoDAO helpPortoDAO = new HelpPortoDAO();

        // Adicionando dúvidas ao HelpPorto
        helpPorto.adicionarDuvida("Como faço login?");
        helpPorto.adicionarDuvida("Esqueci minha senha");

        // Testando inserção no banco de dados
        try {
            helpPortoDAO.inserirHelpPorto(helpPorto);
            System.out.println("HelpPorto inserido no banco de dados!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir HelpPorto: " + e.getMessage());
        }

        // Testando busca no banco de dados
        try {
            HelpPorto helpPortoBuscado = helpPortoDAO.buscarHelpPorto("Assistente 1");
            if (helpPortoBuscado != null) {
                System.out.println("HelpPorto buscado: " + helpPortoBuscado);
            } else {
                System.out.println("HelpPorto não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar HelpPorto: " + e.getMessage());
        }

        // Atualizando as dúvidas do HelpPorto
        try {
            helpPorto.adicionarDuvida("Qual a política de privacidade?");
            helpPortoDAO.atualizarHelpPorto(helpPorto);
            System.out.println("HelpPorto atualizado!");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar HelpPorto: " + e.getMessage());
        }

        // Deletando HelpPorto do banco de dados
        try {
            helpPortoDAO.deletarHelpPorto("Assistente 1");
            System.out.println("HelpPorto deletado do banco de dados!");
        } catch (Exception e) {
            System.out.println("Erro ao deletar HelpPorto: " + e.getMessage());
        }
    }
}
