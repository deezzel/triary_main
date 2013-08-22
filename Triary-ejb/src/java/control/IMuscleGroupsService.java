/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import model.MuscleGroups;

/**
 *
 * @author Artem Mihelson <artem.mihelson@gmail.com>
 */
public interface IMuscleGroupsService {
    public List<MuscleGroups> getAll();
    public List<String> getMuscleGroupsNames();
    
}
