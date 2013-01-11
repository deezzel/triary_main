/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.mbeans;

import control.serviceimplem.ProfileService;
import control.serviceimplem.UserService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletRequest;
import model.Profile;
import model.Users;

/**
 *
 * @author kate
 */
@ManagedBean(name = "profileMB")
@SessionScoped
public class ProfileManagedBean implements Serializable{

    private final static String[] params;
    static {
        params = new String[11];
        params[0] = "Рост";
        params[1] = "Вес";
        params[2] = "Талия";
        params[3] = "Бицепс";
        params[4] = "Грудь";
        params[5] = "Предплечье";
        params[6] = "Запястье";
        params[7] = "Шея";
        params[8] = "Бедро";
        params[9] = "Ягодицы";
        params[10] = "Голень";
    }
    
    
    private Users curuser;
    private Profile curprofile;
    @EJB
    private UserService userService;
    @EJB
    private ProfileService profileService;
    
    private List<String> lstParams;

    public ProfileManagedBean() {
        
    }

    /**
     * @return the curuser
     */
    public Users getCuruser() {
        return curuser;
    }

    /**
     * @param curuser the curuser to set
     */
    public void setCuruser(Users curuser) {
        this.curuser = curuser;
    }

    /**
     * @return the curprofile
     */
    public Profile getCurprofile() {
        return curprofile;
    }

    /**
     * @param curprofile the curprofile to set
     */
    public void setCurprofile(Profile curprofile) {
        this.curprofile = curprofile;
    }

    /**
     * @return the userService
     */
    public UserService getUserService() {
        return userService;
    }

    /**
     * @param userService the userService to set
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * @return the profileService
     */
    public ProfileService getProfileService() {
        return profileService;
    }

    /**
     * @param profileService the profileService to set
     */
    public void setProfileService(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostConstruct
    public void init() {
        String id_prof = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("id_user");
        Integer id = new Integer(id_prof);
        try {
            
            curprofile = (Profile) profileService.find(new Integer(id));
            System.out.println(((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getQueryString());
//            System.out.print(updatePubl.getText());

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void updateProfile() {
        profileService.edit(curprofile);
    }

    /**
     * @return the lstParams
     */
    public List<String> getLstParams() {
        return lstParams;
    }

    /**
     * @param lstParams the lstParams to set
     */
    public void setLstParams(List<String> lstParams) {
        this.lstParams = lstParams;
    }
    
    public List<String> fillLstParams(){
        lstParams.add("Рост");
        lstParams.add("Вес");
        lstParams.add("Бицепс");
        setLstParams(lstParams);
        return lstParams;
    }
    
    public boolean isDiaryEnabled(){
        if (curprofile.getDiaryEnabled()){
            return true;
        }
        return false;
    }
}
