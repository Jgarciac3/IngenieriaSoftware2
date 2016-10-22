/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package siga.business.admisiones;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import siga.persistence.entities.Departamentos;
import siga.persistence.entities.Municipios;
import siga.persistence.entities.TipoDocumento;
import siga.persistence.entities.Usuarios;
import siga.persistence.facades.DepartamentosFacade;
import siga.persistence.facades.MunicipiosFacade;
import siga.persistence.facades.TipoDocumentoFacade;
import siga.persistence.facades.UsuariosFacade;

/**
 *
 * @author Carlos Fernando
 */
@Stateless
@LocalBean
public class Validaciones {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @EJB
    private TipoDocumentoFacade tipoDocumento;
    
    @EJB
    private DepartamentosFacade departamentos;
    
    @EJB
    private MunicipiosFacade municipios;
    private List<TipoDocumento> listaDocumentos;
    private List<TipoDocumento> listadoDocumentos;
    private List<Departamentos> listaDepartamentos;
    private List<Municipios> listaMunicipios;
    private int datosUsuarios;
    
    @EJB
    private UsuariosFacade usuarios;
    
    public Integer calcularEdad(Date fecha){
        //Date fechaNacimiento = null;
        /*try {
            fechaNacimiento = new SimpleDateFormat("dd-MM-yyyy").parse(fecha);
        } catch (ParseException ex) {
            System.out.println("Ha ocurrido un error"+ex.getMessage());
        }*/
        Calendar fechaNac = Calendar.getInstance();
        Calendar fechaActual = Calendar.getInstance();
        fechaNac.setTime(fecha);
        
        int ano = fechaActual.get(Calendar.YEAR)-fechaNac.get(Calendar.YEAR);
        int mes = fechaActual.get(Calendar.MONTH)-fechaNac.get(Calendar.MONTH);
        int dia = fechaActual.get(Calendar.DATE)-fechaNac.get(Calendar.DATE);
        
        if(mes<0 || (mes==0 && dia<0)){
            ano--;
        }        
        return ano;
    }

    public List<TipoDocumento> getListaDocumentos() {
        listaDocumentos = tipoDocumento.listaDocumentos();
        return listaDocumentos;
    }

    public List<TipoDocumento> getListadoDocumentos() {
        listadoDocumentos = tipoDocumento.findAll();
        return listadoDocumentos;
    }

    public List<Departamentos> getListaDepartamentos() {
        listaDepartamentos = departamentos.findAll();
        return listaDepartamentos;
    }

    public List<Municipios> getListaMunicipios(String idMunicipio) {
        listaMunicipios = municipios.obtenerMunicipios(idMunicipio);
        return listaMunicipios;
    }

    public int getDatosUsuarios(String clave, String usuario) {
        Usuarios datosUsuario = usuarios.obtenerUsuarios(clave, usuario);
        if(datosUsuario == null){
            return -1;
        }
        else{
            return -1;
        }        
    }

}
