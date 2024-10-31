import java.sql.SQLException;

public class TesteUsuario {
    public static void main(String[] args) {
        try {
            // Criar um novo usuário
            Usuario usuario = new Usuario(1980, "João Silva", "12345678901", "Rua Exemplo, 123");

            // Inserir o usuário no banco de dados
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.inserir(usuario);

            // Testar métodos adicionais
            System.out.println("Idade do usuário: " + usuario.calcularIdade(2024));
            System.out.println("CPF válido: " + usuario.validarCpf());

            // Atualizar usuário
            usuario.setEndereco("Rua Atualizada, 456");
            usuarioDAO.atualizar(usuario);

            // Deletar usuário (exemplo de deleção por ano de nascimento)
            usuarioDAO.deletar(usuario.getAnoNascimento());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
