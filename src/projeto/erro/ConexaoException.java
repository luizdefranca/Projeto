package projeto.erro;

/**
 *
 * @author Tito
 */
public class ConexaoException extends Exception {
    public ConexaoException(){}
    
    public ConexaoException(Exception e){
        super(e);
    }
    
    public ConexaoException(String x){
        super(x);
    }
}
