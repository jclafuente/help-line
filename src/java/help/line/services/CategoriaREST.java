/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package help.line.services;

import com.google.gson.Gson;
import help.line.beans.CategoriaFacade;
import help.line.entities.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author jlafuente
 */
@Stateless
@Path("categoria")
public class CategoriaREST {

    @EJB
    CategoriaFacade categoriaFacade;

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/findCategorias")
    public String findCategorias() {

        Gson gson = new Gson();
        // Inicializacion de objetos para el response
        Categoria categoria;
        List<Categoria> result = new ArrayList<Categoria>();
        // Reasinacion de informacion necesaria
        for (Categoria c : categoriaFacade.findAll()) {
            categoria = new Categoria();
            categoria.setNombre(c.getNombre());
            result.add(categoria);
        }

        return gson.toJson(result);
    }

}
