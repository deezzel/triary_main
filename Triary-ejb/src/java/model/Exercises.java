/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "exercises", catalog = "triary", schema = "")
@NamedQueries({
    @NamedQuery(name = "Exercises.getAll", query = "SELECT e FROM Exercises e"),
    @NamedQuery(name = "Exercises.getNames", query = "SELECT e.name FROM Exercises e ORDER BY e.name")
})
@XmlRootElement
public class Exercises extends BaseEntity implements Serializable {

    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Column(name = "description", nullable = true, length = 1500)
    private String description;

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
}
