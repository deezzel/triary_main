/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;
import javax.persistence.CascadeType;
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
import javax.xml.bind.annotation.XmlTransient;
import model.baseclass.BaseEntity;

/**
 *
 * @author Artem Mihelson <artem.mihelson@gmail.com>
 */
@Entity
@Table(name = "diary", catalog = "triary", schema = "")
@NamedQueries({ //@NamedQuery(name = "Diary.findById", query = "SELECT d FROM Diary d WHERE id = :id"),
//@NamedQuery(name = "Diary.selectTrainingType", query = "SELECT d.training_type FROM Diary d"),
//@NamedQuery(name = "Diary.selectMuscleGroup", query = "SELECT d.muscle_gr FROM Diary d"),
//@NamedQuery(name = "Diary.selectWeight", query = "SELECT d.weight FROM Diary d"),
//@NamedQuery(name = "Diary.selectTasks", query = "SELECT d.tasks FROM Diary d"),
//@NamedQuery(name = "Diary.selectRepeats", query = "SELECT d.repeat_amount FROM Diary d")
    @NamedQuery(name="Diary.getAll", query="SELECT d FROM Diary d WHERE d.owner = :owner")
})
@XmlRootElement
public class Diary extends BaseEntity implements Serializable {

    @Column(name = "training_type", nullable = true, length = 255)
    private String training_type;
    @Column(name = "muscle_gr", nullable = true, length = 255)
    private String muscle_gr;
    @Column(name = "tasks", nullable = true, length = 255)
    private String tasks;
    @Column(name = "fillings", nullable = true, length = 255)
    private String fillings;
    @Column(name = "attempts", nullable = true, length = 255)
    private String attempts;
    @OneToMany(mappedBy = "diary", cascade={CascadeType.ALL})
    private List<Comment> commentList;
    @OneToMany(mappedBy="i_set", cascade={CascadeType.ALL})
    private List<Sets> setsList;
    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "id")
    private Users owner;

    public Diary() {
    }

    public Diary(String training_type, String muscle_gr, String tasks, String fillings) {
        this.training_type = training_type;
        this.muscle_gr = muscle_gr;
        this.fillings = fillings;
        this.tasks = tasks;
        
    }

    public void addComment(Comment comm) {
        if (null != commentList && null != comm) {
            commentList.add(comm);
        }
    }

    public void delComment(Comment comm) {
        if (null != commentList && null != comm) {
            commentList.remove(comm);
        }
    }

    public String getTrainingType() {
        return training_type;
    }

    public void setTrainingType(String training_type) {
        this.training_type = training_type;
    }

    public String getMuscleGroup() {
        return muscle_gr;
    }

    public void setMuscleGroup(String muscle_gr) {
        this.muscle_gr = muscle_gr;
    }

    public String getTasks() {
        return tasks;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }

    public String getFillings() {
        return fillings;
    }

    public void setFillings(String fillings) {
        this.fillings = fillings;
    }

    public void setOwner(Users owner) {
        this.owner = owner;
    }

    public Users getOwner() {
        return owner;
    }

    @XmlTransient
    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    /**
     * @return the attempts
     */
    public String getAttempts() {
        return attempts;
    }

    /**
     * @param attempts the attempts to set
     */
    public void setAttempts(String attempts) {
        this.attempts = attempts;
    }

    /**
     * @return the setsList
     */
    public List<Sets> getSetsList() {
        return setsList;
    }

    /**
     * @param setsList the setsList to set
     */
    public void setSetsList(List<Sets> setsList) {
        this.setsList = setsList;
    }
}
