/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package help.line.services.ws;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import help.line.entities.Pregunta;
import help.line.services.PreguntaFacade;
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
@Path("/pregunta")
public class PreguntaREST {

    @Inject
    PreguntaFacade preguntaFacade;

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/findPreguntas")
    public String findPreguntas() {
	Gson gson = new Gson();
	// Inicializacion de objetos para el response
	Pregunta pregunta;
	List<Pregunta> result = new ArrayList<>();
	// Reasinacion de informacion necesaria
	for (Pregunta p : preguntaFacade.findAll()) {
	    pregunta = new Pregunta();
	    pregunta.setId(p.getId());
	    pregunta.setCuestion(p.getCuestion());
	    pregunta.setEstado(p.getEstado());
	    result.add(pregunta);
	}
	JsonObject jo = new JsonObject();
	jo.add("preguntas", gson.toJsonTree(result));

	return jo.toString();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/findPreguntasByCategoria")
    public String findPreguntasByCategoria(String request) {

	JsonElement root = new JsonParser().parse(request);
	JsonElement categoriaId = root.getAsJsonObject().get("categoriaId");

	System.out.println(categoriaId.getAsInt());

	Gson gson = new Gson();
	// Inicializacion de objetos para el response
	Pregunta pregunta;
	List<Pregunta> result = new ArrayList<>();
	// Reasinacion de informacion necesaria
	for (Pregunta p : preguntaFacade.findByCategoria(categoriaId.getAsInt())) {
	    pregunta = new Pregunta();
	    pregunta.setId(p.getId());
	    pregunta.setCuestion(p.getCuestion());
	    pregunta.setEstado(p.getEstado());
	    result.add(pregunta);
	}
	JsonObject jo = new JsonObject();
	jo.add("preguntas", gson.toJsonTree(result));

	return jo.toString();
    }

}
