/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import model.Category;

/**
 *
 * @author kate
 */
public interface ICategoryService {
    public List<Category> getAll();
    public List<String> getCategoryNames();
    public Category getByName(String name);
}
