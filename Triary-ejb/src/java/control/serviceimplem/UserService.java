/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.serviceimplem;


import control.IUserService;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Publication;
import model.Users;

/**
 *
 * @author kate
 */
@LocalBean
@Stateless(name="UserService")
public class UserService extends Generic<Users> implements IUserService{

    @PersistenceContext(unitName = "Triary-ejbPU")
    private EntityManager em;

    public UserService() {
        super(Users.class);
    }
    
    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public Users getByUser(Integer usr_id) {
       return (Users) em.createNamedQuery("Users.findById").setParameter("id_user", usr_id).getSingleResult();
    }

    @Override
    public List<Users> findByName(String name) {
        return (List<Users>) em.createNamedQuery("Users.getByName").setParameter("name", name).getResultList();
    }

    @Override
    public boolean login(String login, String passwd) {
        if (null != getByLogin(login)) {
            if (getByLogin(login).getPassword().equals(passwd)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Users getByLogin(String login) {
        return (Users) em.createNamedQuery("Users.getByLogin").setParameter("login", login).getSingleResult();
    }

    @Override
    public boolean registration(Users user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

  

   
    
}
