package Camada DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {
    public static Connection con=null;// variável de classe conexão
    static String server="oracle.fiap.com.br";
    static String port="1521";
    static String sid="ORCL";
    static String url = "jdbc:oracle:thin:@" + server + ":" + port + ":" + sid;
    static String user="RM555217";
    static String passwd="020306";
    public static Connection criarConexao()  { //método que retorna a conexão
        if (con==null){
            try {
           Class.forName("oracle.jdbc.driver.OracleDriver");//verifica driver
           con= DriverManager.getConnection(url,user,passwd);//cria uma conexão
            }
            catch (ClassNotFoundException e){//erro da linha 17
                System.out.println("Driver não funcionou");
            }
            catch (java.sql.SQLException e2){
                System.out.println("Conexão não foi efetuada");
            }
   }
    return con;//retorno da conexão criada.
    }
}
