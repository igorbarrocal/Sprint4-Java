import java.sql.SQLException;

public class MecanicaPortoTest {
    public static void main(String[] args) {
        // Testa a criação e cálculo da classe MecanicaPorto
        MecanicaPorto mecanica = new MecanicaPorto(150.0, 75.0);
        double valorPecasAdicionais = 40.0;
        double custoTotal = mecanica.calcularCustoTotal(valorPecasAdicionais);
        System.out.println("Custo total do serviço: $" + custoTotal);

        // Testa a persistência com MecanicaPortoDAO
        try {
            MecanicaPortoDAO dao = new MecanicaPortoDAO();
            dao.insertMecanicaPorto(mecanica);
            System.out.println("MecanicaPorto inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao inserir MecanicaPorto: " + e.getMessage());
        }
    }
}