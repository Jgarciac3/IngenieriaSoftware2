/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package siga.admisiones.inscripciones;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.primefaces.event.SelectEvent;
import siga.business.admisiones.Validaciones;
import siga.persistence.entities.TipoDocumento;

/**
 *
 * @author Carlos Fernando
 */
@ManagedBean
@SessionScoped
public class InicioInscripciones {

    @EJB
    private Validaciones validaciones;   
    private String fechaNacimiento;
    private Integer edad;
    private String numDocumento;
    private Integer tipoDocumento;
    private boolean activarBoton = true;
    private boolean activarCheck = true;
    private boolean acepta;
    private List<SelectItem> listaDocumentos;

    public boolean isAcepta() {
        return acepta;
    }

    public void setAcepta(boolean acepta) {
        this.acepta = acepta;
    }

    /**
     * Creates a new instance of InicioInscripciones
     */
    public InicioInscripciones() {
    }
    
    public void onDateSelect(SelectEvent event) {
        System.out.println("Se ha invocado el metodo de seleccion de fecha");
        Date date = (Date) event.getObject();
        try {
            date = new SimpleDateFormat("dd-MM-yyyy").parse(this.getFechaNacimiento());
        } catch (ParseException ex) {
            System.out.println("Un error ha ocurrido "+ex.getMessage());
        }
        System.out.print(date.toString());
        Integer edades = validaciones.calcularEdad(date);
        FacesContext facesContext = FacesContext.getCurrentInstance();        
        if(edades <= 18){
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atencion", "Para acceder a la inscripcion, debe ser mayor de 18 años"));
            this.setEdad(edades);
            this.setActivarCheck(true);
        }  
        else
        {
            this.setEdad(edades);
            this.setActivarCheck(false);
        }        
    }
    
    public void redireccionar(ActionEvent evt) throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("tipoDocumento", tipoDocumento);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("numeroDocumento", numDocumento);
        FacesContext.getCurrentInstance().getExternalContext().redirect("protected/registroAcudiente.xhtml");
    }
    
    public void activarBoton(){
        if(acepta)
            this.setActivarBoton(false);
        else
            this.setActivarBoton(true);        
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    
    public boolean getActivarBoton(){
        return activarBoton;
    }
    
    public void setActivarBoton(boolean activarBoton){
        this.activarBoton = activarBoton;
    }

    public boolean isActivarCheck() {
        return activarCheck;
    }

    public void setActivarCheck(boolean activarCheck) {
        this.activarCheck = activarCheck;
    }

    public List<SelectItem> getListaDocumentos() {
        List<TipoDocumento> listadoDocumentos = validaciones.getListaDocumentos();
        listaDocumentos = new ArrayList<SelectItem>();
        for(TipoDocumento t : listadoDocumentos){
            listaDocumentos.add(new SelectItem(t.getIdTipDoc(),t.getNombreTipo()));
        }
        return listaDocumentos;
    }

    public void setListaDocumentos(List<SelectItem> listaDocumentos) {
        this.listaDocumentos = listaDocumentos;
    }

    public Integer getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Integer tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }
    
}
