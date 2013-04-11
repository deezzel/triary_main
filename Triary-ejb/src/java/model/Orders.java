/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
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
    @OneToMany(mappedBy = "orders", cascade={CascadeType.ALL})
    private List<Product> productList;
    
    /**
     * @return the date
     */
    public Date getDate() {
        return getOrder_date();
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.setOrder_date(date);
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

    /**
     * @return the order_date
     */
    public Date getOrder_date() {
        return order_date;
    }

    /**
     * @param order_date the order_date to set
     */
    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    /**
     * @return the owner
     */
    public Users getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(Users owner) {
        this.owner = owner;
    }

    /**
     * @return the shipping
     */
    public Shipping getShipping() {
        return shipping;
    }

    /**
     * @param shipping the shipping to set
     */
    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    /**
     * @return the productList
     */
    public List<Product> getProductList() {
        return productList;
    }

    /**
     * @param productList the productList to set
     */
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
