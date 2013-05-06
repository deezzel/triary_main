/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.mbeans;

import control.serviceimplem.PublicationService;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Publication;
import model.Users;

/**
 *
 * @author kate
 */

@ManagedBean(name = "publMB")

public class PublicationsManagedBean {
    private Users currentUser;
    private String login;
    private String password;
    private int role;
    private List<Publication> lstNews;
    private List<Publication> lstTrMethods;
    private List<Publication> lstDiets;
    private List<Publication> lstTopNews;
    private List<Publication> lstTopTrMethods;
    private List<Publication> lstTopDiets;
    @EJB
    private PublicationService PublicationService;
    @ManagedProperty(value = "#{userManagedBean}")
    private UserManagedBean usrMB;
    private Publication pub;
    private String id_pub;
    private Publication currentPubl;
    
    /**
     *
     */
    public PublicationsManagedBean() {
    }
    
    public List<Publication> getLstNews() {
        setLstPublication();
        return lstNews;
    }
    
    public void setLstPublication() {
       lstNews = (List<Publication>) PublicationService.getByType("NEWS");
    }
    
    public List<Publication> getLstTrainingMethods() {
        setLstTrainingMethods();
        return lstTrMethods;
    }
    
    public void setLstTrainingMethods() {
       lstTrMethods = (List<Publication>) PublicationService.getByType("TRAININGMETHOD");
    }
    
    public List<Publication> getLstDiets() {
        setLstDiets();
        return lstDiets;
    }
    
    public void setLstDiets() {
       lstDiets = (List<Publication>) PublicationService.getByType("DIET");
    }
    
    public void setLstTopNews(){
        lstTopNews = (List<Publication>) PublicationService.getTopPubls("NEWS");
    }
    
    public List<Publication> getLstTopNews(){
        setLstTopNews();
        return lstTopNews;
    }
    
    public void setLstTopTrMethods(){
        lstTopTrMethods = (List<Publication>) PublicationService.getTopPubls("TRAININGMETHOD");
    }
    
    public List<Publication> getLstTopTrMethods(){
        setLstTopTrMethods();
        return lstTopTrMethods;
    }
    
    public void setLstTopDiets(){
        lstTopDiets = (List<Publication>) PublicationService.getTopPubls("DIET");
    }
    
    public List<Publication> getLstTopDiets(){
        setLstTopDiets();
        return lstTopDiets;
    }

    /**
     * @return the id_pub
     */
    public String getId_pub() {
        return id_pub;
    }

    /**
     * @param id_pub the id_pub to set
     */
    public void setId_pub(String id_pub) {
        this.id_pub = id_pub;
    }

    /**
     * @return the usrMB
     */
    public UserManagedBean getUsrMB() {
        return usrMB;
    }

    /**
     * @param usrMB the usrMB to set
     */
    public void setUsrMB(UserManagedBean usrMB) {
        this.usrMB = usrMB;
    }
    
    public void delNews() {
        System.out.print(id_pub);
        Integer id = new Integer(id_pub);
        currentPubl = PublicationService.find(Integer.valueOf(id));
        PublicationService.remove(currentPubl);
        
    }
    public boolean isAdmin() {
        if (usrMB.getCurrentUser() != null) {
            if (usrMB.getCurrentUser().getRoleuser().equals("admin")) {
                return true;
            }
        }
        return false;
    }
    
        public void incVisits(){
//        Integer visits = currentPubl.getVisits();
//        visits++;
//        PublicationService.edit(currentPubl);
        
        try {   FacesContext.getCurrentInstance().getExternalContext().redirect("newpublications.xhtml");
               
            } catch (IOException ex) {
               Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
