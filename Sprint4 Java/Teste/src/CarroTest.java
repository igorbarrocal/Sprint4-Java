// Classe de Teste
import
class CarroTest {

    public static void main(String[] args) {
        // Criando instâncias de Carro e CarroDAO
        Carro carro = new Carro("Fusca", "123ABC");
        CarroDAO carroDAO = new CarroDAO();

        // Testando adicionar peças e verificar se todas as obrigatórias estão presentes
        carro.adicionarPecaSeNaoExistir("Motor");
        carro.adicionarPecaSeNaoExistir("Rodas");
        carro.adicionarPecaSeNaoExistir("Freios");

        // Exibindo as peças do carro
        System.out.println("Peças no carro: " + carro.getPecas());

        // Verificando se o carro possui todas as peças obrigatórias
        System.out.println("Possui todas as peças obrigatórias? " + carro.possuiPecasObrigatorias());

        // Testando inserção do carro no banco de dados
        carroDAO.inserirCarro(carro);
        System.out.println("Carro inserido no banco de dados!");

        // Testando a busca do carro no banco de dados pelo número do chassi
        Carro carroBuscado = carroDAO.buscarCarro("123ABC");
        if (carroBuscado != null) {
            System.out.println("Carro buscado: " + carroBuscado);
        } else {
            System.out.println("Carro com chassi 123ABC não encontrado.");
        }

        // Testando a atualização do modelo do carro no banco de dados
        carro.setModelo("Fusca 2.0");
        carroDAO.atualizarCarro(carro);
        System.out.println("Carro atualizado!");

        // Testando a remoção do carro do banco de dados
        carroDAO.deletarCarro("123ABC");
        System.out.println("Carro deletado do banco de dados!");
    }
}
