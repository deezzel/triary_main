/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.serviceimplem;

import control.IOrdersService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Orders;

/**
 *
 * @author kate
 */
public class OrdersService extends Generic<Orders> implements IOrdersService {

    @PersistenceContext(unitName = "Triary-ejbPU")
    private EntityManager em;

    public OrdersService() {
        super(Orders.class);
    }
    
    public void persist(Object object) {
        em.persist(object);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Orders> getAll() {
        return (List<Orders>) em.createNamedQuery("Orders.findAll").getResultList();
    }
    
}

