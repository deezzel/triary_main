/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.mbeans;

import com.jsf.util.JsfUtil;
import control.serviceimplem.DiaryService;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import model.Diary;

/**
 *
 * @author kate
 */
@ManagedBean(name = "diarylMB")
@ViewScoped
public class DiaryManagedBean {

    private Diary curDiary = new Diary();
    @EJB
    private DiaryService diaryService;
    private List<Diary> lstDiary;
    @ManagedProperty(value = "#{userManagedBean}")
    private UserManagedBean usrMB;
    private String selectedItemType;
    private String selectedItemBB;
    private String selectedItemFitnes;
    private String selectedItemPowerLift;
    private String selectedItemMuscleGr;
    private String selectedItemBack;
    private String selectedItemPres;
    private String selectedItemArms;
    private String selectedItemChest;
    private String selectedItemLegs;
    private String selectedItemTasks;
    private String selectedItemBench;
    private String selectedItemPullup;
    private String selectedItemDeadlift;
    private String selectedItemArnold;
    private String selectedItemSquats;
    private String selectedItemSwings;

    /**
     * @return the curDiary
     */
    public Diary getCurDiary() {
        return curDiary;
    }

    /**
     * @param curDiary the curDiary to set
     */
    public void setCurDiary(Diary curDiary) {
        this.curDiary = curDiary;
    }

    /**
     * @return the lstDiary
     */
    public List<Diary> getLstDiary() {
        setLstDiary();
        return lstDiary;
    }

