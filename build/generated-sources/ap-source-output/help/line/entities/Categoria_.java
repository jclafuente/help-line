package help.line.entities;

import help.line.entities.Pregunta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-05-04T21:37:26")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile SingularAttribute<Categoria, Integer> id;
    public static volatile SingularAttribute<Categoria, String> nombre;
    public static volatile SingularAttribute<Categoria, Boolean> estado;
    public static volatile SingularAttribute<Categoria, String> descripcion;
    public static volatile ListAttribute<Categoria, Pregunta> preguntaList;

}