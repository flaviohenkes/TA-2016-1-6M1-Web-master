/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.TipoUsuarioDAO;
import br.edu.ifsul.dao.TipoUsuarioDAO;
import br.edu.ifsul.modelo.TipoUsuario;
import br.edu.ifsul.modelo.TipoUsuario;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author 201313260070
 */
@ManagedBean(name = "controleTipoUsuario")
@SessionScoped
public class ControleTipoUsuario implements Serializable{
    @EJB
    private TipoUsuarioDAO<TipoUsuario> dao;
    private TipoUsuario objeto;

    public ControleTipoUsuario() {
    }
    
    public String listar(){
        return "/privado/tipousuario/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new TipoUsuario();        
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

    public TipoUsuarioDAO getDao() {
        return dao;
    }

    public void setDao(TipoUsuarioDAO dao) {
        this.dao = dao;
    }

    public TipoUsuario getObjeto() {
        return objeto;
    }

    public void setObjeto(TipoUsuario objeto) {
        this.objeto = objeto;
    }
}
