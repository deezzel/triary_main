package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Users;
import model.baseclass.BaseEntity_;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-12-26T22:45:39")
@StaticMetamodel(OldDimensions.class)
public class OldDimensions_ extends BaseEntity_ {

    public static volatile SingularAttribute<OldDimensions, String> old_shin_dimension;
    public static volatile SingularAttribute<OldDimensions, String> old_thigh_dimension;
    public static volatile SingularAttribute<OldDimensions, String> old_chest_dimension;
    public static volatile SingularAttribute<OldDimensions, String> old_neck_dimension;
    public static volatile SingularAttribute<OldDimensions, String> old_waist_dimension;
    public static volatile SingularAttribute<OldDimensions, String> old_weight;
    public static volatile SingularAttribute<OldDimensions, String> old_wrist_dimension;
    public static volatile SingularAttribute<OldDimensions, Users> owner;
    public static volatile SingularAttribute<OldDimensions, Date> old_date;
    public static volatile SingularAttribute<OldDimensions, String> old_forearm_dimension;
    public static volatile SingularAttribute<OldDimensions, String> old_biceps_dimension;
    public static volatile SingularAttribute<OldDimensions, String> old_butt_dimension;
    public static volatile SingularAttribute<OldDimensions, String> old_height;

}