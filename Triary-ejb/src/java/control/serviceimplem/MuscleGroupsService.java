/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.serviceimplem;

import control.IMuscleGroupsService;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.MuscleGroups;

/**
 *
 * @author Artem Mihelson <artem.mihelson@gmail.com>
 */
@LocalBean
@Stateless
public class MuscleGroupsService extends Generic<MuscleGroups> implements IMuscleGroupsService{
    
    @PersistenceContext(unitName = "Triary-ejbPU")
    private EntityManager em;
    
    public void persist(Object object) {
        em.persist(object);
    }

    public MuscleGroupsService() {
        super(MuscleGroups.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<MuscleGroups> getAll() {
        return (List<MuscleGroups>) em.createNamedQuery("MuscleGroups.findAll").getResultList();
    }

    @Override
    public List<String> getMuscleGroupsNames() {
        return (List<String>) em.createNamedQuery("MuscleGroups.getNames").getResultList();
    }
    
}
