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
    public void incluir(Bola b) throws ConexaoException,DAOException;
    public void excluir(Integer id) throws ConexaoException,DAOException;
    public void atualizar(Bola b) throws ConexaoException,DAOException;
    public ArrayList<Bola> listar() throws ConexaoException,DAOException;
    public Bola get(String x) throws ConexaoException,DAOException;
}
