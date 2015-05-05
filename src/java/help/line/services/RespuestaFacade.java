package help.line.services;

import help.line.entities.Respuesta;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author jlafuente
 */
@Stateless
public class RespuestaFacade extends AbstractFacade<Respuesta> {

    static Logger log = Logger.getLogger(RespuestaFacade.class.getName());

    public RespuestaFacade() {
	super(Respuesta.class);
    }

    @Override
    protected EntityManager getEntityManager() {
	return em;
    }

    public List<Respuesta> findByPregunta(int preguntaId) {
	List<Respuesta> result = null;
	try {
	    Query query = getEntityManager().createNamedQuery("Respuesta.findByRespuestaId");
	    query.setParameter("estado", true);
	    query.setParameter("preguntaId", preguntaId);
	    result = query.getResultList();
	} catch (Exception e) {
	    log.log(Level.SEVERE, "<< SERVICE ERROR >> ".concat(e.getMessage()), e);
	}
	return result == null || result.isEmpty() ? null : result;
    }
}
