import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Classe Usuario
class Usuario {
    private int anoNascimento;
    private String nome;
    private String cpf;
    private String endereco;

    public Usuario(int anoNascimento, String nome, String cpf, String endereco) {
        this.anoNascimento = anoNascimento;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    // Getters e Setters
    public int getAnoNascimento() { return anoNascimento; }
    public void setAnoNascimento(int anoNascimento) { this.anoNascimento = anoNascimento; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    // Método para calcular idade do usuário
    public int calcularIdade(int anoAtual) {
        return anoAtual - anoNascimento;
    }

    // Método para validar CPF
    public boolean validarCpf() {
        return cpf != null && cpf.matches("\\d{11}");
    }

    @Override
    public String toString() {
        return "Usuario{anoNascimento=" + anoNascimento + ", nome='" + nome + '\'' + ", cpf='" + cpf + '\'' + ", endereco='" + endereco + '\'' + '}';
    }
}



