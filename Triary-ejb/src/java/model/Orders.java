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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import model.baseclass.BaseEntity;

/**
 *
 * @author kate
 */
@Entity
@XmlRootElement
@Table(name = "order", catalog = "triary", schema = "")
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.getConsideringOrders", query = "SELECT o FROM Orders o WHERE o.order_status like 'Considering' and o.owner = :user_id"),
    @NamedQuery(name = "Orders.getDeliveringOrders", query = "SELECT o FROM Orders o WHERE o.order_status like 'Delivering' and o.owner = :user_id"),
    @NamedQuery(name = "Orders.getDeliveredOrders", query = "SELECT o FROM Orders o WHERE o.order_status like 'Delivered' and o.owner = :user_id")
})
public class Orders extends BaseEntity implements Serializable {
    @Column(name = "product_id", nullable=true)
    private Integer product_id;
    @Column(name = "product_name", nullable = true, length = 255)
    private String product_name;
    @Column(name = "product_desc", nullable = true, length = 1500)
    private String product_desc;
    @Column(name = "product_price", nullable = true)
    private String product_price;
    @Column(name = "image", nullable = true)
    @Lob
    private byte[] image;
    @Column(name = "product_amount", nullable=true)
    private Integer product_amount;
    @Column(name = "order_date", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date order_date;
    @Column(name = "order_price", nullable = true, length = 250)
    private String order_price;
    @Column(name = "order_status", nullable = true, length = 250)
    private String order_status;
    @Column(name = "contact_name", nullable = true, length=25)
    private String contact_name;
    @Column(name = "contact_surname", nullable = true, length=25)
    private String contact_surname;
    @Column(name = "contact_email", nullable = true, length=50)
    private String contact_email;
    @Column(name = "contact_phone", nullable = true, length=12)
    private String contact_phone;
    
    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "id")
    private Users owner;
    @ManyToOne
    @JoinColumn(name = "shipping", referencedColumnName = "id")
    private Shipping shipping;
    @OneToMany(mappedBy = "orders", cascade = {CascadeType.ALL})
    private List<Product> productList;

    public void addToOrder(Product prod) {
        if (null != productList && null != prod) {
            productList.add(prod);
        }
    }

    public void removeFromOrder(Product prod) {
        if (null != productList && null != prod) {
            productList.remove(prod);
        }
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
    @XmlTransient
    public List<Product> getProductList() {
        return productList;
    }

    /**
     * @param productList the productList to set
     */
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void addProduct(Product prod) {
        if (null != productList && null != prod) {
            productList.add(prod);
        }
    }

    public void removeProduct(Product prod) {
        if (null != productList && null != prod) {
            productList.remove(prod);
        }
    }

    /**
     * @return the product_id
     */
    public Integer getProduct_id() {
        return product_id;
    }

    /**
     * @param product_id the product_id to set
     */
    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    /**
     * @return the product_name
     */
    public String getProduct_name() {
        return product_name;
    }

    /**
     * @param product_name the product_name to set
     */
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    /**
     * @return the product_desc
     */
    public String getProduct_desc() {
        return product_desc;
    }

    /**
     * @param product_desc the product_desc to set
     */
    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }

    /**
     * @return the product_price
     */
    public String getProduct_price() {
        return product_price;
    }

    /**
     * @param product_price the product_price to set
     */
    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    /**
     * @return the image
     */
    public byte[] getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(byte[] image) {
        this.image = image;
    }

    /**
     * @return the product_amount
     */
    public Integer getProduct_amount() {
        return product_amount;
    }

    /**
     * @param product_amount the product_amount to set
     */
    public void setProduct_amount(Integer product_amount) {
        this.product_amount = product_amount;
    }

    /**
     * @return the order_price
     */
    public String getOrder_price() {
        return order_price;
    }

    /**
     * @param order_price the order_price to set
     */
    public void setOrder_price(String order_price) {
        this.order_price = order_price;
    }

    /**
     * @return the order_status
     */
    public String getOrder_status() {
        return order_status;
    }

    /**
     * @param order_status the order_status to set
     */
    public void setOrder_status(String order_status) {
        this.order_status = order_status;
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
     * @return the contact_name
     */
    public String getContact_name() {
        return contact_name;
    }

    /**
     * @param contact_name the contact_name to set
     */
    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    /**
     * @return the contact_surname
     */
    public String getContact_surname() {
        return contact_surname;
    }

    /**
     * @param contact_surname the contact_surname to set
     */
    public void setContact_surname(String contact_surname) {
        this.contact_surname = contact_surname;
    }

    /**
     * @return the contact_email
     */
    public String getContact_email() {
        return contact_email;
    }

    /**
     * @param contact_email the contact_email to set
     */
    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }

    /**
     * @return the contact_phone
     */
    public String getContact_phone() {
        return contact_phone;
    }

    /**
     * @param contact_phone the contact_phone to set
     */
    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone;
    }
}
