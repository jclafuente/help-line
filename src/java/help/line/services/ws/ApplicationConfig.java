package help.line.services.ws;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author jlafuente
 */
@javax.ws.rs.ApplicationPath("ws")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
	resources.add(help.line.services.ws.CategoriaREST.class);
	resources.add(help.line.services.ws.InstruccionREST.class);
	resources.add(help.line.services.ws.PreguntaREST.class);
	resources.add(help.line.services.ws.RespuestaREST.class);
    }
    
}
