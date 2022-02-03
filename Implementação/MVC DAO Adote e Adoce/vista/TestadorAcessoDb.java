package vista;

import java.util.List;
import modelo.UsuarioDAO;

public class TestadorAcessoDb {
    
    public static void main(String[] args){
        
//  Chamadas para testar acessos ao DB tabela usuarios

   //     usuincluir ();
   //     usualterar ();
      usuconsultar ();
   //     usuexcluir ();
   //     usuprocurar ();
  //      usulistar ();
       
         
    }
      
        public static void usuincluir (){
        Usuario usu = new Usuario();
        usu.setId(0);
        usu.setNome("nome");
        usu.setEmail("email");
        usu.setDnasc("dnasc");
        usu.setSexo("sexo");
        usu.setTipo("tipo"); 
        usu.setSenha("senha");
        usu.setDcads("dcads");
        
        UsuarioDAO usuDao = new UsuarioDAO();
        usuDao.gravar(usu);
    }
        
        public static void usuconsultar (){
        Usuario usu = new Usuario();
        usu.setId(2);
        
        UsuarioDAO usuDao = new UsuarioDAO();
        usuDao.consultar(usu);
    }
            
        public static void usuprocurar (){
        Usuario usu = new Usuario();
        usu.setNome("admin");
        UsuarioDAO usuDao = new UsuarioDAO();
        usuDao.procurar(usu);
    }
           
        public static void usualterar (){
        Usuario usu = new Usuario();
        usu.setId(2);
        usu.setNome("nome");
        usu.setEmail("email");
        usu.setDnasc("dnasc");
        usu.setSexo("sexo");
        usu.setTipo("tipo"); 
        usu.setSenha("senha");
        usu.setDcads("dcads");        
        
        UsuarioDAO usuDao = new UsuarioDAO();
        usuDao.gravar(usu);
    }
         
        public static void usuexcluir (){
        Usuario usu = new Usuario();
        usu.setId(2);
        
        UsuarioDAO usuDao = new UsuarioDAO();
        usuDao.excluir(usu);
    }  
        
        public static void usulistar (){
        UsuarioDAO usuDao = new UsuarioDAO();
        List<Usuario> listados = usuDao.getLista();
        
        for (Usuario u: listados) {
            System.out.println(u.getId() +"  "+ u.getNome()); 
        }
    }    
        
}
