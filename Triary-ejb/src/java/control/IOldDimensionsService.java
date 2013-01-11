/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import model.OldDimensions;
import model.Users;

/**
 *
 * @author kate
 */
public interface IOldDimensionsService {
    
    public List<OldDimensions> getAll(Users user);
    
    public List<String> getListWeight(Integer user);
    
    public List<String> getListDate(Integer user);
    
    public List<String> getListWaist(Integer user);
    
    public List<String> getListChest(Integer user);
    
    public List<String> getListBiceps(Integer user);
    
    public List<String> getListForearm(Integer user);
    
    public List<String> getListWrist(Integer user);
    
    public List<String> getListNeck(Integer user);
    
    public List<String> getListThigh(Integer user);
    
    public List<String> getListButt(Integer user);
    
    public List<String> getListShin(Integer user);
    
}
