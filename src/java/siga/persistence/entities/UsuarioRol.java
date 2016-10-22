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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Fernando
 */
@Entity
@Table(name = "usuario_rol", catalog = "siga", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idroles", "idusuarios"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioRol.findAll", query = "SELECT u FROM UsuarioRol u"),
    @NamedQuery(name = "UsuarioRol.findByIdusuarioRol", query = "SELECT u FROM UsuarioRol u WHERE u.idusuarioRol = :idusuarioRol"),
    @NamedQuery(name = "UsuarioRol.findByFechaRegistro", query = "SELECT u FROM UsuarioRol u WHERE u.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "UsuarioRol.findByRegistradoPor", query = "SELECT u FROM UsuarioRol u WHERE u.registradoPor = :registradoPor"),
    @NamedQuery(name = "UsuarioRol.findByFechaActualizacion", query = "SELECT u FROM UsuarioRol u WHERE u.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "UsuarioRol.findByActualizadoPor", query = "SELECT u FROM UsuarioRol u WHERE u.actualizadoPor = :actualizadoPor")})
public class UsuarioRol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuario_rol", nullable = false)
    private Integer idusuarioRol;
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
    @JoinColumn(name = "idroles", referencedColumnName = "idroles", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Roles idroles;
    @JoinColumn(name = "idusuarios", referencedColumnName = "idusuarios", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuarios idusuarios;

    public UsuarioRol() {
    }

    public UsuarioRol(Integer idusuarioRol) {
        this.idusuarioRol = idusuarioRol;
    }

    public UsuarioRol(Integer idusuarioRol, Date fechaRegistro, int registradoPor) {
        this.idusuarioRol = idusuarioRol;
        this.fechaRegistro = fechaRegistro;
        this.registradoPor = registradoPor;
    }

    public Integer getIdusuarioRol() {
        return idusuarioRol;
    }

    public void setIdusuarioRol(Integer idusuarioRol) {
        this.idusuarioRol = idusuarioRol;
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

    public Roles getIdroles() {
        return idroles;
    }

    public void setIdroles(Roles idroles) {
        this.idroles = idroles;
    }

    public Usuarios getIdusuarios() {
        return idusuarios;
    }

    public void setIdusuarios(Usuarios idusuarios) {
        this.idusuarios = idusuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuarioRol != null ? idusuarioRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioRol)) {
            return false;
        }
        UsuarioRol other = (UsuarioRol) object;
        if ((this.idusuarioRol == null && other.idusuarioRol != null) || (this.idusuarioRol != null && !this.idusuarioRol.equals(other.idusuarioRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "siga.persistence.entities.UsuarioRol[ idusuarioRol=" + idusuarioRol + " ]";
    }
    
}
