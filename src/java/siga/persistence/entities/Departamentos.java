/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package siga.persistence.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos Fernando
 */
@Entity
@Table(name = "departamentos", catalog = "siga", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nombre_dpto"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamentos.findAll", query = "SELECT d FROM Departamentos d"),
    @NamedQuery(name = "Departamentos.findByIddepartamentos", query = "SELECT d FROM Departamentos d WHERE d.iddepartamentos = :iddepartamentos"),
    @NamedQuery(name = "Departamentos.findByNombreDpto", query = "SELECT d FROM Departamentos d WHERE d.nombreDpto = :nombreDpto"),
    @NamedQuery(name = "Departamentos.findByFechaRegistro", query = "SELECT d FROM Departamentos d WHERE d.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Departamentos.findByRegistradoPor", query = "SELECT d FROM Departamentos d WHERE d.registradoPor = :registradoPor"),
    @NamedQuery(name = "Departamentos.findByFechaActualizacion", query = "SELECT d FROM Departamentos d WHERE d.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "Departamentos.findByActualizadoPor", query = "SELECT d FROM Departamentos d WHERE d.actualizadoPor = :actualizadoPor")})
public class Departamentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "iddepartamentos", nullable = false, length = 3)
    private String iddepartamentos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre_dpto", nullable = false, length = 60)
    private String nombreDpto;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamentos", fetch = FetchType.LAZY)
    private List<Municipios> municipiosList;

    public Departamentos() {
    }

    public Departamentos(String iddepartamentos) {
        this.iddepartamentos = iddepartamentos;
    }

    public Departamentos(String iddepartamentos, String nombreDpto, Date fechaRegistro, int registradoPor) {
        this.iddepartamentos = iddepartamentos;
        this.nombreDpto = nombreDpto;
        this.fechaRegistro = fechaRegistro;
        this.registradoPor = registradoPor;
    }

    public String getIddepartamentos() {
        return iddepartamentos;
    }

    public void setIddepartamentos(String iddepartamentos) {
        this.iddepartamentos = iddepartamentos;
    }

    public String getNombreDpto() {
        return nombreDpto;
    }

    public void setNombreDpto(String nombreDpto) {
        this.nombreDpto = nombreDpto;
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

    @XmlTransient
    public List<Municipios> getMunicipiosList() {
        return municipiosList;
    }

    public void setMunicipiosList(List<Municipios> municipiosList) {
        this.municipiosList = municipiosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddepartamentos != null ? iddepartamentos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamentos)) {
            return false;
        }
        Departamentos other = (Departamentos) object;
        if ((this.iddepartamentos == null && other.iddepartamentos != null) || (this.iddepartamentos != null && !this.iddepartamentos.equals(other.iddepartamentos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "siga.persistence.entities.Departamentos[ iddepartamentos=" + iddepartamentos + " ]";
    }
    
}
