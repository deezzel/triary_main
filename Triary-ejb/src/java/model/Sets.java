/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import model.baseclass.BaseEntity;

/**
 *
 * @author Artem Mihelson <artem.mihelson@gmail.com>
 */
@Entity
@Table(name = "sets", catalog = "triary", schema = "")
@NamedQueries({
    @NamedQuery (name="Sets.getById", query="SELECT s from Sets s WHERE s.i_set = :diary_id")
})
@XmlRootElement
public class Sets extends BaseEntity implements Serializable {
    @ManyToOne
    @JoinColumn(name = "i_set", nullable = true, referencedColumnName = "id")
    private Diary i_set;
    @Column(name = "weight", nullable=true, length=50)
    private String weight;
    @Column(name = "amount", nullable=true, length=50)
    private String amount;
    
    public Sets(){}
    
    public Sets(String weight, String amount){
        this.weight = weight;
        this.amount = amount;
    }

    /**
     * @return the i_set
     */
    public Diary getI_set() {
        return i_set;
    }

    /**
     * @param i_set the i_set to set
     */
    public void setI_set(Diary i_set) {
        this.i_set = i_set;
    }

    /**
     * @return the weight
     */
    public String getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }
    
    
    
}
