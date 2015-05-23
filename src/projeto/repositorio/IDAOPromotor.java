package projeto.repositorio;

import java.util.ArrayList;
import projeto.erro.ConexaoException;
import projeto.erro.DAOException;
import projeto.negocio.basica.Promotor;

public interface IDAOPromotor {

	public void incluir (Promotor p) throws ConexaoException, DAOException;
	public void excluir (Integer id) throws ConexaoException, DAOException;
	public void atualizar (Promotor p) throws ConexaoException, DAOException;
	public ArrayList <Promotor> listar () throws ConexaoException, DAOException;
	public Promotor get (String x) throws ConexaoException, DAOException;
}