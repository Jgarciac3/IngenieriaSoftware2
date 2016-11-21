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
public class Rol {
    private int idRol;
    private String nomRol;
    private String descripcion;
    private String fechaInsercion;
    private int registradoPor;
    private String fechaActualizacion;
    private int actualizadoPor;

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNomRol() {
        return nomRol;
    }

    public void setNomRol(String nomRol) {
        this.nomRol = nomRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaInsercion() {
        return fechaInsercion;
    }

    public void setFechaInsercion(String fechaInsercion) {
        this.fechaInsercion = fechaInsercion;
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
