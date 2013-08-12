/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.serviceimplem;

import control.ICartService;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;
import model.Cart;
import model.Product;
import model.Users;

/**
 *
 * @author kate
 */
@LocalBean
@Stateless
public class CartService extends Generic<Cart> implements ICartService {

    @PersistenceContext(unitName = "Triary-ejbPU")
    private EntityManager em;
    private Integer sum_total = 0;
    private Integer cnt;
    private Integer price;
    private Integer total;

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

    @Override
    public List<Cart> getByStatusProducts(Users usr, String status) {
        return (List<Cart>) em.createNamedQuery("Cart.getProductsByStatus").setParameter("user_id", usr).setParameter("status", status).getResultList();
    }
    
    @Override
    public boolean addToCart(Product prod, Cart cart, Users usr, Integer count){
        try{
        cart.setCount(count);
        cart.setOwner(usr);
        cart.setImage(prod.getImage());
        cart.setName(prod.getName());
        cart.setPrice(prod.getPrice());
        cart.setShortdesc(prod.getShortdesc());
        cart.setStatus("InCart");
        cart.setProduct_id(prod.getId());
        create(cart);
        
        }catch (ConstraintViolationException e) {
            System.out.print(e.getConstraintViolations());
            return false;
        }    
        return true;
    }
    
    @Override
    public String calculateTotalPrice(List<Cart> products){
        for(Cart element:products){
            setCnt(element.getCount());
            setPrice(Integer.getInteger(element.getPrice()));
            setTotal((Integer) cnt*price);
            setSum_total((Integer) total + sum_total);
        }
        return sum_total.toString();
    }

    /**
     * @param sum_total the sum_total to set
     */
    public void setSum_total(Integer sum_total) {
        this.sum_total = sum_total;
    }

    /**
     * @param cnt the cnt to set
     */
    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Integer total) {
        this.total = total;
    }
}
