/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package siga.admisiones.inscripciones;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import org.primefaces.event.FlowEvent;


/**
 *
 * @author Carlos Fernando
 */
@ManagedBean
@SessionScoped
public class FormInscripciones {
/*
    @EJB
    private Validaciones validaciones;    
    private boolean skip;
    private List<SelectItem> listadoDocumentos;
    private Integer tipoDocumentoAc;//Tipo documento acudiente
    private String idDepartamentoResAc;//Departamento residencia acudiente
    private String idMunicipioResAc;//Municipio residencia acudiente
    private String numDocumentoAc;//Numero documento acudiente
    private String primNombAc;//Primer nombre acudiente
    private String segNombAc;//Segundo nombre acudiente
    private String primApeAc;//Primer apellido acudiente 
    private String segApeAc;//Segundo apellido acudiente
    private String idDepartamentoNacAc;
    private String idMunicipioNacAc;
    private List<SelectItem> listaDepartamentos;
    private List<SelectItem> listaMunicipios;
    
    
    public FormInscripciones() {
    }
    
    public void cargaMunicipios(){
        listaMunicipios = this.getListaMunicipios();
    }
    
    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public List<SelectItem> getListadoDocumentos() {
        List<TipoDocumento> listaDocumentos = validaciones.getListadoDocumentos();
        listadoDocumentos = new ArrayList<SelectItem>();
        for(TipoDocumento t:listaDocumentos){
            listadoDocumentos.add(new SelectItem(t.getIdTipDoc(),t.getNombreTipo()));
        }
        return listadoDocumentos;
    }

    public void setListadoDocumentos(List<SelectItem> listadoDocumentos) {
        this.listadoDocumentos = listadoDocumentos;
    }

    public Integer getTipoDocumentoAc() {
        return tipoDocumentoAc;
    }

    public void setTipoDocumentoAc(Integer tipoDocumentoAc) {
        this.tipoDocumentoAc = tipoDocumentoAc;
    }

    public List<SelectItem> getListaDepartamentos() {
        List<Departamentos> listadoDepartamentos = validaciones.getListaDepartamentos();
        listaDepartamentos = new ArrayList<SelectItem>();
        for(Departamentos d : listadoDepartamentos){
            listaDepartamentos.add(new SelectItem(d.getIddepartamentos(),d.getNombreDpto()));
        }
        return listaDepartamentos;
    }

    public void setListaDepartamentos(List<SelectItem> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    public String getIdDepartamentoResAc() {
        return idDepartamentoResAc;
    }

    public void setIdDepartamentoResAc(String idDepartamentoResAc) {
        this.idDepartamentoResAc = idDepartamentoResAc;
    }

    public String getIdMunicipioResAc() {
        return idMunicipioResAc;
    }

    public void setIdMunicipio(String idMunicipioResAc) {
        this.idMunicipioResAc = idMunicipioResAc;
    }
    
    
    public List<SelectItem> getListaMunicipios() {
        List<Municipios> listadoMunicipios = validaciones.getListaMunicipios(this.getIdDepartamentoResAc());
        listaMunicipios = new ArrayList<SelectItem>();
        for(Municipios m : listadoMunicipios){
            listaMunicipios.add(new SelectItem(m.getIdmunicipios(),m.getNombreMunicipio()));
        }
        return listaMunicipios;
    }

    public void setListaMunicipios(List<SelectItem> listaMunicipios) {
        this.listaMunicipios = listaMunicipios;
    }

    public String getNumDocumentoAc() {
        return numDocumentoAc;
    }

    public void setNumDocumentoAc(String numDocumentoAc) {
        this.numDocumentoAc = numDocumentoAc;
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
    }*/
    
}
