import java.sql.Connection;
import java.sql.DriverManager;

// Classe de Conexão com o Banco de Dados
class ConexaoBD {
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
package org.example;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Main class.
 *
 */
public class Main {
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8080/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in org.example package
        final ResourceConfig rc = new ResourceConfig().packages("org.example.Resources");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with endpoints available at "
                + "%s%nHit Ctrl-C to stop it...", BASE_URI));
        System.in.read();
        server.stop();
    }
}