/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.mbeans;

import control.serviceimplem.OldDimensionsService;
import control.serviceimplem.ProfileService;
import control.serviceimplem.StatisticsService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import model.OldDimensions;
import model.Profile;
import model.Statistics;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author kate
 */
@ManagedBean(name = "statMB")
@SessionScoped
public class StatisticsManagedBean implements Serializable {

    private Statistics curstat;
    @EJB
    private StatisticsService statService;
    @EJB
    private ProfileService profService;
    @EJB
    private OldDimensionsService oldDimensService;
    @ManagedProperty(value = "#{userManagedBean}")
    private UserManagedBean usrMB;
    private List<String> weightList;
    private List<String> dateList;
    private List<OldDimensions> lstAll;
    private CartesianChartModel categoryModel;

    public StatisticsManagedBean() {
        //       formWeightList();
    }

    /**
     * @return the curstat
     */
    public Statistics getCurstat() {
        return curstat;
    }

    /**
     * @param curstat the curstat to set
     */
    public void setCurstat(Statistics curstat) {
        this.curstat = curstat;
    }

    /**
     * @return the categoryModel
     */
    public CartesianChartModel getCategoryModel() {
        return categoryModel;
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

    public CartesianChartModel getAll() {
        setAll();

        List<String> lstweight = new ArrayList<String>();
        for (Iterator<OldDimensions> it = lstAll.iterator(); it.hasNext();) {
            OldDimensions obj = it.next();
            lstweight.add(obj.getOld_weight());
        }
        
        List<String> lstbiceps = new ArrayList<String>();
        for (Iterator<OldDimensions> it = lstAll.iterator(); it.hasNext();) {
            OldDimensions obj = it.next();
            lstbiceps.add(obj.getOld_biceps_dimension());
        }

        List<String> lstdate = new ArrayList<String>();
        for (Iterator<OldDimensions> it = lstAll.iterator(); it.hasNext();) {
            OldDimensions obj = it.next();
            int day = obj.getOld_date().getDate();
            int month = obj.getOld_date().getMonth();
            int year = obj.getOld_date().getYear() + 1900;
            lstdate.add(String.valueOf(day) + "-" + String.valueOf(month) + "-" + String.valueOf(year));
        }
        
        List<String> lstbutt = new ArrayList<String>();
        for (Iterator<OldDimensions> it = lstAll.iterator(); it.hasNext();) {
            OldDimensions obj = it.next();
            lstbutt.add(obj.getOld_butt_dimension());
        }
        
        List<String> lstchest = new ArrayList<String>();
        for (Iterator<OldDimensions> it = lstAll.iterator(); it.hasNext();) {
            OldDimensions obj = it.next();
            lstchest.add(obj.getOld_chest_dimension());
        }
        
        List<String> lstforearm = new ArrayList<String>();
        for (Iterator<OldDimensions> it = lstAll.iterator(); it.hasNext();) {
            OldDimensions obj = it.next();
            lstforearm.add(obj.getOld_forearm_dimension());
        }
        
        List<String> lstneck = new ArrayList<String>();
        for (Iterator<OldDimensions> it = lstAll.iterator(); it.hasNext();) {
            OldDimensions obj = it.next();
            lstneck.add(obj.getOld_neck_dimension());
        }
        
        List<String> lstshin = new ArrayList<String>();
        for (Iterator<OldDimensions> it = lstAll.iterator(); it.hasNext();) {
            OldDimensions obj = it.next();
            lstshin.add(obj.getOld_shin_dimension());
        }
        
        List<String> lstthigh = new ArrayList<String>();
        for (Iterator<OldDimensions> it = lstAll.iterator(); it.hasNext();) {
            OldDimensions obj = it.next();
            lstthigh.add(obj.getOld_thigh_dimension());
        }
        
        List<String> lstwaist = new ArrayList<String>();
        for (Iterator<OldDimensions> it = lstAll.iterator(); it.hasNext();) {
            OldDimensions obj = it.next();
            lstwaist.add(obj.getOld_waist_dimension());
        }
        
        List<String> lstwrist = new ArrayList<String>();
        for (Iterator<OldDimensions> it = lstAll.iterator(); it.hasNext();) {
            OldDimensions obj = it.next();
            lstwrist.add(obj.getOld_wrist_dimension());
        }

        categoryModel = new CartesianChartModel();

        ChartSeries chartWeightStat = new ChartSeries("Weight");
        for (int i = 1; i < lstdate.size();) {
            for (int j = 1; j < lstweight.size(); j++) {
                chartWeightStat.set(lstdate.get(i), Integer.valueOf(lstweight.get(j)));
                i++;
            }
        }
        
        ChartSeries chartBicepsStat = new ChartSeries("Biceps");
        for (int i = 1; i < lstdate.size();) {
            for (int j = 1; j < lstbiceps.size(); j++) {
                chartBicepsStat.set(lstdate.get(i), Integer.valueOf(lstbiceps.get(j)));
                i++;
            }
        }
        
        ChartSeries chartButtStat = new ChartSeries("Butts");
        for (int i = 1; i < lstdate.size();) {
            for (int j = 1; j < lstbutt.size(); j++) {
                chartButtStat.set(lstdate.get(i), Integer.valueOf(lstbutt.get(j)));
                i++;
            }
        }
        
        ChartSeries chartChestStat = new ChartSeries("Chest");
        for (int i = 1; i < lstdate.size();) {
            for (int j = 1; j < lstchest.size(); j++) {
                chartButtStat.set(lstdate.get(i), Integer.valueOf(lstchest.get(j)));
                i++;
            }
        }
        
        ChartSeries chartForearmStat = new ChartSeries("Forearm");
        for (int i = 1; i < lstdate.size();) {
            for (int j = 1; j < lstforearm.size(); j++) {
                chartForearmStat.set(lstdate.get(i), Integer.valueOf(lstforearm.get(j)));
                i++;
            }
        }
        
        ChartSeries chartNeckStat = new ChartSeries("Neck");
        for (int i = 1; i < lstdate.size();) {
            for (int j = 1; j < lstneck.size(); j++) {
                chartForearmStat.set(lstdate.get(i), Integer.valueOf(lstneck.get(j)));
                i++;
            }
        }
        
        ChartSeries chartShinStat = new ChartSeries("Shin");
        for (int i = 1; i < lstdate.size();) {
            for (int j = 1; j < lstshin.size(); j++) {
                chartForearmStat.set(lstdate.get(i), Integer.valueOf(lstshin.get(j)));
                i++;
            }
        }
        
        ChartSeries chartThighStat = new ChartSeries("Hip");
        for (int i = 1; i < lstdate.size();) {
            for (int j = 1; j < lstthigh.size(); j++) {
                chartForearmStat.set(lstdate.get(i), Integer.valueOf(lstthigh.get(j)));
                i++;
            }
        }
        
        ChartSeries chartWaistStat = new ChartSeries("Waist");
        for (int i = 1; i < lstdate.size();) {
            for (int j = 1; j < lstwaist.size(); j++) {
                chartForearmStat.set(lstdate.get(i), Integer.valueOf(lstwaist.get(j)));
                i++;
            }
        }
        
        ChartSeries chartWristStat = new ChartSeries("Wrist");
        for (int i = 1; i < lstdate.size();) {
            for (int j = 1; j < lstwrist.size(); j++) {
                chartForearmStat.set(lstdate.get(i), Integer.valueOf(lstwrist.get(j)));
                i++;
            }
        }
        
        categoryModel.addSeries(chartBicepsStat);
        categoryModel.addSeries(chartWeightStat);
        categoryModel.addSeries(chartButtStat);
        categoryModel.addSeries(chartChestStat);
        categoryModel.addSeries(chartForearmStat);
        categoryModel.addSeries(chartNeckStat);
        categoryModel.addSeries(chartShinStat);
        categoryModel.addSeries(chartThighStat);
        categoryModel.addSeries(chartWaistStat);
        categoryModel.addSeries(chartWristStat);
        return categoryModel;
    }

    public void setAll() {
        lstAll = (List<OldDimensions>) oldDimensService.getAll(getUsrMB().getCurrentUser());
    }

    /**
     * @return the weightList
     */
    public List<String> getWeightList() {
        return weightList;
    }

    /**
     * @param weightList the weightList to set
     */
    public void setWeightList(List<String> weightList) {
        this.weightList = weightList;
    }

    /**
     * @return the dateList
     */
    public List<String> getDateList() {
        return dateList;
    }

    /**
     * @param dateList the dateList to set
     */
    public void setDateList(List<String> dateList) {
        this.dateList = dateList;
    }
    
    @PostConstruct
    public void init() {
        String id_stat = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("id_user");
        Integer id = new Integer(id_stat);
        try {
            curstat = (Statistics) statService.find(new Integer(id));
            System.out.println(((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getQueryString());
//            System.out.print(updatePubl.getText());

        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
