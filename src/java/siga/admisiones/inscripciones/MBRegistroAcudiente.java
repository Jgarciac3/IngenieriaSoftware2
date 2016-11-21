/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siga.admisiones.inscripciones;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import siga.conexiones.modelo.OperacionesAcudiente;
import siga.datos.entidades.Acudientes;
import siga.datos.entidades.Departamento;
import siga.datos.entidades.Municipio;
import siga.datos.entidades.Persona;
import siga.datos.entidades.TiposDocumento;
import siga.datos.entidades.Usuario;

/**
 *
 * @author Carlos Fernando
 */
@ManagedBean
@SessionScoped
public class MBRegistroAcudiente {

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
    private List<SelectItem> listaDepartamentosNac;
    private List<SelectItem> listaMunicipiosNac;
    private List<SelectItem> listaMunicipiosLab;
    private String telMovil;
    private String telFijo;
    private String domicilio;
    private String email;
    private Date fechaNac;
    private String idDepartamentoNacAc;//Departamento nacimiento acudiente
    private String idMunicipioNacAc;//Municipio nacimiento acudiente
    private String eps;
    private String empresa;
    private String idDepartamentoLab;
    private String idMunicipioLab;
    private String telefonoLab;
    private String direccionLab;
    private String usuarioInfo1;
    private String usuarioInfo2;

    private OperacionesAcudiente conexion;
    private Persona persona;
    private Acudientes acudiente;
    private Usuario usuario;

