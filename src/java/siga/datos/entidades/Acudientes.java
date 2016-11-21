/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package siga.datos.entidades;

/**
 *
 * @author Carlos Fernando
 */
public class Acudientes {
    private int idAcudiente;
    private int idPersona;
    private String empresa;
    private String idDepartamentoLab;
    private String idMunicipioLab;
    private String telefonoLab;
    private String direccionLab;

    public int getIdAcudiente() {
        return idAcudiente;
    }

    public void setIdAcudiente(int idAcudiente) {
        this.idAcudiente = idAcudiente;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getIdDepartamentoLab() {
        return idDepartamentoLab;
    }

    public void setIdDepartamentoLab(String idDepartamentoLab) {
        this.idDepartamentoLab = idDepartamentoLab;
    }

    public String getIdMunicipioLab() {
        return idMunicipioLab;
    }

    public void setIdMunicipioLab(String idMunicipioLab) {
        this.idMunicipioLab = idMunicipioLab;
    }

    public String getTelefonoLab() {
        return telefonoLab;
    }

    public void setTelefonoLab(String telefonoLab) {
        this.telefonoLab = telefonoLab;
    }

    public String getDireccionLab() {
        return direccionLab;
    }

    public void setDireccionLab(String direccionLab) {
        this.direccionLab = direccionLab;
    }
    
}
