/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.serviceimplem;

import control.IExercisesService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Exercises;

/**
 *
 * @author Artem Mihelson <artem.mihelson@gmail.com>
 */
public class ExercisesService extends Generic<Exercises> implements IExercisesService {

    @PersistenceContext(unitName = "Triary-ejbPU")
    private EntityManager em;
    
    public void persist(Object object) {
        em.persist(object);
    }

    public ExercisesService() {
        super(Exercises.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Exercises> getAll() {
        return (List<Exercises>) em.createNamedQuery("Exercises.findAll").getResultList();
    }

    @Override
    public List<String> getExercisesNames() {
        return (List<String>) em.createNamedQuery("Exercises.getNames").getResultList();
    }
    
}
