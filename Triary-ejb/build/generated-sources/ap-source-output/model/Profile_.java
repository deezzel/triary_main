package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Users;
import model.baseclass.BaseEntity_;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-12-26T22:45:39")
@StaticMetamodel(Profile.class)
public class Profile_ extends BaseEntity_ {

    public static volatile SingularAttribute<Profile, String> ration;
    public static volatile SingularAttribute<Profile, Boolean> diary_enabled;
    public static volatile SingularAttribute<Profile, String> neck_dimension;
    public static volatile SingularAttribute<Profile, String> weight;
    public static volatile SingularAttribute<Profile, String> diet;
    public static volatile SingularAttribute<Profile, Date> date;
    public static volatile SingularAttribute<Profile, String> butt_dimension;
    public static volatile SingularAttribute<Profile, Boolean> stat_enabled;
    public static volatile SingularAttribute<Profile, String> forearm_dimension;
    public static volatile SingularAttribute<Profile, String> thigh_dimension;
    public static volatile SingularAttribute<Profile, String> height;
    public static volatile SingularAttribute<Profile, String> chest_dimension;
    public static volatile SingularAttribute<Profile, Users> owner;
    public static volatile SingularAttribute<Profile, String> wrist_dimension;
    public static volatile SingularAttribute<Profile, String> biceps_dimension;
    public static volatile SingularAttribute<Profile, String> shin_dimension;
    public static volatile SingularAttribute<Profile, String> waist_dimension;

}