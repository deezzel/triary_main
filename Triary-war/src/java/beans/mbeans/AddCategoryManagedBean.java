/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.mbeans;

import control.serviceimplem.CategoryService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Category;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author kate
 */
@ManagedBean(name="addCategoryMB")
@ViewScoped
public class AddCategoryManagedBean {
    @EJB
    private CategoryService categoryService;
    private Category curcategory = new Category();
    private UploadedFile input_file;
    
    public AddCategoryManagedBean(){}
    
    public void addCategory(){
        if ((curcategory.getName() != null) || (curcategory.getDescription()!= null)){
            if (null != input_file){
                curcategory.setImage(input_file.getContents());
            }
            categoryService.create(curcategory);
        }
    }

    /**
     * @return the categoryService
     */
    public CategoryService getCategoryService() {
        return categoryService;
    }

    /**
     * @param categoryService the categoryService to set
     */
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * @return the curcategory
     */
    public Category getCurcategory() {
        return curcategory;
    }

    /**
     * @param curcategory the curcategory to set
     */
    public void setCurcategory(Category curcategory) {
        this.curcategory = curcategory;
    }

    /**
     * @return the input_file
     */
    public UploadedFile getInput_file() {
        return input_file;
    }

    /**
     * @param input_file the input_file to set
     */
    public void setInput_file(UploadedFile input_file) {
        this.input_file = input_file;
    }
}
