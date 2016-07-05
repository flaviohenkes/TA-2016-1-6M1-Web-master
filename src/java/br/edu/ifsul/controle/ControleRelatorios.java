/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CidadeDAO;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.util.UtilRelatorios;
import java.io.Serializable;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author 201313260070
 */
@ManagedBean(name = "controleRelatorios")
@SessionScoped
public class ControleRelatorios implements Serializable{
    @EJB
    private CidadeDAO<Cidade> daoCidade;

    public ControleRelatorios() {
    }

    public void imprimeRelatorioCidades(){
        HashMap parametros = new HashMap();
        UtilRelatorios.imprimeRelatorio("relatorioCidadesJavaBeans", parametros, daoCidade.getListaTodos());
    }
    
    public CidadeDAO<Cidade> getDaoCidade() {
        return daoCidade;
    }

    public void setDaoCidade(CidadeDAO<Cidade> daoCidade) {
        this.daoCidade = daoCidade;
    }
}
