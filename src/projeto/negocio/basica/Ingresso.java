/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.negocio.basica;

/**
 *
 * @author Marcus
 */
public class Ingresso {
    
        private Integer codIngresso;
        private String atracao;
        private String Preco;
        private String localShow;

    /**
     * @return the codIngresso
     */
    public Integer getCodIngresso() {
        return codIngresso;
    }

    /**
     * @param codIngresso the codIngresso to set
     */
    public void setCodIngresso(Integer codIngresso) {
        this.codIngresso = codIngresso;
    }

    /**
     * @return the atracao
     */
    public String getAtracao() {
        return atracao;
    }

    /**
     * @param atracao the atracao to set
     */
    public void setAtracao(String atracao) {
        this.atracao = atracao;
    }

    /**
     * @return the Preco
     */
    public String getPreco() {
        return Preco;
    }

    /**
     * @param Preco the Preco to set
     */
    public void setPreco(String Preco) {
        this.Preco = Preco;
    }

    /**
     * @return the localShow
     */
    public String getLocalShow() {
        return localShow;
    }

    /**
     * @param localShow the localShow to set
     */
    public void setLocalShow(String localShow) {
        this.localShow = localShow;
    }
        
}
