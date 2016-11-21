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
public class TiposDocumento {
    private int idTipoDoc;
    private String nombre;
    private String abreviatura;
    private String fechaRegistro;
    private int idRegistradoPor;
    private String fechaActualizacion;
    private int idActualizadoPor;

    public int getIdTipoDoc() {
        return idTipoDoc;
    }

    public void setIdTipoDoc(int idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdRegistradoPor() {
        return idRegistradoPor;
    }

    public void setIdRegistradoPor(int idRegistradoPor) {
        this.idRegistradoPor = idRegistradoPor;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public int getIdActualizadoPor() {
        return idActualizadoPor;
    }

    public void setIdActualizadoPor(int idActualizadoPor) {
        this.idActualizadoPor = idActualizadoPor;
    }
}
