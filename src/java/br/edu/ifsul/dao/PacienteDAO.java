
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Paciente;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 */
@Stateless
public class PacienteDAO<T> extends DAOGenerico<Paciente> implements Serializable {
    
    public PacienteDAO() {
        super();
        super.setClassePersistente(Paciente.class);
        super.setOrdem("tipoSanguineo");
    }
}
