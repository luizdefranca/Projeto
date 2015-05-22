package projeto.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import projeto.erro.ConexaoException;
import projeto.erro.DAOException;
import projeto.negocio.basica.Bola;
import projeto.util.GerenciadorConexaoMysql;
import projeto.util.IGerenciadorConexao;

/**
 *
 * @author Tito
 */
public class DAOBolaImpl implements IDAOBola{
    private final IGerenciadorConexao GER;
    private Connection c;
    
    public DAOBolaImpl(){
        GER = GerenciadorConexaoMysql.getInstancia();
    }
    
    @Override
    public void incluir(Bola b) throws ConexaoException,DAOException {
        c = GER.conectar();
        IGerenciadorConexao ger = GerenciadorConexaoMysql.getInstancia();
        Connection c = ger.conectar();
        String sql = "INSERT INTO bola (nome,descricao,quantidade) VALUES(?,?,?)";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, b.getNome());
            pstm.setString(2, b.getDescricao());
            pstm.setInt(3, b.getQuantidade());
            pstm.executeUpdate();   
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            GER.desconectar(c);
        }
    }
    
    @Override
    public void excluir(Integer id) throws ConexaoException,DAOException {
        c = GER.conectar();
        String sql = "DELETE FROM bola WHERE id=?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            GER.desconectar(c);
        }
    }
    
    @Override
    public void atualizar(Bola b) throws ConexaoException,DAOException {
        c = GER.conectar();
        String sql = "UPDATE bola SET nome=?, descricao=?, quantidade=? WHERE id=?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, b.getNome());
            pstm.setString(2, b.getDescricao());
            pstm.setInt(3, b.getQuantidade());
            pstm.setInt(4, b.getId());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            GER.desconectar(c);
        }
    }
    
    @Override
    public ArrayList<Bola> listar()throws ConexaoException,DAOException{
        c = GER.conectar();
        String sql = "SELECT t.id, t.nome, t.descricao, t.quantidade FROM bola t";
        try{
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            ArrayList<Bola> lista = new ArrayList();
                       
            while(rs.next()){
                Bola b = new Bola();
                b.setId( rs.getInt("id") );
                b.setNome( rs.getString("nome") );
                b.setDescricao( rs.getString("descricao") );
                b.setQuantidade( rs.getInt("quantidade") );
                lista.add(b);
            }
            return lista;
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            GER.desconectar(c);
        }
    }
    
    @Override
    public Bola get(String x)throws ConexaoException,DAOException{
        c = GER.conectar();
        String sql = " SELECT t.id, t.nome, t.descricao, t.quantidade FROM bola t WHERE nome=?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1,x);
            ResultSet rs = pstm.executeQuery(sql);
            Bola b = null;
                       
            if(rs.next()){
                b = new Bola();
                b.setId( rs.getInt("id") );
                b.setNome( rs.getString("nome") );
                b.setDescricao( rs.getString("descricao") );
                b.setQuantidade( rs.getInt("quantidade") );
            }
            return b;
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            GER.desconectar(c);
        }
    }
}
