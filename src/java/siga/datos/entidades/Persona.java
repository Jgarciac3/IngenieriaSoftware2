/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package siga.datos.entidades;

import java.util.Date;

/**
 *
 * @author Carlos Fernando
 */
public class Persona {
    private Integer idPersona;
    private Integer tipoDocumentoAc;//Tipo documento acudiente
    private String idDepartamentoRes;//Departamento residencia acudiente
    private String idMunicipioRes;//Municipio residencia acudiente
    private String numDocumento;//Numero documento acudiente
    private String primNombAc;//Primer nombre acudiente
    private String segNombAc;//Segundo nombre acudiente
    private String primApeAc;//Primer apellido acudiente 
    private String segApeAc;//Segundo apellido acudiente
    private String telMovil;
    private String telFijo;
    private String domicilio;
    private String email;
    private String fechaNac;
    private String idDepartamentoNacAc;//Departamento nacimiento acudiente
    private String idMunicipioNacAc;//Municipio nacimiento acudiente
    private String eps;

    public Integer getTipoDocumentoAc() {
        return tipoDocumentoAc;
    }

    public void setTipoDocumentoAc(Integer tipoDocumentoAc) {
        this.tipoDocumentoAc = tipoDocumentoAc;
    }

    public String getIdDepartamentoRes() {
        return idDepartamentoRes;
    }

    public void setIdDepartamentoRes(String idDepartamentoRes) {
        this.idDepartamentoRes = idDepartamentoRes;
    }

    public String getIdMunicipioRes() {
        return idMunicipioRes;
    }

    public void setIdMunicipioRes(String idMunicipioRes) {
        this.idMunicipioRes = idMunicipioRes;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getPrimNombAc() {
        return primNombAc;
    }

    public void setPrimNombAc(String primNombAc) {
        this.primNombAc = primNombAc;
    }

    public String getSegNombAc() {
        return segNombAc;
    }

    public void setSegNombAc(String segNombAc) {
        this.segNombAc = segNombAc;
    }

    public String getPrimApeAc() {
        return primApeAc;
    }

    public void setPrimApeAc(String primApeAc) {
        this.primApeAc = primApeAc;
    }

    public String getSegApeAc() {
        return segApeAc;
    }

    public void setSegApeAc(String segApeAc) {
        this.segApeAc = segApeAc;
    }

    public String getTelMovil() {
        return telMovil;
    }

    public void setTelMovil(String telMovil) {
        this.telMovil = telMovil;
    }

    public String getTelFijo() {
        return telFijo;
    }

    public void setTelFijo(String telFijo) {
        this.telFijo = telFijo;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getIdDepartamentoNacAc() {
        return idDepartamentoNacAc;
    }

    public void setIdDepartamentoNacAc(String idDepartamentoNacAc) {
        this.idDepartamentoNacAc = idDepartamentoNacAc;
    }

    public String getIdMunicipioNacAc() {
        return idMunicipioNacAc;
    }

    public void setIdMunicipioNacAc(String idMunicipioNacAc) {
        this.idMunicipioNacAc = idMunicipioNacAc;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }
    
}
