class LoginPortoTest {

    public static void main(String[] args) {
        // Criando instâncias de LoginPorto e LoginPortoDAO
        LoginPorto login = new LoginPorto("usuario1", "senha123", "usuario1@example.com");
        LoginPortoDAO loginDAO = new LoginPortoDAO();

        // Testando inserção no banco de dados
        loginDAO.inserirLoginPorto(login);
        System.out.println("Login inserido no banco de dados!");

        // Testando busca no banco de dados
        LoginPorto loginBuscado = loginDAO.buscarLoginPorto("usuario1");
        if (loginBuscado != null) {
            System.out.println("Login buscado: " + loginBuscado);
        } else {
            System.out.println("Login não encontrado!");
        }

        // Atualizando dados do login
        if (loginBuscado != null) {
            loginBuscado.setSenha("novaSenha123");
            loginBuscado.setEmail("novoemail@example.com");
            loginDAO.atualizarLoginPorto(loginBuscado);
            System.out.println("Login atualizado!");
        } else {
            System.out.println("Impossível atualizar, login não encontrado.");
        }

        // Testando remoção do banco de dados
        loginDAO.deletarLoginPorto("usuario1");
        System.out.println("Login deletado do banco de dados!");
    }
}
