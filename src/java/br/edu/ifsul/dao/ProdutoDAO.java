
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Exame;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 */
@Stateless
public class ProdutoDAO<T> extends DAOGenerico<Exame> implements Serializable {
 
    public ProdutoDAO() {
        super();
        super.setClassePersistente(Exame.class);
        // definindo a ordenação padrão
        super.setOrdem("nome");
    }
    
}
