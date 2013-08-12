/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.mbeans;

import control.serviceimplem.DiaryService;
import control.serviceimplem.SetsService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import model.Diary;
import model.Sets;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author kate
 */
@ManagedBean(name = "diarylMB")
@ViewScoped
public class DiaryManagedBean {

    private Diary curDiary = new Diary();
    private Sets curSets = new Sets();
    @EJB
    private SetsService setsService;
    @EJB
    private DiaryService diaryService;
    private List<Diary> lstDiary;
    private List<Sets> lstSets;
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
    private Map<String, String> muscle_grs;
    
    private boolean attempt2;
    private boolean attempt3;
    private boolean attempt4;
    private boolean attempt5;
    private boolean attempt6;
    private boolean attempt7;
    
    private String cnt_att1;
    private String cnt_att2;
    private String cnt_att3;
    private String cnt_att4;
    private String cnt_att5;
    private String cnt_att6;
    private String cnt_att7;
    
    private String w_at1;
    private String w_at2;
    private String w_at3;
    private String w_at4;
    private String w_at5;
    private String w_at6;
    private String w_at7;

    public static String newline = System.getProperty("line.separator");
    
    private List<Sets> sets_list = new ArrayList<Sets>();
    
    private String set_id;
    
    public DiaryManagedBean() {
        muscle_grs = new HashMap<String, String>();
        muscle_grs.put("Neck", "Neck");
        muscle_grs.put("Back", "Back");
        muscle_grs.put("Arms", "Arms");
        muscle_grs.put("Pres", "Pres");
        muscle_grs.put("Legs", "Legs");
        muscle_grs.put("Chest", "Chest");
    }
    
    /**
     * @return the lstSets
     */
    public List<Sets> getLstSets(Diary diary) {
        
        lstSets = setsService.getById(diary);
        return lstSets;
    }

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
        if (lstDiary == null){
            lstDiary = (List<Diary>) diaryService.getAll(usrMB.getCurrentUser());
        }
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
        String atts = "1. "+ cnt_att1+"/"+w_at1+";" + "&#10;";
        sets_list.add(new Sets(w_at1, cnt_att1));
        if (null != cnt_att2 && null != w_at2){
            atts = atts + "2. "+cnt_att2+"/"+w_at2+";"+ "&#10;";
            sets_list.add(new Sets(w_at2, cnt_att2));
        }
        if (null != cnt_att3 && null != w_at3){
            atts = atts + "3. "+cnt_att3+"/"+w_at3+";"+ "&#10;";
            sets_list.add(new Sets(w_at3, cnt_att3));
        }
        if (null != cnt_att4 && null != w_at4){
            atts = atts + "4. "+cnt_att4+"/"+w_at4+";"+ "&#10;";
            sets_list.add(new Sets(w_at4, cnt_att4));
        }
        if (null != cnt_att5 && null !=w_at5){
            atts = atts + "5. "+cnt_att5+"/"+w_at5+";"+ "&#10;";
            sets_list.add(new Sets(w_at5, cnt_att5));
        }
        if (null != cnt_att6 && null !=w_at6){
            atts = atts + "6. "+cnt_att6+"/"+w_at6+";"+ "&#10;";
            sets_list.add(new Sets(w_at6, cnt_att6));
        }
        if (null != cnt_att7 && null !=w_at7){
            atts = atts + "7. "+cnt_att7+"/"+w_at7+";"+ "&#10;";
            sets_list.add(new Sets(w_at7, cnt_att7));
        }
        
        
        
        curDiary.setMuscleGroup(selectedItemMuscleGr);
        curDiary.setTrainingType(selectedItemType);
        curDiary.setTasks(selectedItemTasks);
        curDiary.setOwner(usrMB.getCurrentUser());
        curDiary.setAttempts(atts);
        diaryService.create(curDiary);
        
