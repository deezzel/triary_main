/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.serviceimplem;

import control.IOldDimensionsService;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.OldDimensions;
import model.Users;


/**
 *
 * @author kate
 */
@Stateless
@LocalBean
public class OldDimensionsService extends Generic<OldDimensions> implements IOldDimensionsService {

    @PersistenceContext(unitName = "Triary-ejbPU")
    private EntityManager em;
    
    public OldDimensionsService() {
        super(OldDimensions.class);
    }
    
    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public List<String> getListWeight(Integer user) {
        return (List<String>) em.createNamedQuery("OldDimensions.getListWeight").setParameter("owner", user).getResultList();
    }

    @Override
    public List<String> getListDate(Integer user) {
        return (List<String>) em.createNamedQuery("OldDimensions.getListDate").setParameter("owner", user).getResultList();
    }

    @Override
    public List<String> getListWaist(Integer user) {
        return (List<String>) em.createNamedQuery("OldDimensions.getListWaist").setParameter("owner", user).getResultList();
    }

    @Override
    public List<String> getListChest(Integer user) {
        return (List<String>) em.createNamedQuery("OldDimensions.getListChest").setParameter("owner", user).getResultList();
    }

    @Override
    public List<String> getListBiceps(Integer user) {
        return (List<String>) em.createNamedQuery("OldDimensions.getListBiceps").setParameter("owner", user).getResultList();
    }

    @Override
    public List<String> getListForearm(Integer user) {
        return (List<String>) em.createNamedQuery("OldDimensions.getListForearm").setParameter("owner", user).getResultList();
    }

    @Override
    public List<String> getListWrist(Integer user) {
        return (List<String>) em.createNamedQuery("OldDimensions.getListWrist").setParameter("owner", user).getResultList();
    }

    @Override
    public List<String> getListNeck(Integer user) {
        return (List<String>) em.createNamedQuery("OldDimensions.getListNeck").setParameter("owner", user).getResultList();
    }

    @Override
    public List<String> getListThigh(Integer user) {
        return (List<String>) em.createNamedQuery("OldDimensions.getListThigh").setParameter("owner", user).getResultList();
    }

    @Override
    public List<String> getListButt(Integer user) {
        return (List<String>) em.createNamedQuery("OldDimensions.getListButt").setParameter("owner", user).getResultList();
    }

    @Override
    public List<String> getListShin(Integer user) {
        return (List<String>) em.createNamedQuery("OldDimensions.getListShin").setParameter("owner", user).getResultList();
    }

    @Override
    public List<OldDimensions> getAll(Users user) {
        return (List<OldDimensions>) em.createNamedQuery("OldDimensions.getAll").setParameter("owner", user).getResultList();
    }

    
}
