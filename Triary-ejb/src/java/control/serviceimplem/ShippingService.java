/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.serviceimplem;

import control.IShippingService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Shipping;

/**
 *
 * @author kate
 */
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
    public List<Shipping> getAll() {
        return (List<Shipping>) em.createNamedQuery("Shipping.findAll").getResultList();
    }
    
}

