/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import model.baseclass.BaseEntity;

/**
 *
 * @author kate
 */
@Entity
@Table(name = "cart", catalog = "triary", schema = "")
@NamedQueries({
@NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c"),
@NamedQuery(name = "Cart.getProductsByStatus", query = "SELECT c FROM Cart c WHERE c.owner = :user_id and c.status = :status")
})
public class Cart extends BaseEntity implements Serializable{
    @Column(name = "count", nullable=true)
    private Integer count;
    @Column(name = "shortdesc", nullable = true, length = 1500)
    private String shortdesc;
    @Column(name = "name", nullable = true, length = 255)
    private String name;
    @Column(name = "image", nullable = true)
    @Lob
    private byte[] image;
    @Column(name = "price", nullable = true)
    private String price;
    @Column(name = "status", nullable = false)
    private String status;
//    @OneToMany(mappedBy = "cart", cascade={CascadeType.ALL})
//    private List<Product> productList;
    @ManyToOne 
    @JoinColumn(name = "owner", referencedColumnName = "id")
    private Users owner;
    @Column(name = "product_id", nullable=true)
    private Integer product_id;
    
//    public void addProductToCart(Product prod){
//        if (null != productList && null != prod){
//            productList.add(prod);
//        }
//    }
//    
//    public void removeProductFromCart(Product prod){
//        if (null != productList && null != prod){
//            productList.remove(prod);
//        }
//    }

    /**
     * @return the count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(Integer count) {
        this.count = count;
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
     * @return the shortdesc
     */
    public String getShortdesc() {
        return shortdesc;
    }

    /**
     * @param shortdesc the shortdesc to set
     */
    public void setShortdesc(String shortdesc) {
        this.shortdesc = shortdesc;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
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
}