    /**
     * @param lstDiary the lstDiary to set
     */
    public void setLstDiary() {
        lstDiary = (List<Diary>) diaryService.getAll(usrMB.getCurrentUser());
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

    public void addRecord() {
//        selectedItem = this.getSelectedItem();
//        String selectedLabel = items.get(selectedItem);



        curDiary.setMuscleGroup(selectedItemMuscleGr);

        curDiary.setTrainingType(selectedItemType);
        curDiary.setTasks(selectedItemTasks);
        curDiary.setOwner(usrMB.getCurrentUser());
        diaryService.create(curDiary);
//        try {
            //FacesContext.getCurrentInstance().getExternalContext().redirect(".");
            FacesContext context = FacesContext.getCurrentInstance();
            String viewId = context.getViewRoot().getViewId();
            ViewHandler handler = context.getApplication().getViewHandler();
            UIViewRoot root = handler.createView(context, viewId);
            root.setViewId(viewId);
            context.setViewRoot(root);

//        } catch (IOException ex) {
//            Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
//        }


    }

    /**
     * @return the selectedItemType
     */
    public String getSelectedItemType() {
        return selectedItemType;
    }

    /**
     * @param selectedItemType the selectedItemType to set
     */
    public void setSelectedItemType(String selectedItemType) {
        this.selectedItemType = selectedItemType;
    }

    /**
     * @return the selectedItemBB
     */
    public String getSelectedItemBB() {
        return selectedItemBB;
    }

    /**
     * @param selectedItemBB the selectedItemBB to set
     */
    public void setSelectedItemBB(String selectedItemBB) {
        this.selectedItemBB = selectedItemBB;
    }

    /**
     * @return the selectedItemFitnes
     */
    public String getSelectedItemFitnes() {
        return selectedItemFitnes;
    }

    /**
     * @param selectedItemFitnes the selectedItemFitnes to set
     */
    public void setSelectedItemFitnes(String selectedItemFitnes) {
        this.selectedItemFitnes = selectedItemFitnes;
    }

    /**
     * @return the selectedItemPowerLift
     */
    public String getSelectedItemPowerLift() {
        return selectedItemPowerLift;
    }

    /**
     * @param selectedItemPowerLift the selectedItemPowerLift to set
     */
    public void setSelectedItemPowerLift(String selectedItemPowerLift) {
        this.selectedItemPowerLift = selectedItemPowerLift;
    }

    /**
     * @return the selectedItemMuscleGr
     */
    public String getSelectedItemMuscleGr() {
        return selectedItemMuscleGr;
    }

    /**
     * @param selectedItemMuscleGr the selectedItemMuscleGr to set
     */
    public void setSelectedItemMuscleGr(String selectedItemMuscleGr) {
        this.selectedItemMuscleGr = selectedItemMuscleGr;
    }

    /**
     * @return the selectedItemBack
     */
    public String getSelectedItemBack() {
        return selectedItemBack;
    }

    /**
     * @param selectedItemBack the selectedItemBack to set
     */
    public void setSelectedItemBack(String selectedItemBack) {
        this.selectedItemBack = selectedItemBack;
    }

    /**
     * @return the selectedItemPres
     */
    public String getSelectedItemPres() {
        return selectedItemPres;
    }

    /**
     * @param selectedItemPres the selectedItemPres to set
     */
    public void setSelectedItemPres(String selectedItemPres) {
        this.selectedItemPres = selectedItemPres;
    }

    /**
     * @return the selectedItemArms
     */
    public String getSelectedItemArms() {
        return selectedItemArms;
    }

    /**
     * @param selectedItemArms the selectedItemArms to set
     */
    public void setSelectedItemArms(String selectedItemArms) {
        this.selectedItemArms = selectedItemArms;
    }

    /**
     * @return the selectedItemChest
     */
    public String getSelectedItemChest() {
        return selectedItemChest;
    }

    /**
     * @param selectedItemChest the selectedItemChest to set
     */
    public void setSelectedItemChest(String selectedItemChest) {
        this.selectedItemChest = selectedItemChest;
    }

    /**
     * @return the selectedItemLegs
     */
    public String getSelectedItemLegs() {
        return selectedItemLegs;
    }

    /**
     * @param selectedItemLegs the selectedItemLegs to set
     */
    public void setSelectedItemLegs(String selectedItemLegs) {
        this.selectedItemLegs = selectedItemLegs;
    }

    /**
     * @return the selectedItemTasks
     */
    public String getSelectedItemTasks() {
        return selectedItemTasks;
    }

    /**
     * @param selectedItemTasks the selectedItemTasks to set
     */
    public void setSelectedItemTasks(String selectedItemTasks) {
        this.selectedItemTasks = selectedItemTasks;
    }

    /**
     * @return the selectedItemBench
     */
    public String getSelectedItemBench() {
        return selectedItemBench;
    }

    /**
     * @param selectedItemBench the selectedItemBench to set
     */
    public void setSelectedItemBench(String selectedItemBench) {
        this.selectedItemBench = selectedItemBench;
    }

    /**
     * @return the selectedItemPullup
     */
    public String getSelectedItemPullup() {
        return selectedItemPullup;
    }

    /**
     * @param selectedItemPullup the selectedItemPullup to set
     */
    public void setSelectedItemPullup(String selectedItemPullup) {
        this.selectedItemPullup = selectedItemPullup;
    }

    /**
     * @return the selectedItemDeadlift
     */
    public String getSelectedItemDeadlift() {
        return selectedItemDeadlift;
    }

    /**
     * @param selectedItemDeadlift the selectedItemDeadlift to set
     */
    public void setSelectedItemDeadlift(String selectedItemDeadlift) {
        this.selectedItemDeadlift = selectedItemDeadlift;
    }

    /**
     * @return the selectedItemArnold
     */
    public String getSelectedItemArnold() {
        return selectedItemArnold;
    }

    /**
     * @param selectedItemArnold the selectedItemArnold to set
     */
    public void setSelectedItemArnold(String selectedItemArnold) {
        this.selectedItemArnold = selectedItemArnold;
    }

    /**
     * @return the selectedItemSquats
     */
    public String getSelectedItemSquats() {
        return selectedItemSquats;
    }

    /**
     * @param selectedItemSquats the selectedItemSquats to set
     */
    public void setSelectedItemSquats(String selectedItemSquats) {
        this.selectedItemSquats = selectedItemSquats;
    }

    /**
     * @return the selectedItemSwings
     */
    public String getSelectedItemSwings() {
        return selectedItemSwings;
    }

    /**
     * @param selectedItemSwings the selectedItemSwings to set
     */
    public void setSelectedItemSwings(String selectedItemSwings) {
        this.selectedItemSwings = selectedItemSwings;
    }
}
