/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package help.line.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jlafuente
 */
@Entity
@Table(name = "instruccion", catalog = "help_line", schema = "")
@NamedQueries({
    @NamedQuery(name = "Instruccion.findAll", query = "SELECT i FROM Instruccion i"),
    @NamedQuery(name = "Instruccion.findById", query = "SELECT i FROM Instruccion i WHERE i.id = :id"),
    @NamedQuery(name = "Instruccion.findByIndicacion", query = "SELECT i FROM Instruccion i WHERE i.indicacion = :indicacion"),
    @NamedQuery(name = "Instruccion.findByEstado", query = "SELECT i FROM Instruccion i WHERE i.estado = :estado")})
public class Instruccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2024)
    @Column(name = "indicacion")
    private String indicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @JoinColumn(name = "respuesta", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Respuesta respuesta;

    public Instruccion() {
    }

    public Instruccion(Integer id) {
        this.id = id;
    }

    public Instruccion(Integer id, String indicacion, boolean estado) {
        this.id = id;
        this.indicacion = indicacion;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIndicacion() {
        return indicacion;
    }

    public void setIndicacion(String indicacion) {
        this.indicacion = indicacion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instruccion)) {
            return false;
        }
        Instruccion other = (Instruccion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "help.line.entities.Instruccion[ id=" + id + " ]";
    }
    
}
