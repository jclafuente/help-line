package help.line.services.ws;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import help.line.entities.Categoria;
import help.line.services.CategoriaFacade;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Stateless
@Path("/categoria")
public class CategoriaREST {

    @Inject
    CategoriaFacade categoriaFacade;

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/findCategorias")
    public String findCategorias() {
        Gson gson = new Gson();
        // Inicializacion de objetos para el response
        List<Categoria> result = new ArrayList<>();
        // Reasinacion de informacion necesaria
        for (Categoria c : categoriaFacade.findAll()) {
	    c.setPreguntaList(null);
            result.add(c);
        }
	
	JsonObject jo = new JsonObject();
	jo.add("categorias", gson.toJsonTree(result));
	
        return jo.toString();
    }
}
