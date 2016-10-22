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
import siga.persistence.entities.TipoDocumento;

/**
 *
 * @author Carlos Fernando
 */
@Stateless
public class TipoDocumentoFacade extends AbstractFacade<TipoDocumento> {
    @PersistenceContext(unitName = "SIGAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoDocumentoFacade() {
        super(TipoDocumento.class);
    }
    
    public List<TipoDocumento> listaDocumentos(){
        List<TipoDocumento> listadoDocumento = null;
        try{
            Query query = getEntityManager().createQuery("select t from TipoDocumento t where t.idTipDoc <> 4");
            listadoDocumento = query.getResultList();
        }
        catch(Exception e){
            System.out.println("Un error ha ocurrido"+e.getMessage());
        }
        return listadoDocumento;
    }
    
}
