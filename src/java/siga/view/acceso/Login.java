/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package siga.view.acceso;

import java.io.IOException;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import siga.business.admisiones.Validaciones;

/**
 *
 * @author Carlos Fernando
 */
@ManagedBean
@SessionScoped
public class Login {
    
    @EJB
    private Validaciones validaciones;

    /**
     * Creates a new instance of Login
     */
    
    private String usuario;
    private String clave;
    
    public Login() {
    }
    
    public void registroAcudiente(ActionEvent event) throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("inscripciones/protected/index.xhtml");
    }
    
    public void validarUsuario(ActionEvent event) throws IOException{
        int validacion = validaciones.getDatosUsuarios(clave, usuario);
        if(validacion == 1){
            FacesContext.getCurrentInstance().getExternalContext().redirect("protected/templates/menuAdmin.xhtml");
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Atencion","Usuario o contraseña invalidos. Si es un acudiente nuevo por favor registrese"));
        }
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
}
