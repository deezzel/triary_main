/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.serviceimplem;

import control.ISetsService;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Diary;
import model.Sets;

/**
 *
 * @author Artem Mihelson <artem.mihelson@gmail.com>
 */
@LocalBean
@Stateless
public class SetsService extends Generic<Sets> implements ISetsService{

    @PersistenceContext(unitName = "Triary-ejbPU")
    private EntityManager em;
    
    public SetsService(){
        super(Sets.class);
    }
    
    public void persist(Object object) {
        em.persist(object);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Sets> getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Sets> getById(Diary i_set) {
        return (List<Sets>) em.createNamedQuery("Sets.getById").setParameter("diary_id", i_set).getResultList();
    }
    
}
