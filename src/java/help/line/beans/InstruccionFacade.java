/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package help.line.beans;

import help.line.entities.Instruccion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jlafuente
 */
@Stateless
public class InstruccionFacade extends AbstractFacade<Instruccion> {
    @PersistenceContext(unitName = "help-linePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InstruccionFacade() {
        super(Instruccion.class);
    }
    
}
