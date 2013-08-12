/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.serviceimplem;

import control.IOrdersService;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Orders;
import model.Users;

/**
 *
 * @author kate
 */
@LocalBean
@Stateless
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
    
    @Override
    public List<Orders> getConsideringOrders(Users usr){
        return (List<Orders>) em.createNamedQuery("Orders.getConsideringOrders").setParameter("user_id", usr).getResultList();
    }
    
    @Override
    public List<Orders> getDeliveringOrders(Users usr){
        return (List<Orders>) em.createNamedQuery("Orders.getDeliveringOrders").setParameter("user_id", usr).getResultList();
    }
    
    @Override
    public List<Orders> getDeliveredOrders(Users usr){
        return (List<Orders>) em.createNamedQuery("Orders.getDeliveredOrders").setParameter("user_id", usr).getResultList();
    }
}
