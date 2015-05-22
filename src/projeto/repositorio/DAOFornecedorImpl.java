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
import projeto.negocio.basica.Fornecedor;
import projeto.util.GerenciadorConexaoMysql;
import projeto.util.IGerenciadorConexao;

/**
 *
 * @author Marcus
 */

    public class DAOFornecedorImpl implements IDAOFornecedor{

	private final IGerenciadorConexao GER;
	private Connection c;
	
	
		public DAOFornecedorImpl () {
			GER = GerenciadorConexaoMysql.getInstancia();
		}
		
		
		@Override
		public void incluir(Fornecedor f) throws ConexaoException, DAOException {
                        c = GER.conectar();
			String sql = "INSERT INTO fornecedor (razaoSocial, cnpj, endereco, telefone, email) VALUES (?,?,?,?,?)";
			try{
				PreparedStatement pstm = c.prepareStatement(sql);
				pstm.setString(1, f.getRazaoSocial());
				pstm.setString(2, f.getCnpj());
				pstm.setString(3, f.getEndereco());
				pstm.setString(4, f.getTelefone());
				pstm.setString(5, f.getEmail());
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
			String sql = "DELETE FROM fornecedor WHERE id=?";
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
		public void atualizar (Fornecedor f) throws ConexaoException, DAOException {
			c = GER.conectar();
			String sql = "UPDATE fornecedor SET razaoSocial=?, cnpj=?, endereco=?, telefone=?, email=? WHERE id=?";
			try{
				PreparedStatement pstm = c.prepareStatement(sql);
				pstm.setString(1, f.getRazaoSocial());
				pstm.setString(2, f.getCnpj());
				pstm.setString(3, f.getEndereco());
				pstm.setString(4, f.getTelefone());
				pstm.setString(5, f.getEmail());
				pstm.setInt(6, f.getId());
				pstm.executeUpdate();
			}catch(SQLException e){
				throw new DAOException (e);	
			}finally{
				GER.desconectar(c);
			}
		}
		
            @Override
		public ArrayList <Fornecedor> listar () throws ConexaoException, DAOException {
			c = GER.conectar();
			String sql = "SELECT t.id, t.razaoSocial, t.cnpj, t.endereco, t.telefone, t.email WHERE fornecedor t";
				try{
					Statement stm = c.createStatement ();
					ResultSet rs = stm.executeQuery(sql);
					ArrayList <Fornecedor> listar = new ArrayList();
					
						while (rs.next()){
							Fornecedor f = new Fornecedor();
							f.setId(rs.getInt("id"));
							f.setRazaoSocial(rs.getString("razaoSocial"));
							f.setCnpj(rs.getString("cnpj"));
							f.setEndereco(rs.getString("endereco"));
							f.setTelefone(rs.getString("Telefone"));
							f.setEmail(rs.getString("email"));
							listar.add(f);
							}
					return listar;
					}catch(SQLException e){
					 throw new DAOException (e);
					}finally{
					  GER.desconectar(c);
				}
		}
		
        @Override
		public Fornecedor get (String x) throws ConexaoException, DAOException{
			c = GER.conectar();
			String sql = "SELECT t.id, t.razaoSocial, t.cnpj, t.endereco, t.telefone, t.email FROM fornecedor t";
				try{
					PreparedStatement pstm = c.prepareStatement(sql);
					pstm.setString(1, x);
					ResultSet rs = pstm.executeQuery(sql);
					Fornecedor f = null;
					
						if (rs.next()){
						    f = new Fornecedor();
							f.setId(rs.getInt("id"));
							f.setRazaoSocial(rs.getString("razaoSocial"));
							f.setCnpj(rs.getString("cnpj"));
							f.setEndereco(rs.getString("endereco"));
							f.setTelefone(rs.getString("Telefone"));
							f.setEmail(rs.getString("email"));
							
							}
					return f;
					}catch(SQLException e){
					 throw new DAOException (e);
					}finally{
					  GER.desconectar(c);
				}
		}

   
	}

