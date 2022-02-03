package modelo;

import java.sql.SQLException; 
import java.sql.Connection; 
import java.sql.Statement; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.util.ArrayList; 
import vista.Usuario;
 

public class UsuarioDAO {
    Connection conexao;
    
    public UsuarioDAO() {
        try {
            conexao = Conexao.getConnection();
        }
        catch( Exception e ) {
            System.out.println("Erro pedido de conexao Usuario DAO" +e.getMessage());
            System.out.println(e);
        }
    }
    public ArrayList<Usuario> getLista() {
        ArrayList<Usuario> resultado = new ArrayList<>();
        try {            
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery("select * from usuario");
            while( rs.next() ) {
                Usuario usuario = new Usuario();
                
                usuario.setId(rs.getInt("id") );
                usuario.setNome(rs.getString("nome") );                
                usuario.setEmail(rs.getString("email") );
                usuario.setDnasc(rs.getString("dnasc") );
                usuario.setSexo(rs.getString("sexo") );
                usuario.setTipo(rs.getString("tipo") );
                usuario.setSenha(rs.getString("senha") );
                usuario.setDcads(rs.getString("dcads") );                 
                resultado.add(usuario);
            }
            System.out.println("Sucesso ao ler todas os Usuarios");            
            
        } catch( SQLException e ) {
            System.out.println("Erro ao ler todas os Usuarios: " + e.getMessage());
        }
         return resultado;
    }
    
    public Usuario procurar ( Usuario usuario ) {
        usuario = new Usuario();
        try {
            String sql = "SELECT * FROM usuario WHERE nome = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome") );                
                usuario.setEmail(rs.getString("email") );
                usuario.setDnasc(rs.getString("dnasc") );
                usuario.setSexo(rs.getString("sexo") );
                usuario.setTipo(rs.getString("tipo") );
                usuario.setSenha(rs.getString("senha") );                
                usuario.setDcads(rs.getString("dcads") );                
            }
            System.out.println("Sucesso ao pesquisar um Usuario");                  
            
        } catch( SQLException e ) {
            System.out.println("Erro ao pesquisar um Usuario: " + e.getMessage());
        }
        return usuario;
    }
    
    
    public Usuario consultar( Usuario usuario ) {
        usuario = new Usuario();
        try {
            String sql = "SELECT * FROM usuario WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, usuario.getId());
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome") );                
                usuario.setEmail(rs.getString("email") );
                usuario.setDnasc(rs.getString("dnasc") );
                usuario.setSexo(rs.getString("sexo") );
                usuario.setTipo(rs.getString("tipo") );
                usuario.setSenha(rs.getString("senha") );                
                usuario.setDcads(rs.getString("dcads") );                
            }
            System.out.println("Sucesso ao ler um Usuario");                  
            
        } catch( SQLException e ) {
            System.out.println("Erro ao ler um Usuario: " + e.getMessage());
        }
        return usuario;
    }
        
    
    public boolean gravar( Usuario usuario ) {
        try {
            String sql;
            if ( usuario.getId() == 0 ) {
                sql = "INSERT INTO usuario (nome, email, dnasc, sexo, tipo, senha, dcads) VALUES (?,?,?,?,?,?,?)";
            }  else  {
                sql = "UPDATE usuario SET nome=?, email=?, dnasc=?, sexo=?, tipo=?, senha=?, dcads=? WHERE id=?";
            }
       
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getDnasc());
            ps.setString(4, usuario.getSexo());            
            ps.setString(5, usuario.getTipo());
            ps.setString(6, usuario.getSenha());
            ps.setString(7, usuario.getDcads() );
            
            if ( usuario.getId()> 0 )
                ps.setInt(8, usuario.getId());
            
            ps.execute();
            System.out.println("Sucesso ao gravar ou incluir um Usuario");                  
            return true;            
            
        } catch( SQLException e ) {
            System.out.println("Erro ao gravar ou incluir um Usuario: " + e.getMessage());
            return false;
        }
    }

    
    public boolean excluir( Usuario usuario ) {
        try {
            String sql = "DELETE FROM usuario WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, usuario.getId());
            ps.execute();
            System.out.println("Sucesso ao excluir um Usuario");               
            return true;
            
        } catch( SQLException e ) {
            System.out.println("Erro ao excluir um Usuario: " + e.getMessage());
            return false;
        }
    }
}