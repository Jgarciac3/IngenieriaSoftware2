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
public class Municipio {
    private String idMunicipio;
    private String idDepartamento;
    private String nomMunicipio;
    private String fechaRegistro;
    private int registradoPor;
    private String fechaActualizacion;
    private int actualizadoPor;

    public String getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(String idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNomMunicipio() {
        return nomMunicipio;
    }

    public void setNomMunicipio(String nomMunicipio) {
        this.nomMunicipio = nomMunicipio;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getRegistradoPor() {
        return registradoPor;
    }

    public void setRegistradoPor(int registradoPor) {
        this.registradoPor = registradoPor;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public int getActualizadoPor() {
        return actualizadoPor;
    }

    public void setActualizadoPor(int actualizadoPor) {
        this.actualizadoPor = actualizadoPor;
    }
}
