/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package siga.conexiones.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
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
public class OperacionesAcudiente {
    
    private Connection conexion;
    private Statement instruccion;
    private DataSource dataSource;
    
    public OperacionesAcudiente(){
        try{
            Class.forName("com.mysql.jdbc.Driver");      
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/siga","siga","Anita2011");
            instruccion = conexion.createStatement();
        }
        catch (SQLException ex) {
            Logger.getLogger(OperacionesAcudiente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OperacionesAcudiente.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public List<TiposDocumento> listaDocumentosValidacion() throws SQLException{
        List<TiposDocumento> listaDocumentos = new ArrayList<TiposDocumento>();
        String sql = "select t.id_tip_doc,t.nombre_tipo from siga.tipo_documento t where id_tip_doc <> 1";
        ResultSet result = instruccion.executeQuery(sql);
        while(result.next()){
            TiposDocumento tipo = new TiposDocumento();
            tipo.setIdTipoDoc(result.getInt(1));
            tipo.setNombre(result.getString(2));
            listaDocumentos.add(tipo);
        }
        return listaDocumentos;
    }
    
    public List<TiposDocumento> listaDocumentos() throws SQLException{
        List<TiposDocumento> listaDocumentos = new ArrayList<TiposDocumento>();
        String sql = "select t.id_tip_doc,t.nombre_tipo from siga.tipo_documento t ";
        ResultSet result = instruccion.executeQuery(sql);
        while(result.next()){
            TiposDocumento tipo = new TiposDocumento();
            tipo.setIdTipoDoc(result.getInt(1));
            tipo.setNombre(result.getString(2));
            listaDocumentos.add(tipo);
        }
        return listaDocumentos;
    }
    
    public List<Departamento> listaDepartamentos() throws SQLException{
        List<Departamento> listadoDepartamentos = new ArrayList<Departamento>();
        String sql = "select d.iddepartamentos, d.nombre_dpto from siga.departamentos d order by d.nombre_dpto";
        ResultSet result = instruccion.executeQuery(sql);
        while(result.next()){
            Departamento dept = new Departamento();
            dept.setIdDepartamento(result.getString(1));
            dept.setNombreDpto(result.getString(2));
            listadoDepartamentos.add(dept);
        }
        return listadoDepartamentos;    
    }
    
    public List<Municipio> listaMunicipio(String idDpto) throws SQLException{
        List<Municipio> listadoMunicipio = new ArrayList<Municipio>();
        String sql = "select m.idmunicipios, m.nombre_municipio from siga.municipios m where m.iddepartamento = '"+idDpto+"' order by m.nombre_municipio";
        ResultSet result = instruccion.executeQuery(sql);
        while(result.next()){
            Municipio municipio = new Municipio();
            municipio.setIdMunicipio(result.getString(1));
            municipio.setNomMunicipio(result.getString(2));
            listadoMunicipio.add(municipio);
        }
        return listadoMunicipio;
        
    }
    
    public Integer calcularEdad(Date fecha){
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
    
    /*
    Metodo que recibe un objeto de tipo persona y lo inserta en la tabla adm_personas
    */    
    public int registrarPersona(Persona persona){
        int insertado;
        String sql = "insert into siga.adm_personas values (NULL,"+persona.getTipoDocumentoAc()+",'"+persona.getNumDocumento()+"', "
                + "'"+persona.getPrimApeAc()+"','"+persona.getSegApeAc()+"','"+persona.getPrimNombAc()+"','"+persona.getSegNombAc()+"','"+persona.getFechaNac()+"', "
                + "'"+persona.getIdMunicipioNacAc()+"','"+persona.getIdDepartamentoNacAc()+"','"+persona.getDomicilio()+"','"+persona.getTelFijo()+"','"+persona.getTelMovil()+"', "
                + "'"+persona.getIdMunicipioRes()+"','"+persona.getIdDepartamentoRes()+"','"+persona.getEmail()+"','"+persona.getEps()+"')";
        System.out.println(""+sql);
        try{
            instruccion.executeUpdate(sql);
            insertado = 1;
            
        }catch(SQLException ex){
            System.out.println("Error al insertar la persona-->"+ex.getMessage());
            insertado = -1;
        }
        return insertado;        
    }
    
    /*
    
    */
    public int obtenerIdPersona(String documento) throws SQLException{
        int usuario=-1;
        String sql = "select p.idpersona_adm from siga.adm_personas p where p.numdocumento = '"+documento+"'";
        ResultSet result = instruccion.executeQuery(sql);
        if(result.first()){
            usuario = result.getInt(1);
        }
        return usuario;
    }
    
    public int registrarAcudiente(Acudientes acudiente){
        int insertado;
        String sql = "insert into siga.acudiente values (NULL,'"+acudiente.getIdPersona()+"','"+acudiente.getDireccionLab()+"','"+acudiente.getIdMunicipioLab()+"',"
                + "'"+acudiente.getIdDepartamentoLab()+"','"+acudiente.getTelefonoLab()+"','"+acudiente.getEmpresa()+"')";
        try{
            instruccion.executeUpdate(sql);
            insertado = 1;
        }catch(SQLException ex){
            System.out.println("Error al insertar al acudiente-->"+ex.getMessage());
            insertado = -1;
        }
        return insertado;        
    }
    
    public int registrarUsuario(Usuario usuario){
        int insertado;
        String sql = "insert into siga.usuarios (idusuarios,idpersona,usr_nombre,usr_passwd,fecha_registro,registrado_por) values (NULL,"+usuario.getIdPersona()+",'"+usuario.getNomUsuario()+"',md5('"+usuario.getNomClave()+"'), "
                + "'"+usuario.getFechaRegistro()+"',"+usuario.getRegistradoPor()+")";
        System.out.println("El query es--> "+sql);
        try{
            instruccion.executeUpdate(sql);
            insertado = 1;
        }catch(SQLException ex){
            System.out.println("Error al insertar el usuario-->"+ex.getMessage());
            insertado = -1;
        }
        return insertado;        
    }
    
    
    
    protected void finalize(){
        try{
            instruccion.close();
            conexion.close();
        }
        catch(SQLException excepcionSQL){
            excepcionSQL.printStackTrace();
        }
    }   
    
}
