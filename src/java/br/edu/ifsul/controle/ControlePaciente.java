
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.PessoaDAO;
import br.edu.ifsul.dao.PacienteDAO;
import br.edu.ifsul.modelo.Paciente;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 */
@ManagedBean(name = "controlePaciente")
@SessionScoped
public class ControlePaciente implements Serializable {
    
    @EJB
    private PacienteDAO<Paciente> dao;
    private Paciente objeto;
    @EJB
    private PessoaDAO daoPessoa;

    public ControlePaciente() {
    }
    
    public String listar(){
        return "/privado/paciente/listar?faces-redirect=true";
    }
    
    public void novo(){
        setObjeto(new Paciente());        
    }
    
    public void salvar(){
        try {
            if(getObjeto().getId() == null){
                getDao().persist(getObjeto());
            } else {
                getDao().merge(getObjeto());
            }
            UtilMensagem.mensagemInformacao("Objeto persistido com sucesso");            
        } catch(Exception e){
            UtilMensagem.mensagemErro("Erro ao persistir: "+e.getMessage());            
        }
    }
    
    public void editar(Integer id){
        try {
            setObjeto(getDao().getObjectById(id));            
        } catch (Exception e){
            UtilMensagem.mensagemErro("Erro ao recuperar objeto: "+e.getMessage());            
        }
    }
    
    public void remover(Integer id){
        try {
            setObjeto(getDao().getObjectById(id));
            getDao().remove(getObjeto());
            UtilMensagem.mensagemInformacao("Objeto removido com sucesso!");            
        } catch(Exception e){
            UtilMensagem.mensagemErro("Erro a remover objeto: "+e.getMessage());
        }
    }

    public PacienteDAO<Paciente> getDao() {
        return dao;
    }

    public void setDao(PacienteDAO<Paciente> dao) {
        this.dao = dao;
    }

    public Paciente getObjeto() {
        return objeto;
    }

    public void setObjeto(Paciente objeto) {
        this.objeto = objeto;
    }

    public PessoaDAO getDaoPessoa() {
        return daoPessoa;
    }

    public void setDaoPessoa(PessoaDAO daoPessoa) {
        this.daoPessoa = daoPessoa;
    }
}
