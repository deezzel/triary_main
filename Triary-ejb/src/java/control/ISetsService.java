/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import model.Diary;
import model.Sets;

/**
 *
 * @author Artem Mihelson <artem.mihelson@gmail.com>
 */
public interface ISetsService {
    public List<Sets> getAll();
    public List<Sets> getById(Diary i_set);
}
