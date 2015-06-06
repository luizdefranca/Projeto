package projeto.repositorio;

import java.util.ArrayList;
import projeto.erro.ConexaoException;
import projeto.erro.DAOException;
import projeto.negocio.basica.Bola;

/**
 *
 * @author Tito
 */
public interface IDAOBola {
    /**
     * Inclui um registro no bd
     * @param b Objeto com todos os dados
     * @throws ConexaoException
     * @throws DAOException 
     */
    public void incluir(Bola b) throws ConexaoException,DAOException;
    
    /**
     * Exclui um registro do BD
     * @param id 
     * @throws ConexaoException
     * @throws DAOException 
     */
    public void excluir(Integer id) throws ConexaoException,DAOException;
    
    /**
     * Atualiza um registro no BD
     * @param b
     * @throws ConexaoException
     * @throws DAOException 
     */
    public void atualizar(Bola b) throws ConexaoException,DAOException;
    
    /**
     * Retorna uma lista com todos os registros
     * @return
     * @throws ConexaoException
     * @throws DAOException 
     */
    public ArrayList<Bola> listar() throws ConexaoException,DAOException;
    
    /**
     * Retorna uma Bola baseado no NOME passado
     * @param x
     * @return
     * @throws ConexaoException
     * @throws DAOException 
     */
    public Bola get(String x) throws ConexaoException,DAOException;
    
    /**
     * Retorna uma Bola baseado no ID passado
     * @param x
     * @return
     * @throws ConexaoException
     * @throws DAOException 
     */
    public Bola get(int x) throws ConexaoException,DAOException;
}
