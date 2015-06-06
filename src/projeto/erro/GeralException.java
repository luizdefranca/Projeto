package projeto.erro;

/**
 *
 * @author Tito
 */
public class GeralException extends Exception {
    public GeralException(){}
    
    public GeralException(Exception e){
        super(e);
    }
    
    public GeralException(String x){
        super(x);
    }
}
