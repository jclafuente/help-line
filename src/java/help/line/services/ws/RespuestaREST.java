package help.line.services.ws;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import help.line.entities.Respuesta;
import help.line.services.RespuestaFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author jlafuente
 */
@Stateless
@Path("/respuesta")
public class RespuestaREST {

    @Inject
    RespuestaFacade respuestaFacade;

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/findRespuestas")
    public String findRespuestas() {
	Gson gson = new Gson();
	// Inicializacion de objetos para el response
	Respuesta respuesta;
	List<Respuesta> result = new ArrayList<>();
	// Reasinacion de informacion necesaria
	for (Respuesta r : respuestaFacade.findAll()) {
	    respuesta = new Respuesta();
	    respuesta.setId(r.getId());
	    respuesta.setSolucion(r.getSolucion());
	    respuesta.setEstado(r.getEstado());

	    result.add(respuesta);
	}
	JsonObject jo = new JsonObject();
	jo.add("respuestas", gson.toJsonTree(result));

	return jo.toString();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/findRespuestasByPregunta")
    public String findRespuestasByPregunta(String request) {

	JsonElement root = new JsonParser().parse(request);
	JsonElement preguntaId = root.getAsJsonObject().get("preguntaId");

	System.out.println(preguntaId.getAsInt());

	Gson gson = new Gson();
	// Inicializacion de objetos para el response
	Respuesta respuesta;
	List<Respuesta> result = new ArrayList<>();
	// Reasinacion de informacion necesaria
	for (Respuesta r : respuestaFacade.findByPregunta(preguntaId.getAsInt())) {
	    respuesta = new Respuesta();
	    respuesta.setId(r.getId());
	    respuesta.setSolucion(r.getSolucion());
	    respuesta.setEstado(r.getEstado());
	    result.add(respuesta);
	}
	JsonObject jo = new JsonObject();
	jo.add("respuestas", gson.toJsonTree(result));

	return jo.toString();
    }
}
