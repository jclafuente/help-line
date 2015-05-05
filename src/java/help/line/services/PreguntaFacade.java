package help.line.services;

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
public class PreguntaFacade extends AbstractFacade<Pregunta> {
  
    private static final Logger log = Logger.getLogger(PreguntaFacade.class.getName());
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PreguntaFacade() {
        super(Pregunta.class);
    }
    
     public List<Pregunta> findByCategoria(int categoriaId) {
	List<Pregunta> result = null;
	try {
	    Query query = getEntityManager().createNamedQuery("Pregunta.findByCategoriaId");
	    query.setParameter("estado", true);
	    query.setParameter("categoriaId", categoriaId);
	    result = query.getResultList();
	} catch (Exception e) {
	    log.log(Level.SEVERE, "<< SERVICE ERROR >> ".concat(e.getMessage()), e);
	}
	return result == null || result.isEmpty() ? null : result;
    }
}
