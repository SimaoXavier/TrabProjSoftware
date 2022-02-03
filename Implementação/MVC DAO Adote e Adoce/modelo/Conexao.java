package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexao {
    
    public static Connection getConnection() throws SQLException {
            Connection conexao = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");                         
                System.out.println("Driver foi carregado!");
                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog", "root", "");
                System.out.println("Conexão realizada com sucesso!");
            }
            catch( ClassNotFoundException e ) {
                System.out.println("Driver não foi localizado!");
            }
        return conexao;
    }
}