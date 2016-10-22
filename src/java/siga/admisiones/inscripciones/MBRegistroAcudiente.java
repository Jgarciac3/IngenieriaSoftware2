/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package siga.admisiones.inscripciones;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import siga.business.admisiones.Validaciones;
import siga.persistence.entities.Departamentos;
import siga.persistence.entities.Municipios;
import siga.persistence.entities.TipoDocumento;

/**
 *
 * @author Carlos Fernando
 */
@ManagedBean
@SessionScoped
public class MBRegistroAcudiente {

    @EJB
    private Validaciones validaciones;    
    private List<SelectItem> listadoDocumentos;
    private Integer tipoDocumentoAc;//Tipo documento acudiente
    private String idDepartamentoResAc;//Departamento residencia acudiente
    private String idMunicipioResAc;//Municipio residencia acudiente
    private String numDocumentoAc;//Numero documento acudiente
    private String primNombAc;//Primer nombre acudiente
    private String segNombAc;//Segundo nombre acudiente
    private String primApeAc;//Primer apellido acudiente 
    private String segApeAc;//Segundo apellido acudiente
    private List<SelectItem> listaDepartamentos;
    private List<SelectItem> listaMunicipios;
    private String telMovil;
    private String telFijo;
    private String domicilio;
    private String email;
    
    @PostConstruct
    public void init(){
        tipoDocumentoAc = (Integer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("tipoDocumento");
        numDocumentoAc = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("numeroDocumento").toString();
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
    }
        
    public MBRegistroAcudiente() {        
    }
    
    public void cargaMunicipios(){
        listaMunicipios = this.getListaMunicipios();
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

    public String getIdDepartamentoResAc() {
        return idDepartamentoResAc;
    }

    public void setIdDepartamentoResAc(String idDepartamentoResAc) {
        this.idDepartamentoResAc = idDepartamentoResAc;
    }

    public String getIdMunicipioResAc() {
        return idMunicipioResAc;
    }

    public void setIdMunicipioResAc(String idMunicipioResAc) {
        this.idMunicipioResAc = idMunicipioResAc;
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

    /*
    Nombre metodo: getListaMunicipios.
    Descripcion: Obtiene la lista de municipios dependiendo del departamento seleccionado.
    Parametros: No recibe.
    */  
    public List<SelectItem> getListaMunicipios() {
        List<Municipios> listadoMunicipios = validaciones.getListaMunicipios(this.getIdDepartamentoResAc());
        listaMunicipios = new ArrayList<SelectItem>();
        for(Municipios m : listadoMunicipios){
            listaMunicipios.add(new SelectItem(m.getMunicipiosPK().getIdmunicipios(),m.getNombreMunicipio()));
        }
        return listaMunicipios;        
    }

    public void setListaMunicipios(List<SelectItem> listaMunicipios) {
        this.listaMunicipios = listaMunicipios;
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
    
}
