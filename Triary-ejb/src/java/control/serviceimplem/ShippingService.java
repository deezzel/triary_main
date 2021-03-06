/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.serviceimplem;

import control.IShippingService;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Shipping;

/**
 *
 * @author kate
 */
@LocalBean
@Stateless
public class ShippingService extends Generic<Shipping> implements IShippingService {

    @PersistenceContext(unitName = "Triary-ejbPU")
    private EntityManager em;

    public ShippingService() {
        super(Shipping.class);
    }
    
    public void persist(Object object) {
        em.persist(object);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<String> getAll() {
        return (List<String>) em.createNamedQuery("Shipping.findAll").getResultList();
    }
    
    @Override
    public Shipping getByName(String name) {
        return (Shipping) em.createNamedQuery("Shipping.findByName").setParameter("name", name).getSingleResult();
    }
}

