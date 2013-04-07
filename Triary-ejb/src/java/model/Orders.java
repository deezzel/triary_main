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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import model.baseclass.BaseEntity;

/**
 *
 * @author kate
 */
@Entity
@XmlRootElement
@Table(name = "order", catalog = "triary", schema = "")
@NamedQueries({
   @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o")})
public class Orders extends BaseEntity implements Serializable{
    @Column(name = "date", nullable=true)
    @Temporal(TemporalType.DATE)
    private Date order_date;
    @Column(name = "price", nullable=true, length=250)
    private String price;
    @Column(name = "state", nullable=true,length=250)
    private String state;
    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "id")
    private Users owner;
    @ManyToOne
    @JoinColumn(name = "shipping", referencedColumnName="id")
    private Shipping shipping;

    /**
     * @return the date
     */
    public Date getDate() {
        return order_date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.order_date = date;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }
}
