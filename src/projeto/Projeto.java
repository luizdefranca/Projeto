package projeto;

import projeto.erro.ConexaoException;
import projeto.erro.DAOException;
import projeto.negocio.basica.Bola;
import projeto.negocio.basica.Promotor;
import projeto.repositorio.DAOBolaImpl;
import projeto.repositorio.DAOPromotorImpl;
import projeto.repositorio.IDAOBola;
import projeto.repositorio.IDAOFornecedor;
import projeto.repositorio.IDAOPromotor;
import projeto.util.GerenciadorConexaoMysql;
import projeto.util.IGerenciadorConexao;

/**
 *
 * @author Tito
 */
public class Projeto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // testaConexao();
        //testaRepositorio();
        testaPromotor();
    }

    private static void testaConexao() {
        IGerenciadorConexao g = GerenciadorConexaoMysql.getInstancia();
        try{
            g.conectar();
            System.out.println("Conectado...");
        }catch(ConexaoException e){
            System.out.println("ERRO NO BD");
        }
    }

    private static void testaRepositorio() {
        IDAOBola dao = new DAOBolaImpl();
        Bola b = new Bola("Um Nome", "Uma Descricao", 10);
        try {
            dao.incluir(b);
            System.out.println("Incluiu...");
        } catch (ConexaoException ex) {
            System.out.println("ERRO NO BD");
        } catch (DAOException ex) {
            System.out.println("ERRO NA SQL");
        }
    }
    private static void testaPromotor() {
        IDAOPromotor dao = new DAOPromotorImpl() ;
        Promotor promo = new Promotor("Um Nome", "789797897","endereco", "jkhk@hkjhk.com","telefone");
        try {
            dao.incluir(promo);
            System.out.println("Incluiu...");
        } catch (ConexaoException ex) {
            System.out.println("ERRO NO BD");
        } catch (DAOException ex) {
            System.out.println("ERRO NA SQL");
        }
    }
}
