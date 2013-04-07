/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.serviceimplem;

import control.ICartService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Cart;

/**
 *
 * @author kate
 */
public class CartService extends Generic<Cart> implements ICartService {

    @PersistenceContext(unitName = "Triary-ejbPU")
    private EntityManager em;

    public CartService() {
        super(Cart.class);
    }
    
    public void persist(Object object) {
        em.persist(object);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Cart> getAll() {
        return (List<Cart>) em.createNamedQuery("Cart.findAll").getResultList();
    }
    
}
