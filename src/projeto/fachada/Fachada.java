package projeto.fachada;

import projeto.erro.GeralException;
import projeto.negocio.RNBola;
import projeto.negocio.basica.Bola;

/**
 *
 * @author Tito
 */
public class Fachada {
    
    /**
     * Gera um novo registro com os dados passados
     * @param b Uma instancia da Bola contendo todos os dados
     * @throws GeralException 
     */
    public void incluirNovaBola(Bola b)throws GeralException{
        RNBola rn = new RNBola();
        rn.verificaObjeto(b);
        rn.validaRegistro(b);
        rn.registroNovo(b);
        rn.inserir(b);
    }
    
    /**
     * Altera um registro de Bola no BD
     * @param b Uma instancia de Bola com os dados a serem alterados
     * @throws GeralException 
     */
    public void alterarUmaBola(Bola b)throws GeralException{
        RNBola rn = new RNBola();
        rn.verificaObjeto(b);
        rn.validaId(b);
        rn.validaRegistro(b);
        rn.registroExiste(b);
        rn.alterar(b);
    }
    
    public Bola pegaBola(Bola b)throws GeralException{
        RNBola rn = new RNBola();
        return rn.buscaNome(b);
    }
}
