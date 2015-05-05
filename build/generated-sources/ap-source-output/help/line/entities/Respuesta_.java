package help.line.entities;

import help.line.entities.Instruccion;
import help.line.entities.Pregunta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-05-01T11:31:11")
@StaticMetamodel(Respuesta.class)
public class Respuesta_ { 

    public static volatile SingularAttribute<Respuesta, Integer> id;
    public static volatile SingularAttribute<Respuesta, Pregunta> pregunta;
    public static volatile SingularAttribute<Respuesta, String> solucion;
    public static volatile SingularAttribute<Respuesta, Boolean> estado;
    public static volatile ListAttribute<Respuesta, Instruccion> instruccionList;

}