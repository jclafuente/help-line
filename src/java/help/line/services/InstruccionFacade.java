package help.line.services;

import help.line.entities.Instruccion;
import help.line.entities.Pregunta;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * @author jlafuente
 */
@Stateless
public class InstruccionFacade extends AbstractFacade<Instruccion> {

    private static final Logger log = Logger.getLogger(InstruccionFacade.class.getName());

    public InstruccionFacade() {
	super(Instruccion.class);
    }

    @Override
    protected EntityManager getEntityManager() {
	return em;
    }

    public List<Instruccion> findByRespuesta(int respuestaId) {
	List<Instruccion> result = null;
	try {
	    Query query = getEntityManager().createNamedQuery("Instruccion.findByRespuestaId");
	    query.setParameter("estado", true);
	    query.setParameter("respuestaId", respuestaId);
	    result = query.getResultList();
	} catch (Exception e) {
	    log.log(Level.SEVERE, "<< SERVICE ERROR >> ".concat(e.getMessage()), e);
	}
	return result == null || result.isEmpty() ? null : result;
    }
}
