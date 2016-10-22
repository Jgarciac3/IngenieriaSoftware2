/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package siga.persistence.facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import siga.persistence.entities.Municipios;

/**
 *
 * @author Carlos Fernando
 */
@Stateless
public class MunicipiosFacade extends AbstractFacade<Municipios> {
    @PersistenceContext(unitName = "SIGAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MunicipiosFacade() {
        super(Municipios.class);
    }
    
    public List<Municipios> obtenerMunicipios(String idDepartamento){
        List<Municipios> listaMunicipios = null;
        try{
            Query query = getEntityManager().createQuery("select m from Municipios m inner join m.departamentos d where d.iddepartamentos = :dept order by m.nombreMunicipio");
            query.setParameter("dept", idDepartamento);
            listaMunicipios = query.getResultList();
            if(listaMunicipios.isEmpty()){
                System.out.println("La lista de municipios esta vacia");
            }
        }
        catch(Exception e){
            System.out.println("Error "+e.getMessage());
        }
        return listaMunicipios;       
    }
    
}
