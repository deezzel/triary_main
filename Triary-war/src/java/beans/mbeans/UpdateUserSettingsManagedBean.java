/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.mbeans;

import control.serviceimplem.UserService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import model.Users;

/**
 *
 * @author kate
 */
@ManagedBean(name = "updatesetmb")
@SessionScoped
public class UpdateUserSettingsManagedBean {

    @EJB
    private UserService userService;
    private Users updateUser;
    @ManagedProperty (value="#{profileMB}")
    private ProfileManagedBean profileMB;

    /**
     * @return the updateUser
     */
    public Users getUpdateUser() {
        return updateUser;
    }

    /**
     * @param updateUser the updateUser to set
     */
    public void setUpdateUser(Users updateUser) {
        this.updateUser = updateUser;
    }

    public void updateSettings() {
        profileMB.updateProfile();
        userService.edit(updateUser);
//        FacesContext context = FacesContext.getCurrentInstance();
//        String viewId = context.getViewRoot().getViewId();
//        ViewHandler handler = context.getApplication().getViewHandler();
//        UIViewRoot root = handler.createView(context, viewId);
//        root.setViewId(viewId);
//        context.setViewRoot(root);
        try {   FacesContext.getCurrentInstance().getExternalContext().redirect("/Triary-war/userprofile.xhtml");
               
            } catch (IOException ex) {
               Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    @PostConstruct
    public void init() {
        String id_prof = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("id_prof");
        Integer id = new Integer(id_prof);
        try {
            updateUser = (Users) userService.find(new Integer(id));
            System.out.println(((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getQueryString());
//            System.out.print(updatePubl.getText());

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    /**
     * @return the profileMB
     */
    public ProfileManagedBean getProfileMB() {
        return profileMB;
    }

    /**
     * @param profileMB the profileMB to set
     */
    public void setProfileMB(ProfileManagedBean profileMB) {
        this.profileMB = profileMB;
    }
}
