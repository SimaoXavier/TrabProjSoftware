/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;
import java.sql.Connection;
import br.com.projeto.jdbc.ConexaoBanco;
import br.com.projeto.model.Crianca;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class CriancaDAO {
    private Connection conexao;
    
    public CriancaDAO(){
        this.conexao = new ConexaoBanco().pegarConexao();
    }
            
    // Cadastrar Criança
    public void cadastrarCrianca(Crianca obj){
        try{
            // Instruução
            String sql = "INSERT INTO crianca (nome, dt_nasc, sexo, status, dt_cadastro) VALUES (?, ?, ?, ?, ?);";
            // Preparar o SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getData_nasc());
            stmt.setString(3, obj.getSexo());
            stmt.setString(4, obj.getStatus());
            stmt.setString(5, obj.getData_cadastro());
            
            // Executar
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Criança Cadastrado com Sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO: "+ e);
        }
    }
    
    public List<Crianca> listarCriancas(){
        try{
            List<Crianca> lista = new ArrayList<>();
            
            String sql = "select * from crianca;";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Crianca obj = new Crianca();
                obj.setCodigo(rs.getInt("codigo"));
                obj.setNome(rs.getString("nome"));
                obj.setData_nasc(rs.getString("dt_nasc"));
                obj.setSexo(rs.getString("sexo"));
                obj.setStatus(rs.getString("status"));
                obj.setData_cadastro(rs.getString("dt_cadastro"));
                
                lista.add(obj);
            }
            return lista;
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERRO: "+ e);
        }
        return null;
    }
}
