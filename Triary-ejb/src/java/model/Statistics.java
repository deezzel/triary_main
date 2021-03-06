/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import model.baseclass.BaseEntity;

/**
 *
 * @author kate
 */
@Entity
@Table(name = "statistics", catalog = "triary", schema = "")

public class Statistics extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Column(name = "title", nullable = true, length = 255)
    private String title;
    @Column(name = "type", nullable = true, length = 1)
    private Integer type;
    
    @JoinColumn(name = "owner", referencedColumnName = "id")
    @ManyToOne
    private Users owner;
    
    public Statistics(){}
    
    private HashMap hm = null;
    
    
    public HashMap addWeightStat(){
        List<String> dates = null;
        List<String> weights = null;
        Profile prof = null;
        dates.add(prof.getDate().toString());
        weights.add(prof.getWeight().toString()); 
        
        hm.put(dates, weights);
        return hm;
    }
    
    public HashMap addMuscleStat(){
        List<String> dates = null;
        List<String> dimensions = null;
        Profile prof = null;
        dates.add(prof.getDate().toString());
        dimensions.add(prof.getBiceps_dimension().toString()); 
        
        hm.put(dates, dimensions);
        return hm;
    }
    
    public HashMap addExerciseStat(){
        List<String> repeats = null;
        List<String> weights = null;
        Diary diary = null;
        
        
        hm.put(repeats, weights);
        return hm;
    }
    
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public Users getOwner() {
        return owner;
    }

    public void setOwner(Users owner) {
        this.owner = owner;
    }
}