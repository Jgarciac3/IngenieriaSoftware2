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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tipo_documento", catalog = "siga", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"tipo_abreviatura"}),
    @UniqueConstraint(columnNames = {"nombre_tipo"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocumento.findAll", query = "SELECT t FROM TipoDocumento t"),
    @NamedQuery(name = "TipoDocumento.findByIdTipDoc", query = "SELECT t FROM TipoDocumento t WHERE t.idTipDoc = :idTipDoc"),
    @NamedQuery(name = "TipoDocumento.findByNombreTipo", query = "SELECT t FROM TipoDocumento t WHERE t.nombreTipo = :nombreTipo"),
    @NamedQuery(name = "TipoDocumento.findByTipoAbreviatura", query = "SELECT t FROM TipoDocumento t WHERE t.tipoAbreviatura = :tipoAbreviatura"),
    @NamedQuery(name = "TipoDocumento.findByFechaRegistro", query = "SELECT t FROM TipoDocumento t WHERE t.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "TipoDocumento.findByRegistradoPor", query = "SELECT t FROM TipoDocumento t WHERE t.registradoPor = :registradoPor"),
    @NamedQuery(name = "TipoDocumento.findByFechaActualizacion", query = "SELECT t FROM TipoDocumento t WHERE t.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "TipoDocumento.findByActualizadoPor", query = "SELECT t FROM TipoDocumento t WHERE t.actualizadoPor = :actualizadoPor")})
public class TipoDocumento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tip_doc", nullable = false)
    private Integer idTipDoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre_tipo", nullable = false, length = 30)
    private String nombreTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "tipo_abreviatura", nullable = false, length = 3)
    private String tipoAbreviatura;
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

    public TipoDocumento() {
    }

    public TipoDocumento(Integer idTipDoc) {
        this.idTipDoc = idTipDoc;
    }

    public TipoDocumento(Integer idTipDoc, String nombreTipo, String tipoAbreviatura, Date fechaRegistro, int registradoPor) {
        this.idTipDoc = idTipDoc;
        this.nombreTipo = nombreTipo;
        this.tipoAbreviatura = tipoAbreviatura;
        this.fechaRegistro = fechaRegistro;
        this.registradoPor = registradoPor;
    }

    public Integer getIdTipDoc() {
        return idTipDoc;
    }

    public void setIdTipDoc(Integer idTipDoc) {
        this.idTipDoc = idTipDoc;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public String getTipoAbreviatura() {
        return tipoAbreviatura;
    }

    public void setTipoAbreviatura(String tipoAbreviatura) {
        this.tipoAbreviatura = tipoAbreviatura;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipDoc != null ? idTipDoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.idTipDoc == null && other.idTipDoc != null) || (this.idTipDoc != null && !this.idTipDoc.equals(other.idTipDoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "siga.persistence.entities.TipoDocumento[ idTipDoc=" + idTipDoc + " ]";
    }
    
}
