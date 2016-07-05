/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.TipoUsuario;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author 201313260070
 */
@Stateful
public class TipoUsuarioDAO<T> extends DAOGenerico<TipoUsuario> implements Serializable{

    public TipoUsuarioDAO() {
        super();
        super.setClassePersistente(TipoUsuario.class);
        super.setOrdem("permissao");
    }
}
