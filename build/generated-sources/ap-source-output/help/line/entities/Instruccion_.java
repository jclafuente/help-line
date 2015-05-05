package help.line.entities;

import help.line.entities.Respuesta;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-05-04T21:37:26")
@StaticMetamodel(Instruccion.class)
public class Instruccion_ { 

    public static volatile SingularAttribute<Instruccion, Integer> id;
    public static volatile SingularAttribute<Instruccion, Boolean> estado;
    public static volatile SingularAttribute<Instruccion, String> indicacion;
    public static volatile SingularAttribute<Instruccion, Respuesta> respuesta;

}