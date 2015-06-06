package projeto.negocio;

import java.util.ArrayList;
import projeto.erro.ConexaoException;
import projeto.erro.DAOException;
import projeto.erro.GeralException;

import projeto.negocio.basica.Promotor;

import projeto.repositorio.DAOPromotorImpl;

import projeto.repositorio.IDAOPromotor;

/**
 *
 * @author Luiz
 */
public class RNPromotor {
    private final IDAOPromotor dao;
    
    public RNPromotor(){
        dao = new DAOPromotorImpl();
    }
    
    /**
     * Bota o dado no BD
     * @param p Obejto Promotor contendo todos os dados
     * @throws GeralException 
     */
    public void inserir(Promotor p)throws GeralException{
        try{
            dao.incluir(p);
        }catch(ConexaoException e){
            throw new GeralException("Erro na Conexao: "+e.getMessage());
        }catch(DAOException e){
            throw new GeralException("Erro na Instrução SQL: "+e.getMessage());
        }
    }
    
    /**
     * Verifica se nao ha campos invalidos
     * @param p Objeto com todos os dados
     * @throws GeralException 
     */
    public void verificaObjeto(Promotor p)throws GeralException{
        if((p==null) || !p.isValido())
            throw new GeralException("Dados inválidos!");
    }

    /**
     * Verifica se todos os campos OBRIGATORIOS foram informados
     * @param p Objeto com todos os dados
     * @throws GeralException 
     */
    public void validaRegistro(Promotor p)throws GeralException{
        if(p.getNome().isEmpty())
            throw new GeralException("Nome inválido!");
        if(p.getCpf().isEmpty())
            throw new GeralException("CPF inválido");
        if(p.getEndereco().isEmpty())
            throw new GeralException("Endereco inválido");
        if(p.getEmail().isEmpty())
            throw new GeralException("Email inválido");
        if(p.getTelefone().isEmpty())
            throw new GeralException("Telefone inválido");
        
    }
    
    /**
     * Retorna um Promotor se encontrar o NOME
     * @param p Objeto contendo o NOME
     * @return o Promotor
     * @throws GeralException 
     */
    public Promotor buscaNome(Promotor p)throws GeralException{
        try {
            return dao.get(p.getNome());
        }catch(ConexaoException e){
            throw new GeralException("Erro na Conexao: "+e.getMessage());
        }catch(DAOException e){
            throw new GeralException("Erro na Instrução SQL: "+e.getMessage());
        }
    }

    /**
     * Verifica se o registro e novo (sem duplicacao)
     * @param p Objeto com o nome
     * @throws GeralException 
     */
    public void registroNovo(Promotor p)throws GeralException{
        if(buscaNome(p)!=null)
            throw new GeralException("Nome ja existe no BD");
    }
    
    /**
     * Verifica se o registro ja existe no bd (id valido)
     * @param p Objeto com o Codigo
     * @throws GeralException 
     */
    public void registroExiste(Promotor p)throws GeralException{
        if(buscaID(p)==null)
            throw new GeralException("Registro nao existe no BD");
    }

    /**
     * Retorna um objeto Promotor se encontrar o ID
     * @param p Objeto contendo o Codigo
     * @return Um objeto Promotor
     * @throws GeralException 
     */
    public Promotor buscaID(Promotor p)throws GeralException{
        try {
            return dao.get(p.getCodigo());
        }catch(ConexaoException e){
            throw new GeralException("Erro na Conexao: "+e.getMessage());
        }catch(DAOException e){
            throw new GeralException("Erro na Instrução SQL: "+e.getMessage());
        }
    }
    
    /**
     * Altera os dados do Objeto Promotor
     * @param p Objeto com todos os dados
     * @throws GeralException 
     */
    public void alterar(Promotor p)throws GeralException{
        try{
            dao.atualizar(p);
        }catch(ConexaoException e){
            throw new GeralException("Erro na Conexao: "+e.getMessage());
        }catch(DAOException e){
            throw new GeralException("Erro na Instrução SQL: "+e.getMessage());
        }
    }
    
     /**
     * Verifica se o Codigo foi informado
     * @param p Objeto com todos os dados
     * @throws GeralException 
     */
    public void validaId(Promotor p)throws GeralException{
        if(  (Integer)(p.getCodigo()) == null  )
            throw new GeralException("Promotor invalido!");
    }
    
    /**
     * Exclui um registro dos arquivos
     * @param codigo
     * @throws GeralException 
     */
    public void apaga(Integer codigo)throws GeralException{
        try{
            dao.excluir(codigo);
        }catch(ConexaoException e){
            throw new GeralException("Erro na Conexao: "+e.getMessage());
        }catch(DAOException e){
            throw new GeralException("Erro na Instrução SQL: "+e.getMessage());
        }
    }
    
    /**
     * Retorna uma lista com todos os registros
     * @return
     * @throws GeralException 
     */
    public ArrayList<Promotor> listar()throws GeralException{
        try{
            return dao.listar();
        }catch(ConexaoException e){
            throw new GeralException("Erro na Conexao: "+e.getMessage());
        }catch(DAOException e){
            throw new GeralException("Erro na Instrução SQL: "+e.getMessage());
        }
    }
    
}
