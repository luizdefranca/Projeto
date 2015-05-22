package projeto.util;

import java.sql.Connection;
import projeto.erro.ConexaoException;

/**
 *
 * @author Tito
 */
public interface IGerenciadorConexao {
    
    /**
     * Retorna uma conexao com o BD
     * @return
     * @throws ConexaoException 
     */
    public Connection conectar() throws ConexaoException;
    
    /**
     * Encerra a conexao com o BD
     * @param c
     * @throws ConexaoException 
     */
    public void desconectar(Connection c) throws ConexaoException;
}
