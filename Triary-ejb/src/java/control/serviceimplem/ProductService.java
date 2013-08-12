/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.serviceimplem;

import control.IProductService;
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
public class ProductService extends Generic<Product> implements IProductService {

    @PersistenceContext(unitName = "Triary-ejbPU")
    private EntityManager em;

    public ProductService() {
        super(Product.class);
    }
    
    public void persist(Object object) {
        em.persist(object);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Product> getAll() {
        return (List<Product>) em.createNamedQuery("Product.findAll").getResultList();
    }

    @Override
    public byte[] getImage(Integer product_id) {
        return (byte[]) em.createNamedQuery("Product.getImage").setParameter("product_id", product_id).getSingleResult();
    }
    
    @Override
    public List<Product> getFromCart(Users usr){
        return (List<Product>) em.createNamedQuery("Product.getFromCart").setParameter("user_id", usr).getResultList();
    }

    @Override
    public void decreaseAmount(Product product, Integer amount){
        Integer cnt = product.getCount();
        cnt = cnt - amount;
        product.setCount(cnt);
        edit(product);
    }
    
    @Override
    public void increaseAmount(Product product, Integer amount){
        Integer cnt = product.getCount();
        cnt = cnt + amount;
        product.setCount(cnt);
        edit(product);
    }
}
