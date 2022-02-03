package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.UsuarioDAO;
import vista.Usuario;

@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsuarioController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsuarioController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            System.out.println ("Entrando no metodo POST");
            String acao = (String) request.getParameter("acao");
            String mensagem;
        try {
            String nome = request.getParameter("nome");    
            String email = request.getParameter("email");
            String dnasc = request.getParameter("dnasc");
            String sexo = request.getParameter("sexo");
            String tipo = request.getParameter("tipo");
            String senha = request.getParameter("senha");            
            Integer dcads = Integer.parseInt(request.getParameter("dcads"));

            Usuario usuario = new Usuario();
            usuario.setNome("nome");            
            usuario.setEmail("email");
            usuario.setDnasc("dnasc");
            usuario.setSexo("sexo");
            usuario.setTipo("tipo"); 
            usuario.setSenha("senha");
            usuario.setDcads("dcads");
            
            UsuarioDAO usuarioDAO = new UsuarioDAO();

            if (request.getParameter("acao").equals("incluir"))  { 
                usuario.setId(0);            
                if (usuarioDAO.gravar(usuario)) {
                    mensagem = "Usuario incluido com sucesso!";
                } else {
                
                    mensagem = "Erro ao incluir usuario";
                }
            }  else  {
            
            if (request.getParameter("acao").equals("alterar"))  {
                usuario.setId(Integer.parseInt(request.getParameter("id")));
                if (usuarioDAO.gravar(usuario)) {
                   mensagem = "Usuario alterado com sucesso!";
                } else {
                   mensagem = "Erro ao alterar usuario";
                }
            }    
            }
        }
            catch (Exception e) {
            mensagem = "Erro";
            System.out.println("Erro  " + e.getMessage());
        }
} 
}


