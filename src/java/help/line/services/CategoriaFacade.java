package help.line.services;

import help.line.entities.Categoria;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 * @author jlafuente
 */
@Stateless
public class CategoriaFacade extends AbstractFacade<Categoria> {  

    @Override
    protected EntityManager getEntityManager() {
	return em;
    }

    public CategoriaFacade() {
	super(Categoria.class);
    }

}
