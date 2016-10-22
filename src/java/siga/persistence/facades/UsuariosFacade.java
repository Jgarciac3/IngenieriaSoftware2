/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package siga.persistence.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import siga.persistence.entities.Usuarios;

/**
 *
 * @author Carlos Fernando
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {
    @PersistenceContext(unitName = "SIGAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    
    public Usuarios obtenerUsuarios(String clave, String usuario){
        Usuarios datosUsuarios = null;
        try{
            Query query = em.createQuery("select u from Usuarios u where u.usrNombre = :usuario and u.usrPasswd = :clave");
            query.setParameter("clave", clave);
            query.setParameter("usuario", usuario);
            datosUsuarios = (Usuarios) query.getSingleResult();
        }
        catch(Exception e){
            System.out.println("Un error ha ocurrido "+e.getMessage());
        }
        return datosUsuarios;
    }
    
}
