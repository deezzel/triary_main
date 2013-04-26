/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.mbeans;

import control.serviceimplem.CategoryService;
import control.serviceimplem.ProductService;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Product;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author kate
 */
@ManagedBean(name="addProductMB")
@ViewScoped
public class AddProductManagedBean {
    
    @EJB
    private ProductService productService;
    @EJB
    private CategoryService categoryService;
    private Product curproduct = new Product();
    private UploadedFile input_file;
    private List<String> category_list;
    private String category_name;
    
    public AddProductManagedBean(){}

    private List<String> getCategoryListNames(){
        setCategory_list(categoryService.getCategoryNames());
        return getCategory_list();
    }
    
    
    
    /**
     * @return the productService
     */
    public ProductService getProductService() {
        return productService;
    }

    /**
     * @param productService the productService to set
     */
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    /**
     * @return the curproduct
     */
    public Product getCurproduct() {
        return curproduct;
    }

    /**
     * @param curproduct the curproduct to set
     */
    public void setCurproduct(Product curproduct) {
        this.curproduct = curproduct;
    }
    
    public void addProduct(){
        if ((curproduct.getName() != null)||(curproduct.getDescription()!=null)){
            byte[] in = curproduct.getImage();
            String filename = input_file.getFileName().toString();
            String contType = input_file.getContentType();
            String name_cat = this.category_name;
            if (input_file!=null){
            curproduct.setImage(this.input_file.getContents());
            }
            curproduct.setCategory(categoryService.getByName(category_name));
            productService.create(curproduct);
        }
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
     * @return the category_name
     */
    public String getCategory_name() {
        return category_name;
    }

    /**
     * @param category_name the category_name to set
     */
    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    /**
     * @return the category_list
     */
    public List<String> getCategory_list() {
        category_list = categoryService.getCategoryNames();
        return category_list;
    }

    /**
     * @param category_list the category_list to set
     */
    public void setCategory_list(List<String> category_list) {
        this.category_list = category_list;
    }
}
