package model.baseclass;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-12-26T22:45:39")
@StaticMetamodel(UserBase.class)
public class UserBase_ extends BaseEntity_ {

    public static volatile SingularAttribute<UserBase, String> phone;
    public static volatile SingularAttribute<UserBase, Date> register_date;
    public static volatile SingularAttribute<UserBase, String> email;
    public static volatile SingularAttribute<UserBase, String> name;
    public static volatile SingularAttribute<UserBase, String> surname;
    public static volatile SingularAttribute<UserBase, String> login;
    public static volatile SingularAttribute<UserBase, String> password;

}