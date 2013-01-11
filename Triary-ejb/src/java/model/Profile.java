/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import model.baseclass.BaseEntity;
/**
 *
 * @author aliona
 */
@Entity
@XmlRootElement
@Table(name = "profile", catalog = "triary", schema = "")
@NamedQueries({
   //@NamedQuery(name = "Profile.findById", query = "SELECT p FROM Profile p WHERE id_profile = :id"),
   @NamedQuery(name = "Profile.getByUser", query = "SELECT p FROM Profile p WHERE p.owner = :owner")
   //@NamedQuery(name ="Profile.getDiaryEnabled", query = "SELECT p.diary_enabled FROM Profile p WHERE p.owner_id = :id_users"),
   //@NamedQuery(name ="Profile.getByStatisticsEn", query = "SELECT p.stat_enabled FROM Profile p WHERE p.owner_id = :id_users"),
   //@NamedQuery(name = "Profile.updateDiaryEnabled", query = "UPDATE Profile p SET p.diary_enabled = :diary_enabled WHERE p.owner_id = :id_users"),
   //@NamedQuery(name = "Profile.updateStatisticsEn", query = "UPDATE Profile p SET p.stat_enabled = :stat_enabled WHERE p.owner_id = :id_users"),
})

public class Profile extends BaseEntity implements Serializable{
    
    @Column(name = "diet", nullable=true, length = 1500)
    private String diet;
    @Column(name = "ration", nullable=true, length = 1500)
    private String ration;
    @Column(name = "date", nullable=true)
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "weight", nullable=true, length = 255)
    private String weight;
    @Column(name = "height", nullable=true, length = 255)
    private String height;
    @Column(name = "stat_enabled", nullable=true)
    private Boolean stat_enabled;
    @Column(name = "diary_enabled", nullable=true)
    private Boolean diary_enabled;
    @Column(name = "waist_dimension", nullable=true, length = 15)
    private String waist_dimension;
    @Column(name = "chest_dimension", nullable=true, length = 15)
    private String chest_dimension;
    @Column(name = "biceps_dimension", nullable=true, length = 15)
    private String biceps_dimension;
    @Column(name = "forearm_dimension", nullable=true, length = 15)
    private String forearm_dimension;
    @Column(name = "wrist_dimension", nullable=true, length = 15)
    private String wrist_dimension;
    @Column(name = "neck_dimension", nullable=true, length = 15)
    private String neck_dimension;
    @Column(name = "thigh_dimension", nullable=true, length = 15)
    private String thigh_dimension;
    @Column(name = "butt_dimension", nullable=true, length = 15)
    private String butt_dimension;
    @Column(name = "shin_dimension", nullable=true, length = 15)
    private String shin_dimension;
    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "id")
    private Users owner;
    
    /**
     *
     */
    
    public Profile(){}
    
    public Profile(String diet, String ration, String weight, Boolean stat_en, Boolean diary_en, Timestamp date){
        this.diet= diet;
        this.ration = ration;
        this.weight = weight;
        this.stat_enabled = stat_en;
        this.diary_enabled= diary_en;
        this.date = date;
    }
    
    
    
    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public String getRation() {
        return ration;
    }

    public void setRation(String ration) {
        this.ration = ration;
    }
    
    
    public String getWaistDimension() {
        return getWaist_dimension();
    }

    public void setWaistDimension(String waist_dimension) {
        this.setWaist_dimension(waist_dimension);
    }
    
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
    public Boolean getStatEnabled() {
        return getStat_enabled();
    }

    public Boolean getDiaryEnabled() {
        return getDiary_enabled();
    }

    /**
     * @return the waist_dimension
     */
    public String getWaist_dimension() {
        return waist_dimension;
    }

    /**
     * @param waist_dimension the waist_dimension to set
     */
    public void setWaist_dimension(String waist_dimension) {
        this.waist_dimension = waist_dimension;
    }

    /**
     * @return the chest_dimension
     */
    public String getChest_dimension() {
        return chest_dimension;
    }

    /**
     * @param chest_dimension the chest_dimension to set
     */
    public void setChest_dimension(String chest_dimension) {
        this.chest_dimension = chest_dimension;
    }

    /**
     * @return the biceps_dimension
     */
    public String getBiceps_dimension() {
        return biceps_dimension;
    }

    /**
     * @param biceps_dimension the biceps_dimension to set
     */
    public void setBiceps_dimension(String biceps_dimension) {
        this.biceps_dimension = biceps_dimension;
    }

    /**
     * @return the forearm_dimension
     */
    public String getForearm_dimension() {
        return forearm_dimension;
    }

    /**
     * @param forearm_dimension the forearm_dimension to set
     */
    public void setForearm_dimension(String forearm_dimension) {
        this.forearm_dimension = forearm_dimension;
    }

    /**
     * @return the wrist_dimension
     */
    public String getWrist_dimension() {
        return wrist_dimension;
    }

    /**
     * @param wrist_dimension the wrist_dimension to set
     */
    public void setWrist_dimension(String wrist_dimension) {
        this.wrist_dimension = wrist_dimension;
    }

    /**
     * @return the neck_dimension
     */
    public String getNeck_dimension() {
        return neck_dimension;
    }

    /**
     * @param neck_dimension the neck_dimension to set
     */
    public void setNeck_dimension(String neck_dimension) {
        this.neck_dimension = neck_dimension;
    }

    /**
     * @return the thigh_dimension
     */
    public String getThigh_dimension() {
        return thigh_dimension;
    }

    /**
     * @param thigh_dimension the thigh_dimension to set
     */
    public void setThigh_dimension(String thigh_dimension) {
        this.thigh_dimension = thigh_dimension;
    }

    /**
     * @return the butt_dimension
     */
    public String getButt_dimension() {
        return butt_dimension;
    }

    /**
     * @param butt_dimension the butt_dimension to set
     */
    public void setButt_dimension(String butt_dimension) {
        this.butt_dimension = butt_dimension;
    }

    /**
     * @return the shin_dimension
     */
    public String getShin_dimension() {
        return shin_dimension;
    }

    /**
     * @param shin_dimension the shin_dimension to set
     */
    public void setShin_dimension(String shin_dimension) {
        this.shin_dimension = shin_dimension;
    }

    /**
     * @return the height
     */
    public String getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * @return the stat_enabled
     */
    public Boolean getStat_enabled() {
        return stat_enabled;
    }

    /**
     * @param stat_enabled the stat_enabled to set
     */
    public void setStat_enabled(Boolean stat_enabled) {
        this.stat_enabled = stat_enabled;
    }

    /**
     * @return the diary_enabled
     */
    public Boolean getDiary_enabled() {
        return diary_enabled;
    }

    /**
     * @param diary_enabled the diary_enabled to set
     */
    public void setDiary_enabled(Boolean diary_enabled) {
        this.diary_enabled = diary_enabled;
    }
    
}
