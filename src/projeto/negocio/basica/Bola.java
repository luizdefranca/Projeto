package projeto.negocio.basica;

/**
 *
 * @author Tito
 */
public class Bola {
    private Integer id;
    private String nome;
    private String descricao;
    private Integer quantidade;

    public Bola(){}
    
    public Bola(String nome, String descricao, Integer quantidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the quantidade
     */
    public Integer getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(String quantidade)throws NumberFormatException {
        this.quantidade = Integer.parseInt(quantidade);
    }

    /**
     * Verifica se os campos estao validos (diferente de NULO)
     * @return Verdadeiro se TODOS os campos estiverem nao nulos
     */
    public Boolean isValido(){
        if(this.nome==null)
            return false;
        if(this.descricao==null) 
            return false;
        if(this.quantidade==null)
            return false;
        return true;
    }
}
