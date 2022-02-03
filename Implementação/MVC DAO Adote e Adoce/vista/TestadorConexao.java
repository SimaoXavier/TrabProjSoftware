package vista;

import java.sql.SQLException;
import modelo.Conexao;

public class TestadorConexao {
    public static void main (String [] args) throws SQLException {
        Conexao.getConnection();
    }       
    } 


