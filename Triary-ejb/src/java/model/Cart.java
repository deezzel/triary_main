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
@XmlRootElement
@Table(name = "cart", catalog = "triary", schema = "")
@NamedQueries({
   @NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c")})
public class Cart extends BaseEntity implements Serializable{
    @Column(name = "count", nullable=true)
    private Integer count;
    @ManyToOne
    @JoinColumn(name = "product", referencedColumnName = "id")
    private Product product;
//    @OneToMany (mappedBy="id")
//    private Users owner;

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
}
