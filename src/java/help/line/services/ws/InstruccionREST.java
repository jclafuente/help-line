/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package help.line.services.ws;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import help.line.entities.Instruccion;
import help.line.services.InstruccionFacade;
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
@Path("/instruccion")
public class InstruccionREST {

    @Inject
    InstruccionFacade instruccionFacade;

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/findInstrucciones")
    public String findInstrucciones() {
	Gson gson = new Gson();
	// Inicializacion de objetos para el response
	Instruccion instruccion;
	List<Instruccion> result = new ArrayList<>();
	// Reasinacion de informacion necesaria
	for (Instruccion i : instruccionFacade.findAll()) {
	    instruccion = new Instruccion();
	    instruccion.setId(i.getId());
	    instruccion.setIndicacion(i.getIndicacion());
	    instruccion.setEstado(i.getEstado());
	    result.add(instruccion);
	}
	return gson.toJson(result);
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/findInstruccionesByRespuesta")
    public String findInstruccionesByRespuesta(String request) {

	JsonElement root = new JsonParser().parse(request);
	JsonElement respuestaId = root.getAsJsonObject().get("respuestaId");
	Gson gson = new Gson();
	// Inicializacion de objetos para el response
	Instruccion instruccion;
	List<Instruccion> result = new ArrayList<>();
	// Reasinacion de informacion necesaria
	for (Instruccion r : instruccionFacade.findByRespuesta(respuestaId.getAsInt())) {
	    instruccion = new Instruccion();
	    instruccion.setId(r.getId());
	    instruccion.setIndicacion(r.getIndicacion());
	    instruccion.setEstado(r.getEstado());
	    result.add(instruccion);
	}
	return gson.toJson(result);
    }

}
