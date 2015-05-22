package projeto.repositorio;

import java.util.ArrayList;
import projeto.erro.ConexaoException;
import projeto.erro.DAOException;
import projeto.negocio.basica.Fornecedor;

public interface IDAOFornecedor {

	public void incluir (Fornecedor f) throws ConexaoException, DAOException;
	public void excluir (Integer id) throws ConexaoException, DAOException;
	public void atualizar (Fornecedor f) throws ConexaoException, DAOException;
	public ArrayList <Fornecedor> listar () throws ConexaoException, DAOException;
	public Fornecedor get (String x) throws ConexaoException, DAOException;
}