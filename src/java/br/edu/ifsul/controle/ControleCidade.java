
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CidadeDAO;
import br.edu.ifsul.modelo.Cidade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 */
@ManagedBean(name = "controleCidade")
@SessionScoped
public class ControleCidade implements Serializable {
    
    @EJB
    private CidadeDAO<Cidade> dao;
    private Cidade objeto;

    public ControleCidade() {
    }
    
    public String listar(){
        return "/privado/cidade/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Cidade();        
    }
    
    public void salvar(){
        try {
            if(objeto.getId() == null){
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            UtilMensagem.mensagemInformacao("Objeto persistido com sucesso");            
        } catch(Exception e){
            UtilMensagem.mensagemErro("Erro ao persistir: "+e.getMessage());            
        }
    }
    
    public void editar(Integer id){
        try {
            objeto = dao.getObjectById(id);            
        } catch (Exception e){
            UtilMensagem.mensagemErro("Erro ao recuperar objeto: "+e.getMessage());            
        }
    }
    
    public void remover(Integer id){
        try {
            objeto = dao.getObjectById(id);
            dao.remove(objeto);
            UtilMensagem.mensagemInformacao("Objeto removido com sucesso!");            
        } catch(Exception e){
            UtilMensagem.mensagemErro("Erro a remover objeto: "+e.getMessage());
        }
    }

    public CidadeDAO getDao() {
        return dao;
    }

    public void setDao(CidadeDAO dao) {
        this.dao = dao;
    }

    public Cidade getObjeto() {
        return objeto;
    }

    public void setObjeto(Cidade objeto) {
        this.objeto = objeto;
    }

}