    @PostConstruct
    public void init() {
        tipoDocumentoAc = (Integer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("tipoDocumento");
        numDocumentoAc = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("numeroDocumento").toString();
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
    }

    public MBRegistroAcudiente() {
    }

    public void cargaMunicipios() throws SQLException {
        listaMunicipios = this.getListaMunicipios();
    }

    public void cargaMunicipioNac() throws SQLException {
        listaMunicipiosNac = this.getListaMunicipiosNac();
    }

    public void cargaMunicipioLab() throws SQLException {
        listaMunicipiosLab = this.getListaMunicipiosLab();
    }

    public void registrarAcudiente(ActionEvent actionEvent) throws SQLException {
        System.out.println("INFO 1------>" + usuarioInfo1);
        System.out.println("INFO 2------>" + usuarioInfo2);
        if (usuarioInfo2.equals(usuarioInfo1) == false) {
            mostrarMensaje("Las contraseñas no coinciden");
        } else {
            Integer insercionPersona = this.getConexion().registrarPersona(this.getPersona());
            String documento = this.getPersona().getNumDocumento();
            int idPersona = this.getConexion().obtenerIdPersona(documento);
            System.out.println("El id recuperado es -->" + idPersona);
            if(insercionPersona == 1){
                mostrarMensaje("Se registro la info");               
                Integer insercionAcudiente = this.getConexion().registrarAcudiente(this.getAcudiente(idPersona));
                if(insercionAcudiente == 1){
                    mostrarMensaje("Se registro la info de acudiente");
                    Integer insercionUsuario = this.getConexion().registrarUsuario(this.getUsuario(idPersona));
                    if(insercionUsuario == 1){
                        mostrarMensaje("Se registro la info de usuario");
                    }
                }
                else{
                    mostrarMensaje("No se registro la info de acudiente");
                }
            }
            else{
                mostrarMensaje("Se registro la info de personas");
            }
            /*
            //if(insercionPersona != -1){
            
            
            if (insercionAcudiente != 1) {
                mostrarMensaje("La informacion de acudientes se registro");
            }
            if (insercionUsuario != 1) {
                mostrarMensaje("La informacion de usuario se registro");
            }
            //}
            /*else{
             mostrarMensaje("La informacion de usuario se registro");
             }*/
        }
    }

    public void mostrarMensaje(String mensaje) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<SelectItem> getListadoDocumentos() throws SQLException {
        List<TiposDocumento> listaDocumentos = this.getConexion().listaDocumentos();
        listadoDocumentos = new ArrayList<SelectItem>();
        for (TiposDocumento t : listaDocumentos) {
            listadoDocumentos.add(new SelectItem(t.getIdTipoDoc(), t.getNombre()));
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

    public List<SelectItem> getListaDepartamentos() throws SQLException {
        List<Departamento> listadoDepartamentos = this.getConexion().listaDepartamentos();
        listaDepartamentos = new ArrayList<SelectItem>();
        for (Departamento d : listadoDepartamentos) {
            listaDepartamentos.add(new SelectItem(d.getIdDepartamento(), d.getNombreDpto()));
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
    public List<SelectItem> getListaMunicipios() throws SQLException {
        List<Municipio> listadoMunicipios = this.getConexion().listaMunicipio(this.getIdDepartamentoResAc());
        listaMunicipios = new ArrayList<SelectItem>();
        for (Municipio m : listadoMunicipios) {
            listaMunicipios.add(new SelectItem(m.getIdMunicipio(), m.getNomMunicipio()));
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

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    /*
     Nombre metodo: getListaMunicipiosNac.
     Descripcion: Obtiene la lista de municipios dependiendo del departamento seleccionado.
     Parametros: No recibe.
     */
    public List<SelectItem> getListaMunicipiosNac() throws SQLException {
        List<Municipio> listadoMunicipios = this.getConexion().listaMunicipio(this.getIdDepartamentoNacAc());
        listaMunicipios = new ArrayList<SelectItem>();
        for (Municipio m : listadoMunicipios) {
            listaMunicipios.add(new SelectItem(m.getIdMunicipio(), m.getNomMunicipio()));
        }
        return listaMunicipios;
    }

    public void setListaDepartamentosNac(List<SelectItem> listaDepartamentosNac) {
        this.listaDepartamentosNac = listaDepartamentosNac;
    }

    public void setListaMunicipiosNac(List<SelectItem> listaMunicipiosNac) {
        this.listaMunicipiosNac = listaMunicipiosNac;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
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

    public List<SelectItem> getListaMunicipiosLab() throws SQLException {
        List<Municipio> listadoMunicipios = this.getConexion().listaMunicipio(this.getIdDepartamentoLab());
        listaMunicipios = new ArrayList<SelectItem>();
        for (Municipio m : listadoMunicipios) {
            listaMunicipios.add(new SelectItem(m.getIdMunicipio(), m.getNomMunicipio()));
        }
        return listaMunicipios;

    }

    public void setListaMunicipiosLab(List<SelectItem> listaMunicipiosLab) {
        this.listaMunicipiosLab = listaMunicipiosLab;
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

    public String getUsuarioInfo1() {
        return usuarioInfo1;
    }

    public void setUsuarioInfo1(String usuarioInfo1) {
        this.usuarioInfo1 = usuarioInfo1;
    }

    public String getUsuarioInfo2() {
        return usuarioInfo2;
    }

    public void setUsuarioInfo2(String usuarioInfo2) {
        this.usuarioInfo2 = usuarioInfo2;
    }
    /*
     public Acudiente getAcudiente(int idPersona) {
     if(acudiente == null){
     acudiente.setIdpersonaAdm(this.getIdPersonas(idPersona));
     acudiente.setAcudDireccionlab(direccionLab);
     acudiente.setAcudEmpresa(empresa);
     acudiente.setAcudCiulab(this.getMunicipio(idMunicipioLab));
     acudiente.setAcudDeptlab(this.getDepartamento(idDepartamentoLab));
     acudiente.setAcudTelefono(telefonoLab);
     }
     return acudiente;
     }*/

    /*
     public AdmPersonas getIdPersonas(Integer idPersona) {
     if(idPersonas == null){
     idPersonas = new AdmPersonas();
     idPersonas.setIdpersonaAdm(idPersona);
     }
     return idPersonas;
     } 

     public TipoDocumento getTipoDocumento() {
     tipoDocumento = new TipoDocumento();
     tipoDocumento.setIdTipDoc(tipoDocumentoAc);
     return tipoDocumento;
     }

     public Municipios getMunicipio(String municipios) {
     municipio = new Municipios();
     municipio.setIdmunicipios(municipios);
     return municipio;
     }

     public Departamentos getDepartamento(String dpto) {
     departamento = new Departamentos();
     departamento.setIddepartamentos(dpto);
     return departamento;
     }     

     public Usuarios getUsuarios(Integer idPersonas) {
     if(usuarios == null){
     usuarios = new Usuarios();
     usuarios.setFechaRegistro(new Date());
     usuarios.setUsrNombre(numDocumentoAc);
     usuarios.setUsrPasswd(usuarioInfo1);
     usuarios.setIdpersona(this.getIdPersonas(idPersonas));
     usuarios.setRegistradoPor(1);
     }
     return usuarios;
     }
    
     public Usuarios idUsuarios(int id){
     if(usuarios == null){
     usuarios.setIdusuarios(id);
     }
     return usuarios;
     }

     public UsuarioRol getRoles(int idUsuario) {
     if(usuarioRoles == null){
     usuarioRoles = new UsuarioRol();
     usuarioRoles.setFechaRegistro(new Date());
     usuarioRoles.setIdroles(this.getRol(1));
     usuarioRoles.setRegistradoPor(1);
     usuarioRoles.setIdusuarios(this.idUsuarios(idUsuario));            
     }
     return usuarioRoles;
     }
    
     public Roles getRol(int rol){
     if(roles == null){
     roles = new Roles();
     roles.setIdroles(rol);
     }
     return roles;
     }*/
    public OperacionesAcudiente getConexion() {
        conexion = new OperacionesAcudiente();
        return conexion;
    }

    public Persona getPersona() {
        if (persona == null) {
            persona = new Persona();
            persona.setTipoDocumentoAc(tipoDocumentoAc);
            persona.setNumDocumento(numDocumentoAc);
            persona.setPrimApeAc(primApeAc);
            persona.setSegApeAc(segApeAc);
            persona.setPrimNombAc(primNombAc);
            persona.setSegNombAc(segNombAc);
            persona.setFechaNac(this.formatearFecha(fechaNac));
            persona.setIdMunicipioNacAc(idMunicipioNacAc);
            persona.setIdDepartamentoNacAc(idDepartamentoNacAc);
            persona.setDomicilio(domicilio);
            persona.setTelFijo(telFijo);
            persona.setTelMovil(telMovil);
            persona.setIdMunicipioRes(idMunicipioResAc);
            persona.setIdDepartamentoRes(idDepartamentoResAc);
            persona.setEmail(email);
            persona.setEps(eps);
        }
        return persona;
    }

    public String formatearFecha(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(fecha);
        return date;
    }

    public Acudientes getAcudiente(int idPersona) {
        if (acudiente == null) {
            acudiente = new Acudientes();
            acudiente.setIdPersona(idPersona);
            acudiente.setDireccionLab(direccionLab);
            acudiente.setEmpresa(empresa);
            acudiente.setIdDepartamentoLab(idDepartamentoLab);
            acudiente.setIdMunicipioLab(idMunicipioLab);
            acudiente.setTelefonoLab(telefonoLab);
        }
        return acudiente;
    }

    public Usuario getUsuario(int idPersona) {
        if (usuario == null) {
            usuario = new Usuario();
            usuario.setIdPersona(idPersona);
            usuario.setNomUsuario(this.getNumDocumentoAc());
            usuario.setNomClave(usuarioInfo1);
            usuario.setFechaRegistro("2016-11-20");
            usuario.setRegistradoPor(1);
        }
        return usuario;
    }

}
