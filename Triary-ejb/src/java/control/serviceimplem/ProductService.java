/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.serviceimplem;

import control.IProductService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Product;

/**
 *
 * @author kate
 */
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
    
}
