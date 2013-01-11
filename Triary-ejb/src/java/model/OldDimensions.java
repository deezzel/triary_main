/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import model.baseclass.BaseEntity;

/**
 *
 * @author kate
 */
@Entity
@Table(name = "old_dimensions", catalog = "triary", schema = "")
@NamedQueries({
    @NamedQuery(name = "OldDimensions.getAll", query = "SELECT o FROM OldDimensions o WHERE o.owner = :owner"),
   @NamedQuery(name = "OldDimensions.getListWeight", query = "SELECT o.old_weight FROM OldDimensions o WHERE o.owner = :owner group by o.old_weight"),
   @NamedQuery(name = "OldDimensions.getListDate", query = "SELECT o.old_date FROM OldDimensions o WHERE o.owner = :owner group by o.old_date"),
   @NamedQuery(name = "OldDimensions.getListWaist", query = "SELECT o.old_waist_dimension FROM OldDimensions o WHERE o.owner = :owner group by o.old_waist_dimension"),
   @NamedQuery(name = "OldDimensions.getListChest", query = "SELECT o.old_chest_dimension FROM OldDimensions o WHERE o.owner = :owner group by o.old_chest_dimension"),
   @NamedQuery(name = "OldDimensions.getListBiceps", query = "SELECT o.old_biceps_dimension FROM OldDimensions o WHERE o.owner = :owner group by o.old_biceps_dimension"),
   @NamedQuery(name = "OldDimensions.getListForearm", query = "SELECT o.old_forearm_dimension FROM OldDimensions o WHERE o.owner = :owner group by o.old_forearm_dimension"),
   @NamedQuery(name = "OldDimensions.getListWrist", query = "SELECT o.old_wrist_dimension FROM OldDimensions o WHERE o.owner = :owner group by o.old_wrist_dimension"),
   @NamedQuery(name = "OldDimensions.getListNeck", query = "SELECT o.old_neck_dimension FROM OldDimensions o WHERE o.owner = :owner group by o.old_neck_dimension"),
   @NamedQuery(name = "OldDimensions.getListThigh", query = "SELECT o.old_thigh_dimension FROM OldDimensions o WHERE o.owner = :owner group by o.old_thigh_dimension"),
   @NamedQuery(name = "OldDimensions.getListButt", query = "SELECT o.old_butt_dimension FROM OldDimensions o WHERE o.owner = :owner group by o.old_butt_dimension"),
   @NamedQuery(name = "OldDimensions.getListShin", query = "SELECT o.old_shin_dimension FROM OldDimensions o WHERE o.owner = :owner group by o.old_shin_dimension")
})
public class OldDimensions extends BaseEntity implements Serializable {
    @Column(name = "old_date", nullable=true)
    @Temporal(TemporalType.DATE)
    private Date old_date;
    @Column(name = "old_weight", nullable=true, length = 255)
    private String old_weight;
    @Column(name = "old_height", nullable=true, length = 255)
    private String old_height;
    @Column(name = "old_waist_dimension", nullable=true, length = 15)
    private String old_waist_dimension;
    @Column(name = "old_chest_dimension", nullable=true, length = 15)
    private String old_chest_dimension;
    @Column(name = "old_biceps_dimension", nullable=true, length = 15)
    private String old_biceps_dimension;
    @Column(name = "old_forearm_dimension", nullable=true, length = 15)
    private String old_forearm_dimension;
    @Column(name = "old_wrist_dimension", nullable=true, length = 15)
    private String old_wrist_dimension;
    @Column(name = "old_neck_dimension", nullable=true, length = 15)
    private String old_neck_dimension;
    @Column(name = "old_thigh_dimension", nullable=true, length = 15)
    private String old_thigh_dimension;
    @Column(name = "old_butt_dimension", nullable=true, length = 15)
    private String old_butt_dimension;
    @Column(name = "old_shin_dimension", nullable=true, length = 15)
    private String old_shin_dimension;
    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "id")
    private Users owner;

    /**
     * @return the old_date
     */
    public Date getOld_date() {
        return old_date;
    }

    /**
     * @param old_date the old_date to set
     */
    public void setOld_date(Date old_date) {
        this.old_date = old_date;
    }

    /**
     * @return the old_weight
     */
    public String getOld_weight() {
        return old_weight;
    }

    /**
     * @param old_weight the old_weight to set
     */
    public void setOld_weight(String old_weight) {
        this.old_weight = old_weight;
    }

    /**
     * @return the old_height
     */
    public String getOld_height() {
        return old_height;
    }

    /**
     * @param old_height the old_height to set
     */
    public void setOld_height(String old_height) {
        this.old_height = old_height;
    }

    /**
     * @return the old_waist_dimension
     */
    public String getOld_waist_dimension() {
        return old_waist_dimension;
    }

    /**
     * @param old_waist_dimension the old_waist_dimension to set
     */
    public void setOld_waist_dimension(String old_waist_dimension) {
        this.old_waist_dimension = old_waist_dimension;
    }

    /**
     * @return the old_chest_dimension
     */
    public String getOld_chest_dimension() {
        return old_chest_dimension;
    }

    /**
     * @param old_chest_dimension the old_chest_dimension to set
     */
    public void setOld_chest_dimension(String old_chest_dimension) {
        this.old_chest_dimension = old_chest_dimension;
    }

    /**
     * @return the old_biceps_dimension
     */
    public String getOld_biceps_dimension() {
        return old_biceps_dimension;
    }

    /**
     * @param old_biceps_dimension the old_biceps_dimension to set
     */
    public void setOld_biceps_dimension(String old_biceps_dimension) {
        this.old_biceps_dimension = old_biceps_dimension;
    }

    /**
     * @return the old_forearm_dimension
     */
    public String getOld_forearm_dimension() {
        return old_forearm_dimension;
    }

    /**
     * @param old_forearm_dimension the old_forearm_dimension to set
     */
    public void setOld_forearm_dimension(String old_forearm_dimension) {
        this.old_forearm_dimension = old_forearm_dimension;
    }

    /**
     * @return the old_wrist_dimension
     */
    public String getOld_wrist_dimension() {
        return old_wrist_dimension;
    }

    /**
     * @param old_wrist_dimension the old_wrist_dimension to set
     */
    public void setOld_wrist_dimension(String old_wrist_dimension) {
        this.old_wrist_dimension = old_wrist_dimension;
    }

    /**
     * @return the old_neck_dimension
     */
    public String getOld_neck_dimension() {
        return old_neck_dimension;
    }

    /**
     * @param old_neck_dimension the old_neck_dimension to set
     */
    public void setOld_neck_dimension(String old_neck_dimension) {
        this.old_neck_dimension = old_neck_dimension;
    }

    /**
     * @return the old_thigh_dimension
     */
    public String getOld_thigh_dimension() {
        return old_thigh_dimension;
    }

    /**
     * @param old_thigh_dimension the old_thigh_dimension to set
     */
    public void setOld_thigh_dimension(String old_thigh_dimension) {
        this.old_thigh_dimension = old_thigh_dimension;
    }

    /**
     * @return the old_butt_dimension
     */
    public String getOld_butt_dimension() {
        return old_butt_dimension;
    }

    /**
     * @param old_butt_dimension the old_butt_dimension to set
     */
    public void setOld_butt_dimension(String old_butt_dimension) {
        this.old_butt_dimension = old_butt_dimension;
    }

    /**
     * @return the old_shin_dimension
     */
    public String getOld_shin_dimension() {
        return old_shin_dimension;
    }

    /**
     * @param old_shin_dimension the old_shin_dimension to set
     */
    public void setOld_shin_dimension(String old_shin_dimension) {
        this.old_shin_dimension = old_shin_dimension;
    }
    
    public void OldDimensions(){}
}
