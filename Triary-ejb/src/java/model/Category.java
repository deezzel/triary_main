/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import model.baseclass.BaseEntity;

/**
 *
 * @author kate
 */

@Entity
@XmlRootElement
@Table(name = "category", catalog = "triary", schema = "")
@NamedQueries({
   @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
   @NamedQuery(name = "Category.getNames", query = "SELECT c.name FROM Category c ORDER BY c.name"),
   @NamedQuery(name = "Category.getByName", query = "SELECT c FROM Category c where c.name = :name")
})
public class Category extends BaseEntity implements Serializable{
    
    @Column(name = "description", nullable=true, length = 1500)
    private String description;
    @Column(name = "name", nullable=true, length = 255)
    private String name;
    @Column(name = "image", nullable=true)
    @Lob
    private byte[] image;

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
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
}
