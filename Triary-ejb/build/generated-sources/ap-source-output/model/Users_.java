package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Comment;
import model.Diary;
import model.Publication;
import model.baseclass.UserBase_;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-12-26T22:45:39")
@StaticMetamodel(Users.class)
public class Users_ extends UserBase_ {

    public static volatile ListAttribute<Users, Publication> publicationList;
    public static volatile SingularAttribute<Users, String> roleuser;
    public static volatile SingularAttribute<Users, Diary> diary;
    public static volatile ListAttribute<Users, Comment> commentList;

}