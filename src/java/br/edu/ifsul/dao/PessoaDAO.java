
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Pessoa;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 */
@Stateless
public class PessoaDAO<T> extends DAOGenerico<Pessoa> implements Serializable {
 
    public PessoaDAO() {
        super();
        super.setClassePersistente(Pessoa.class);
        super.setOrdem("nome");
    }
    
}
