package testeB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

public class dbEstoque {
    public void inserir(estoque e){
        String sql = "insert into estoque(autor, titulo, editora, ano_publicacao, quantidade) values(?, ?, ?, ?, ?)";
        Connection conexao = tstConexao.getConnection();
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, e.getAutor());
            ps.setString(2, e.getTitulo());
            ps.setString(3, e.getEditora());
            ps.setInt(4, e.getAno_publicacao());
            ps.setString(5, String.valueOf(e.getQuantidade()));
            
            ps.execute();
            ps.close();
            conexao.close();
               
        } catch (SQLException ex) {
            Logger.getLogger(dbEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void alterar(estoque e){
        String sql = "update estoque set autor=?, titulo=?, editora=?, ano_publicacao=?, quantidade=? where id=?";
        Connection conexao = tstConexao.getConnection();
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, e.getAutor());
            ps.setString(2, e.getTitulo());
            ps.setString(3, e.getEditora());
            ps.setInt(4, e.getAno_publicacao());
            ps.setString(5, String.valueOf(e.getQuantidade()));
            ps.setInt(6, e.getId());
            
            ps.execute();
            ps.close();
            conexao.close();
               
        } catch (SQLException ex) {
            Logger.getLogger(dbEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void excluir(estoque e){
        String sql = "delete from estoque where id=?";
        Connection conexao = tstConexao.getConnection();
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setInt(1, e.getId());
            
            ps.execute();
            ps.close();
            conexao.close();
               
        } catch (SQLException ex) {
            Logger.getLogger(dbEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public ArrayList<estoque> listar(String condicao){
        ArrayList<estoque> listaEstoque = new ArrayList<estoque>();
        
        String sql = "select * from estoque";
        
        /*
        if(!condicao.equals("")){
            sql = sql + "where" + condicao;
        }*/
        
        Connection conexao = tstConexao.getConnection();
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                listaEstoque.add(new estoque(rs.getInt("id"), rs.getString("autor"), rs.getString("titulo"), 
                        rs.getString("editora"), rs.getInt("ano_publicacao") , rs.getInt("quantidade")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(dbEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaEstoque;
    }
    
    public estoque ConsultaId(int id){
        estoque retorne = null;
        String sql = "select * from estoque where id=?";
        Connection conexao = tstConexao.getConnection();
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
 
            while(rs.next()){
                retorne = new estoque(rs.getInt("id"), rs.getString("autor"), rs.getString("titulo"), rs.getString("editora"), 
                        rs.getInt("ano_publicacao"), rs.getInt("quantidade"));
 
            }
        } catch (SQLException ex) {
            Logger.getLogger(dbEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorne;
    }
    
     public void inserirUse (pessoa p){
        String sql = "insert into usuario (nome, telefone, email, senha) values(?, ?, ?, ?)";
        Connection conexao = tstConexao.getConnection();
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setString(2, p.getTelefone());
            ps.setString(3, p.getEmail());
            ps.setString(4, p.getSenha());

            ps.execute();
            ps.close();
            conexao.close();
               
        } catch (SQLException ex) {
            Logger.getLogger(dbEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        public pessoa consultarEmail(String email){
        pessoa ret = null;
        String sql = "select * from usuario where email=?";
        Connection conexao = tstConexao.getConnection();
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            
 
            while(rs.next()){
                ret = new pessoa(rs.getInt("id"), rs.getString("nome"), rs.getString("telefone"), rs.getString("email"), 
                        rs.getString("senha"));
 
            }
               
        } catch (SQLException ex) {
            Logger.getLogger(dbEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    void consultarEmail(JTextField txtEmail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
    
     
}
