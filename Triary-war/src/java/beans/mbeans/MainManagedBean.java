/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.mbeans;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author kate
 */
@ManagedBean (name="mainMB")
@SessionScoped
public class MainManagedBean {
    
    private String url;
    
    public void MainManagedBean(){}

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getCurrentPage(){
        url = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRequestURI();
        if (url.contains("newinndex.xhtml")){
            return "index";
        } else
        if (url.contains("newpublications.xhtml")){
            return "news";
        } else
            if (url.contains("newtrmethods.xhtml")){
                return "trmethods";
            } else
                if (url.contains("newdiets.xhtml")){
                    return "diets";
                } else
                    if (url.contains("newprofile.xhtml")){
                        return "profile";
                    } else
                        return "market";
        
    }
    
    public void addWarn(ActionEvent actionEvent) {  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Warning", "Please log in to the system in order to view you profile"));
        return;
    }  
    
}
