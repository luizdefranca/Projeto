package projeto.negocio;

import java.util.ArrayList;
import projeto.erro.ConexaoException;
import projeto.erro.DAOException;
import projeto.erro.GeralException;
import projeto.negocio.basica.Bola;
import projeto.repositorio.DAOBolaImpl;
import projeto.repositorio.IDAOBola;

/**
 *
 * @author Tito
 */
public class RNBola {
    private final IDAOBola dao;
    
    public RNBola(){
        dao = new DAOBolaImpl();
    }
    
    /**
     * Bota o dado no BD
     * @param b Obejto Bola contendo todos os dados
     * @throws GeralException 
     */
    public void inserir(Bola b)throws GeralException{
        try{
            dao.incluir(b);
        }catch(ConexaoException e){
            throw new GeralException("Erro no BD! Ui!!!");
        }catch(DAOException e){
            throw new GeralException("Erro do Programador! SQL!!!");
        }
    }
    
    /**
     * Verifica se nao ha campos invalidos
     * @param b Objeto com todos os dados
     * @throws GeralException 
     */
    public void verificaObjeto(Bola b)throws GeralException{
        if((b==null) || !b.isValido())
            throw new GeralException("Dados inválidos!");
    }

    /**
     * Verifica se todos os campos OBRIGATORIOS foram informados
     * @param b Objeto com todos os dados
     * @throws GeralException 
     */
    public void validaRegistro(Bola b)throws GeralException{
        if(b.getNome().isEmpty())
            throw new GeralException("Nome inválido!");
        if(b.getDescricao().isEmpty())
            throw new GeralException("Descrição inválida!");
        if(b.getQuantidade()<0)
            throw new GeralException("Quantidade inválida!");
    }
    
    /**
     * Retorna uma Bola se encontrar o NOME
     * @param b Objeto contendo o NOME
     * @return A bola
     * @throws GeralException 
     */
    public Bola buscaNome(Bola b)throws GeralException{
        try {
            return dao.get(b.getNome());
        }catch(ConexaoException e){
            throw new GeralException("Erro no BD! Ui!!!");
        }catch(DAOException e){
            throw new GeralException("Erro do Programador! SQL!!!");
        }
    }

    /**
     * Verifica se o registro e novo (sem duplicacao)
     * @param b Objeto com o nome
     * @throws GeralException 
     */
    public void registroNovo(Bola b)throws GeralException{
        if(buscaNome(b)!=null)
            throw new GeralException("Nome ja existe no BD");
    }
    
    /**
     * Verifica se o registro ja existe no bd (id valido)
     * @param b Objeto com o ID
     * @throws GeralException 
     */
    public void registroExiste(Bola b)throws GeralException{
        if(buscaID(b)==null)
            throw new GeralException("Registro nao existe no BD");
    }

    /**
     * Retorna uma Bola se encontrar o ID
     * @param b Objeto contendo o ID
     * @return A bola
     * @throws GeralException 
     */
    public Bola buscaID(Bola b)throws GeralException{
        try {
            return dao.get(b.getId());
        }catch(ConexaoException e){
            throw new GeralException("Erro no BD! Ui!!!");
        }catch(DAOException e){
            throw new GeralException("Erro do Programador! SQL!!!");
        }
    }
    
    /**
     * Altera os dados da Bola
     * @param b Objeto com todos os dados
     * @throws GeralException 
     */
    public void alterar(Bola b)throws GeralException{
        try{
            dao.atualizar(b);
        }catch(ConexaoException e){
            throw new GeralException("Erro no BD! Ui!!!");
        }catch(DAOException e){
            throw new GeralException("Erro do Programador! SQL!!!");
        }
    }

     /**
     * Verifica se o ID foi informado
     * @param b Objeto com todos os dados
     * @throws GeralException 
     */
    public void validaId(Bola b)throws GeralException{
        if(b.getId()==null)
            throw new GeralException("Bola invalida!");
    }
    
    /**
     * Exclui um registro dos arquivos
     * @param id
     * @throws GeralException 
     */
    public void apaga(Integer id)throws GeralException{
        try{
            dao.excluir(id);
        }catch(ConexaoException e){
            throw new GeralException("Erro no BD! Ui!!!");
        }catch(DAOException e){
            throw new GeralException("Erro do Programador! SQL!!!");
        }
    }
    
    /**
     * Retorna uma lista com todos os registros
     * @return
     * @throws GeralException 
     */
    public ArrayList<Bola> listar()throws GeralException{
        try{
            return dao.listar();
        }catch(ConexaoException e){
            throw new GeralException("Erro no BD! Ui!!!");
        }catch(DAOException e){
            throw new GeralException("Erro do Programador! SQL!!!");
        }
    }
    
}
