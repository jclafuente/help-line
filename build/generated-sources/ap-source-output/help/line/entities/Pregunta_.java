package help.line.entities;

import help.line.entities.Categoria;
import help.line.entities.Respuesta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-05-04T21:37:26")
@StaticMetamodel(Pregunta.class)
public class Pregunta_ { 

    public static volatile SingularAttribute<Pregunta, Integer> id;
    public static volatile SingularAttribute<Pregunta, Categoria> categoria;
    public static volatile SingularAttribute<Pregunta, Boolean> estado;
    public static volatile SingularAttribute<Pregunta, String> cuestion;
    public static volatile ListAttribute<Pregunta, Respuesta> respuestaList;

}