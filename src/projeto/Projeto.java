package projeto;

import projeto.erro.ConexaoException;
import projeto.erro.DAOException;
import projeto.negocio.basica.Bola;
import projeto.repositorio.DAOBolaImpl;
import projeto.repositorio.IDAOBola;
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
        testaConexao();
        testaRepositorio();
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
    
}
