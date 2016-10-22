/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package siga.persistence.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Carlos Fernando
 */
@Embeddable
public class MunicipiosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "idmunicipios", nullable = false, length = 3)
    private String idmunicipios;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "iddepartamentos", nullable = false, length = 3)
    private String iddepartamentos;

    public MunicipiosPK() {
    }

    public MunicipiosPK(String idmunicipios, String iddepartamentos) {
        this.idmunicipios = idmunicipios;
        this.iddepartamentos = iddepartamentos;
    }

    public String getIdmunicipios() {
        return idmunicipios;
    }

    public void setIdmunicipios(String idmunicipios) {
        this.idmunicipios = idmunicipios;
    }

    public String getIddepartamentos() {
        return iddepartamentos;
    }

    public void setIddepartamentos(String iddepartamentos) {
        this.iddepartamentos = iddepartamentos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmunicipios != null ? idmunicipios.hashCode() : 0);
        hash += (iddepartamentos != null ? iddepartamentos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MunicipiosPK)) {
            return false;
        }
        MunicipiosPK other = (MunicipiosPK) object;
        if ((this.idmunicipios == null && other.idmunicipios != null) || (this.idmunicipios != null && !this.idmunicipios.equals(other.idmunicipios))) {
            return false;
        }
        if ((this.iddepartamentos == null && other.iddepartamentos != null) || (this.iddepartamentos != null && !this.iddepartamentos.equals(other.iddepartamentos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "siga.persistence.entities.MunicipiosPK[ idmunicipios=" + idmunicipios + ", iddepartamentos=" + iddepartamentos + " ]";
    }
    
}
