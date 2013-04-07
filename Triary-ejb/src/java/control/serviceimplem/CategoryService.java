/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.serviceimplem;

import control.ICategoryService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Category;

/**
 *
 * @author kate
 */
public class CategoryService extends Generic<Category> implements ICategoryService {

    @PersistenceContext(unitName = "Triary-ejbPU")
    private EntityManager em;

    public CategoryService() {
        super(Category.class);
    }
    
    public void persist(Object object) {
        em.persist(object);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Category> getAll() {
        return (List<Category>) em.createNamedQuery("Category.findAll").getResultList();
    }
    
}
