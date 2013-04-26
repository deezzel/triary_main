/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.mbeans;

import control.serviceimplem.ProductService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Product;

/**
 *
 * @author kate
 */
@ManagedBean(name="marketMB")
@SessionScoped
public class MarketManagedBean implements Serializable{
    @EJB
    private ProductService productService;
    
    private List<Product> lstProducts;
    
    private Product selectedProduct;
    
    public void MarketManagedBean(){}
    
    public void setListOfProducts(){
        lstProducts = (List<Product>) productService.getAll();
    }


    /**
     * @return the lstProducts
     */
    public List<Product> getLstProducts() {
        setListOfProducts();
        return lstProducts;
    }

    /**
     * @param lstProducts the lstProducts to set
     */
    public void setLstProducts(List<Product> lstProducts) {
        this.setLstProducts(lstProducts);
    }

    /**
     * @return the selectedProduct
     */
    public Product getSelectedProduct() {
        return selectedProduct;
    }

    /**
     * @param selectedProduct the selectedProduct to set
     */
    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

}
