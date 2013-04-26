/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.serviceimplem;

import control.ICategoryService;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Category;

/**
 *
 * @author kate
 */
@LocalBean
@Stateless
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

    @Override
    public List<String> getCategoryNames() {
        return (List<String>) em.createNamedQuery("Category.getNames").getResultList();
    }

    @Override
    public Category getByName(String name) {
        return (Category) em.createNamedQuery("Category.getByName").setParameter("name", name).getSingleResult();
    }
    
}
