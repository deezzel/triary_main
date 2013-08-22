/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import model.Exercises;

/**
 *
 * @author Artem Mihelson <artem.mihelson@gmail.com>
 */
public interface IExercisesService {
    public List<Exercises> getAll();
    public List<String> getExercisesNames();
}
