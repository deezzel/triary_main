/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.mbeans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import model.OldDimensions;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author kate
 */
@ManagedBean(name = "graphMB")
@SessionScoped
public class GraphManagedBean {
//    @ManagedProperty (value="#{statMB}")
//    private StatisticsManagedBean statMB;

    private CartesianChartModel categoryModel;
    private String[] listX;

    public GraphManagedBean() {
        createChart();
    }

    /**
     * @return the categoryModel
     */
    public CartesianChartModel getCategoryModel() {
        return categoryModel;
    }

    private void createChart() {
        List<String> where = new ArrayList<String>();
        where.add("2011");
        where.add("2012");

//        for (OldDimensions obj: lstAll){
//            listX.add(obj.getOld_weight());
//        }

        categoryModel = new CartesianChartModel();

        ChartSeries chartWeightStat = new ChartSeries("Weight/Date Statistics");
        chartWeightStat.set("2004", 75);
        chartWeightStat.set("2005", 80);
        chartWeightStat.set(where.get(0), 88);
        chartWeightStat.set(where.get(1), 99);
        categoryModel.addSeries(chartWeightStat);
    }

    /**
     * @return the listX
     */
    public String[] getListX() {
        return listX;
    }

    /**
     * @param listX the listX to set
     */
    public void setListX(String[] listX) {
        this.listX = listX;
    }
}
