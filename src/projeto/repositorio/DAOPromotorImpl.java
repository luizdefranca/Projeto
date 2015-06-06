/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import projeto.erro.ConexaoException;
import projeto.erro.DAOException;
import projeto.negocio.basica.Promotor;
import projeto.util.GerenciadorConexaoMysql;
import projeto.util.IGerenciadorConexao;

/**
 *
 * @author Marcus
 */

    public class DAOPromotorImpl implements IDAOPromotor{

	private final IGerenciadorConexao GER;
	private Connection c;
	
	
		public DAOPromotorImpl () {
			GER = GerenciadorConexaoMysql.getInstancia();
		}
		
		
		@Override
		public void incluir(Promotor p) throws ConexaoException, DAOException {
                        c = GER.conectar();
			String sql = "INSERT INTO ROOT.PROMOTOR (CODIGO, NOME, CPF, ENDERECO, EMAIL, TELEFONE) VALUES (?,?,?,?,?,?)";
			try{
				PreparedStatement pstm = c.prepareStatement(sql);
				pstm.setInt(1, p.getCodigo());
				pstm.setString(2, p.getNome());
				pstm.setString(3, p.getCpf());
				pstm.setString(4, p.getEndereco());
				pstm.setString(5, p.getEmail());
				pstm.setString(6, p.getTelefone());
                                System.gc();
				pstm.executeUpdate();
			}catch(SQLException e){
				throw new DAOException (e);	
			}finally{
				GER.desconectar(c);
			}
			
		}
		
        @Override
		public void excluir(Integer id) throws ConexaoException, DAOException {
			c = GER.conectar();
			String sql = "DELETE FROM Promotor WHERE id=?";
			try {
				PreparedStatement pstm = c.prepareStatement(sql);
				pstm.setInt(1, id);
				pstm.executeUpdate();
			}catch(SQLException e){
				throw new DAOException (e);
			}finally{
				GER.desconectar(c);
			}
		}
		
        @Override
		public void atualizar (Promotor p) throws ConexaoException, DAOException {
			c = GER.conectar();
			String sql = "UPDATE Prommotor SET  nome=?, cpf=?, endereco=?, email=?, telefone=? WHERE codigo=?";
			try{
				PreparedStatement pstm = c.prepareStatement(sql);
				pstm.setString(1, p.getNome());
				pstm.setString(2, p.getCpf());
				pstm.setString(3, p.getEndereco());
				pstm.setString(4, p.getEmail());
				pstm.setString(5, p.getTelefone()) ;
				pstm.setInt(6, p.getCodigo());
				pstm.executeUpdate();
			}catch(SQLException e){
				throw new DAOException (e);	
			}finally{
				GER.desconectar(c);
			}
		}
		
            @Override
		public ArrayList <Promotor> listar () throws ConexaoException, DAOException {
			c = GER.conectar();
			String sql = "SELECT t.codigo, t.nome, t.cpf, t.endereco, t.email, t.telefone WHERE promotor t";
				try{
					Statement stm = c.createStatement ();
					ResultSet rs = stm.executeQuery(sql);
					ArrayList <Promotor> listar = new ArrayList();
					
						while (rs.next()){
							Promotor p = new Promotor();
							p.setCodigo(rs.getInt("codigo"));
							p.setNome(rs.getString("nome"));
							p.setCpf(rs.getString("cpf"));
							p.setEndereco(rs.getString("endereco"));
							p.setEmail(rs.getString("email"));
                                                        p.setTelefone(rs.getString("Telefone"));
							listar.add(p);
							}
					return listar;
					}catch(SQLException e){
					 throw new DAOException (e);
					}finally{
					  GER.desconectar(c);
				}
		}
		
                @Override
		/**
                 * retorna objeto pelo nome
                 */
                public Promotor get (String x) throws ConexaoException, DAOException{
			c = GER.conectar();
			String sql = "SELECT p.codigo, p.nome, p.cpf, p.endereco, p.email, p.telefone FROM promotor p   WHERE p.nome=?";
				try{
					PreparedStatement pstm = c.prepareStatement(sql);
					pstm.setString(1, x);
					ResultSet rs = pstm.executeQuery(sql);
					Promotor p = null;
					
						if (rs.next()){
						    p = new Promotor();
							p.setCodigo(rs.getInt("codigo"));
							p.setNome(rs.getString("nome"));
							p.setCpf(rs.getString("cpf"));
							p.setEndereco(rs.getString("endereco"));
							p.setEmail(rs.getString("email"));
                                                        p.setTelefone(rs.getString("Telefone"));
							
							}
					return p;
					}catch(SQLException e){
					 throw new DAOException (e);
					}finally{
					  GER.desconectar(c);
				}
		}
                
                /**
                 * 
                 * @param x
                 * @return
                 * @throws ConexaoException
                 * @throws DAOException 
                 */
                
                @Override
                public Promotor get (int x) throws ConexaoException, DAOException{
			c = GER.conectar();
			String sql = "SELECT p.codigo, p.nome, p.cpf, p.endereco, p.email, p.telefone FROM promotor p   WHERE p.codigo=?";
				try{
					PreparedStatement pstm = c.prepareStatement(sql);
					pstm.setInt(1, x);
					ResultSet rs = pstm.executeQuery(sql);
					Promotor p = null;
					
						if (rs.next()){
						    p = new Promotor();
							p.setCodigo(rs.getInt("codigo"));
							p.setNome(rs.getString("nome"));
							p.setCpf(rs.getString("cpf"));
							p.setEndereco(rs.getString("endereco"));
							p.setEmail(rs.getString("email"));
                                                        p.setTelefone(rs.getString("Telefone"));
							
							}
					return p;
					}catch(SQLException e){
					 throw new DAOException (e);
					}finally{
					  GER.desconectar(c);
				}
		}
                
                
                

   
	}

