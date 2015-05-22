package projeto.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import projeto.erro.ConexaoException;

/**
 *
 * @author Tito
 */
public class GerenciadorConexaoMysql implements IGerenciadorConexao {
    private static GerenciadorConexaoMysql instancia;
    private final String LOCAL;
    private final String USUARIO;
    private final String SENHA;
    private final String DRIVER;
    
    private GerenciadorConexaoMysql(){
        ResourceBundle rb = ResourceBundle.getBundle("projeto.util.banco");
        LOCAL = rb.getString("local");
        USUARIO = rb.getString("usuario");
        SENHA = rb.getString("senha");
        DRIVER = rb.getString("driver");
    }
    
    public static GerenciadorConexaoMysql getInstancia(){
        if(instancia==null){
            instancia = new GerenciadorConexaoMysql();
        }
        return instancia;
    }

    @Override
    public Connection conectar() throws ConexaoException {
        Connection c = null;
        try{
            Class.forName(DRIVER);
            c = DriverManager.getConnection(LOCAL,USUARIO,SENHA);
        }catch(ClassNotFoundException | SQLException e){
            throw new ConexaoException(e);
        }
        return c;
    }

    @Override
    public void desconectar(Connection c) throws ConexaoException {
        try {
            c.close();
        } catch (SQLException e) {
            throw new ConexaoException(e);
        }
    }
    
}
