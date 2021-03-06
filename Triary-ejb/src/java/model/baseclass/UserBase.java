/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.baseclass;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author kate
 */
@MappedSuperclass
public class UserBase extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "login", nullable = true, length = 25, unique=true)
    protected  String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password", nullable = true, length = 20)
    protected  String password;
    @Basic(optional = false)
    @Column(name = "register_date", nullable = true)
    @Temporal(TemporalType.DATE)
    protected Date register_date;
    @Basic(optional = false)
    @NotNull
    @Size(min=1, max = 45)
    @Column(name = "email", nullable = true, length=50)
    protected String  email;
    @Basic(optional = false)
    @NotNull
    @Size(min=1, max = 45)
    @Column(name = "name", nullable = true, length=25)
    protected String  name;
    @Basic(optional = false)
    @NotNull
    @Size(min=1, max = 45)
    @Column(name = "surname", nullable = true, length=25)
    protected String  surname;
    @Basic(optional = false)
    @NotNull
    @Size(min=1, max = 11)
    @Column(name = "phone", nullable = true, length=12)
    protected String  phone;
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Date getCreationDate() {
        return register_date;
    }

    public void setCreationDate(Date cd) {
        this.register_date = cd;
    }
    
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getSurName() {
        return surname;
    }

    public void setSurName(String surname) {
        this.surname = surname;
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    

   
}
