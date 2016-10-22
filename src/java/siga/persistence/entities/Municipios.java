/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package siga.persistence.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Fernando
 */
@Entity
@Table(name = "municipios", catalog = "siga", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nombre_municipio"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipios.findAll", query = "SELECT m FROM Municipios m"),
    @NamedQuery(name = "Municipios.findByIdmunicipios", query = "SELECT m FROM Municipios m WHERE m.municipiosPK.idmunicipios = :idmunicipios"),
    @NamedQuery(name = "Municipios.findByIddepartamentos", query = "SELECT m FROM Municipios m WHERE m.municipiosPK.iddepartamentos = :iddepartamentos"),
    @NamedQuery(name = "Municipios.findByNombreMunicipio", query = "SELECT m FROM Municipios m WHERE m.nombreMunicipio = :nombreMunicipio"),
    @NamedQuery(name = "Municipios.findByFechaRegistro", query = "SELECT m FROM Municipios m WHERE m.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Municipios.findByRegistradoPor", query = "SELECT m FROM Municipios m WHERE m.registradoPor = :registradoPor"),
    @NamedQuery(name = "Municipios.findByFechaActualizacion", query = "SELECT m FROM Municipios m WHERE m.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "Municipios.findByActualizadoPor", query = "SELECT m FROM Municipios m WHERE m.actualizadoPor = :actualizadoPor")})
public class Municipios implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MunicipiosPK municipiosPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_municipio", nullable = false, length = 50)
    private String nombreMunicipio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_registro", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "registrado_por", nullable = false)
    private int registradoPor;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    @Column(name = "actualizado_por")
    private Integer actualizadoPor;
    @JoinColumn(name = "iddepartamentos", referencedColumnName = "iddepartamentos", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Departamentos departamentos;

    public Municipios() {
    }

    public Municipios(MunicipiosPK municipiosPK) {
        this.municipiosPK = municipiosPK;
    }

    public Municipios(MunicipiosPK municipiosPK, String nombreMunicipio, Date fechaRegistro, int registradoPor) {
        this.municipiosPK = municipiosPK;
        this.nombreMunicipio = nombreMunicipio;
        this.fechaRegistro = fechaRegistro;
        this.registradoPor = registradoPor;
    }

    public Municipios(String idmunicipios, String iddepartamentos) {
        this.municipiosPK = new MunicipiosPK(idmunicipios, iddepartamentos);
    }

    public MunicipiosPK getMunicipiosPK() {
        return municipiosPK;
    }

    public void setMunicipiosPK(MunicipiosPK municipiosPK) {
        this.municipiosPK = municipiosPK;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getRegistradoPor() {
        return registradoPor;
    }

    public void setRegistradoPor(int registradoPor) {
        this.registradoPor = registradoPor;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Integer getActualizadoPor() {
        return actualizadoPor;
    }

    public void setActualizadoPor(Integer actualizadoPor) {
        this.actualizadoPor = actualizadoPor;
    }

    public Departamentos getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (municipiosPK != null ? municipiosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipios)) {
            return false;
        }
        Municipios other = (Municipios) object;
        if ((this.municipiosPK == null && other.municipiosPK != null) || (this.municipiosPK != null && !this.municipiosPK.equals(other.municipiosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "siga.persistence.entities.Municipios[ municipiosPK=" + municipiosPK + " ]";
    }
    
}