        for (Sets set:sets_list){
            set.setI_set(curDiary);
            setsService.create(set);
        }
//        try {
        //FacesContext.getCurrentInstance().getExternalContext().redirect(".");
        FacesContext context = FacesContext.getCurrentInstance();
        String viewId = context.getViewRoot().getViewId();
        ViewHandler handler = context.getApplication().getViewHandler();
        UIViewRoot root = handler.createView(context, viewId);
        root.setViewId(viewId);
        context.setViewRoot(root);
        try {
            context.getExternalContext().redirect("newdiary.xhtml?id_user="+usrMB.getCurrentUser().returnUserID());
        } catch (IOException ex) {
            Logger.getLogger(DiaryManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void editRecord(RowEditEvent event){
        Diary updated_diary = (Diary) event.getObject();
        
        List<Sets> updated_sets = updated_diary.getSetsList();
        for (Sets updated_set:updated_sets){
            setsService.edit(updated_set);
        }
        diaryService.edit(updated_diary);
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

    /**
     * @return the muscle_grs
     */
    public Map<String, String> getMuscle_grs() {
        return muscle_grs;
    }

    /**
     * @param muscle_grs the muscle_grs to set
     */
    public void setMuscle_grs(Map<String, String> muscle_grs) {
        this.muscle_grs = muscle_grs;
    }

    /**
     * @return the attempt2
     */
    public boolean isAttempt2() {
        return attempt2;
    }

    /**
     * @param attempt2 the attempt2 to set
     */
    public void setAttempt2(boolean attempt2) {
        this.attempt2 = attempt2;
    }

    /**
     * @return the attempt3
     */
    public boolean isAttempt3() {
        return attempt3;
    }

    /**
     * @param attempt3 the attempt3 to set
     */
    public void setAttempt3(boolean attempt3) {
        this.attempt3 = attempt3;
    }

    /**
     * @return the attempt4
     */
    public boolean isAttempt4() {
        return attempt4;
    }

    /**
     * @param attempt4 the attempt4 to set
     */
    public void setAttempt4(boolean attempt4) {
        this.attempt4 = attempt4;
    }

    /**
     * @return the attempt5
     */
    public boolean isAttempt5() {
        return attempt5;
    }

    /**
     * @param attempt5 the attempt5 to set
     */
    public void setAttempt5(boolean attempt5) {
        this.attempt5 = attempt5;
    }

    /**
     * @return the attempt6
     */
    public boolean isAttempt6() {
        return attempt6;
    }

    /**
     * @param attempt6 the attempt6 to set
     */
    public void setAttempt6(boolean attempt6) {
        this.attempt6 = attempt6;
    }

    /**
     * @return the attempt7
     */
    public boolean isAttempt7() {
        return attempt7;
    }

    /**
     * @param attempt7 the attempt7 to set
     */
    public void setAttempt7(boolean attempt7) {
        this.attempt7 = attempt7;
    }
    
    public void setAttempt2Visible(){
        attempt2 =true;
    }
    
    public void setAttempt3Visible(){
        attempt3 =true;
    }
    
    public void setAttempt4Visible(){
        attempt4 =true;
    }
    
    public void setAttempt5Visible(){
        attempt5 =true;
    }
    
    public void setAttempt6Visible(){
        attempt6 =true;
    }
    
    public void setAttempt7Visible(){
        attempt7 =true;
    }

    /**
     * @return the cnt_att1
     */
    public String getCnt_att1() {
        return cnt_att1;
    }

    /**
     * @param cnt_att1 the cnt_att1 to set
     */
    public void setCnt_att1(String cnt_att1) {
        this.cnt_att1 = cnt_att1;
    }

    /**
     * @return the cnt_att2
     */
    public String getCnt_att2() {
        return cnt_att2;
    }

    /**
     * @param cnt_att2 the cnt_att2 to set
     */
    public void setCnt_att2(String cnt_att2) {
        this.cnt_att2 = cnt_att2;
    }

    /**
     * @return the cnt_att3
     */
    public String getCnt_att3() {
        return cnt_att3;
    }

    /**
     * @param cnt_att3 the cnt_att3 to set
     */
    public void setCnt_att3(String cnt_att3) {
        this.cnt_att3 = cnt_att3;
    }

    /**
     * @return the cnt_att4
     */
    public String getCnt_att4() {
        return cnt_att4;
    }

    /**
     * @param cnt_att4 the cnt_att4 to set
     */
    public void setCnt_att4(String cnt_att4) {
        this.cnt_att4 = cnt_att4;
    }

    /**
     * @return the cnt_att5
     */
    public String getCnt_att5() {
        return cnt_att5;
    }

    /**
     * @param cnt_att5 the cnt_att5 to set
     */
    public void setCnt_att5(String cnt_att5) {
        this.cnt_att5 = cnt_att5;
    }

    /**
     * @return the cnt_att6
     */
    public String getCnt_att6() {
        return cnt_att6;
    }

    /**
     * @param cnt_att6 the cnt_att6 to set
     */
    public void setCnt_att6(String cnt_att6) {
        this.cnt_att6 = cnt_att6;
    }

    /**
     * @return the cnt_att7
     */
    public String getCnt_att7() {
        return cnt_att7;
    }

    /**
     * @param cnt_att7 the cnt_att7 to set
     */
    public void setCnt_att7(String cnt_att7) {
        this.cnt_att7 = cnt_att7;
    }

    /**
     * @return the w_at1
     */
    public String getW_at1() {
        return w_at1;
    }

    /**
     * @param w_at1 the w_at1 to set
     */
    public void setW_at1(String w_at1) {
        this.w_at1 = w_at1;
    }

    /**
     * @return the w_at2
     */
    public String getW_at2() {
        return w_at2;
    }

    /**
     * @param w_at2 the w_at2 to set
     */
    public void setW_at2(String w_at2) {
        this.w_at2 = w_at2;
    }

    /**
     * @return the w_at3
     */
    public String getW_at3() {
        return w_at3;
    }

    /**
     * @param w_at3 the w_at3 to set
     */
    public void setW_at3(String w_at3) {
        this.w_at3 = w_at3;
    }

    /**
     * @return the w_at4
     */
    public String getW_at4() {
        return w_at4;
    }

    /**
     * @param w_at4 the w_at4 to set
     */
    public void setW_at4(String w_at4) {
        this.w_at4 = w_at4;
    }

    /**
     * @return the w_at5
     */
    public String getW_at5() {
        return w_at5;
    }

    /**
     * @param w_at5 the w_at5 to set
     */
    public void setW_at5(String w_at5) {
        this.w_at5 = w_at5;
    }

    /**
     * @return the w_at6
     */
    public String getW_at6() {
        return w_at6;
    }

    /**
     * @param w_at6 the w_at6 to set
     */
    public void setW_at6(String w_at6) {
        this.w_at6 = w_at6;
    }

    /**
     * @return the w_at7
     */
    public String getW_at7() {
        return w_at7;
    }

    /**
     * @param w_at7 the w_at7 to set
     */
    public void setW_at7(String w_at7) {
        this.w_at7 = w_at7;
    }

    /**
     * @return the set_id
     */
    public String getSet_id() {
        return set_id;
    }

    /**
     * @param set_id the set_id to set
     */
    public void setSet_id(String set_id) {
        this.set_id = set_id;
    }

    
}
