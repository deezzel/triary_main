/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.mbeans;

import control.serviceimplem.CartService;
import control.serviceimplem.OrdersService;
import control.serviceimplem.ProductService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import model.Cart;
import model.Orders;
import model.Product;

/**
 *
 * @author kate
 */

@ManagedBean(name = "productDetailsMB")
@ViewScoped
public class ProductDetailsManagedBean {
    @EJB
    private ProductService productService;
    @EJB
    private CartService cartService;
    @EJB
    private OrdersService orderService;
    private Orders currOrder = new Orders ();
    private Product curProduct;
    private String id_prod;
    private Cart curCart= new Cart(); 
    @ManagedProperty(value = "#{userManagedBean}")
    private UserManagedBean usrMB;
    private List<Cart> lstProdInCart;
    
    public ProductDetailsManagedBean(){}

    /**
     * @return the curProduct
     */
    public Product getCurProduct() {
        return curProduct;
    }

    /**
     * @param curProduct the curProduct to set
     */
    public void setCurProduct(Product curProduct) {
        this.curProduct = curProduct;
    }

    /**
     * @return the id_prod
     */
    public String getId_prod() {
        return id_prod;
    }

    /**
     * @param id_prod the id_prod to set
     */
    public void setId_prod(String id_prod) {
        this.id_prod = id_prod;
    }
    
    public void addToCart(){
        cartService.addToCart(curProduct, curCart, usrMB.getCurrentUser(), curCart.getCount());
        productService.decreaseAmount(curProduct, curCart.getCount());
//        productService.addProduct(curProduct, curCart, usrMB.getCurrentUser(), curCart.getCount());
        lstProdInCart = cartService.getByStatusProducts(usrMB.getCurrentUser(), "InCart");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product has been added to your cart", "Please visit your profile and complete the order"));
    }
    
    @PostConstruct
    public void init() {
        String id_product = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("id_prod");
        Integer id = new Integer(id_product);
        try {
            curProduct = (Product) productService.find(new Integer(id));
            System.out.println(((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getQueryString());
            
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    /**
     * @return the curCart
     */
    public Cart getCurCart() {
        return curCart;
    }

    /**
     * @param curCart the curCart to set
     */
    public void setCurCart(Cart curCart) {
        this.curCart = curCart;
    }

    /**
     * @return the currOrder
     */
    public Orders getCurrOrder() {
        return currOrder;
    }

    /**
     * @param currOrder the currOrder to set
     */
    public void setCurrOrder(Orders currOrder) {
        this.currOrder = currOrder;
    }

    /**
     * @return the usrMB
     */
    public UserManagedBean getUsrMB() {
        return usrMB;
    }

    /**
     * @param usrMB the usrMB to set
     */
    public void setUsrMB(UserManagedBean usrMB) {
        this.usrMB = usrMB;
    }

    /**
     * @return the lstProd
     */
    public List<Cart> getLstProd() {
        return lstProdInCart;
    }

    /**
     * @param lstProd the lstProd to set
     */
    public void setLstProd(List<Cart> lstProd) {
        this.lstProdInCart = lstProd;
    }
}
