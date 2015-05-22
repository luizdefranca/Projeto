package projeto.erro;

/**
 *
 * @author Tito
 */
public class DAOException extends Exception {
    public DAOException(){}
    
    public DAOException(Exception e){
        super(e);
    }
    
    public DAOException(String x){
        super(x);
    }
}
