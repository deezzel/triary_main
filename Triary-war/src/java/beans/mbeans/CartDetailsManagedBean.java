/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.mbeans;

import control.serviceimplem.CartService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import model.Cart;

/**
 *
 * @author kate
 */
@ManagedBean(name = "cartdetailsMB")
@RequestScoped
public class CartDetailsManagedBean {

    @EJB
    private CartService cartService;
    private List<Cart> lstProductsInCart;
    @ManagedProperty(value = "#{userManagedBean}")
    private UserManagedBean usrMB;
    private String totalPrice;
    private Integer sum_total = 0;
    private Integer cnt;
    private Integer price;
    private Integer total;
    private Integer res_total;
    private Integer id_product;
    private Cart canceledProduct;

    public void CartDetailManagedBean() {
    }

    /**
     * @return the cartService
     */
    public CartService getCartService() {
        return cartService;
    }

    /**
     * @param cartService the cartService to set
     */
    public void setCartService(CartService cartService) {
        this.cartService = cartService;
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

    @PostConstruct
    public void init() {
//        String id_cart_of_user = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("cart_of_user");
//        Integer id = new Integer(id_cart_of_user);
        try {
            lstProductsInCart = cartService.getByStatusProducts(getUsrMB().getCurrentUser(), "InCart");
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    /**
     * @return the lstProductsInCart
     */
    public List<Cart> getLstProductsInCart() {
        return lstProductsInCart;
    }

    /**
     * @return the totalPrice
     */
    public String getTotalPrice() {
        List<Cart> lstProducts = cartService.getByStatusProducts(usrMB.getCurrentUser(), "InCart");
        if (!lstProducts.isEmpty()) {
            for (Cart element : lstProducts) {
                cnt = element.getCount();
                price = Integer.parseInt(element.getPrice());
                total = cnt * price;
                sum_total = total + sum_total;
                res_total = sum_total;
            }
            sum_total = 0;
            totalPrice = res_total.toString();
            return totalPrice;
        } else {
            return Integer.valueOf(0).toString();
        }
    }

    /**
     * @param totalPrice the totalPrice to set
     */
    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void cancelProduct() {
        Integer id = new Integer(getId_product());
        canceledProduct = cartService.find(Integer.valueOf(id));
        canceledProduct.setStatus("Canceled");
        cartService.edit(canceledProduct);
    }

    /**
     * @return the id_product
     */
    public Integer getId_product() {
        return id_product;
    }

    /**
     * @param id_product the id_product to set
     */
    public void setId_product(Integer id_product) {
        this.id_product = id_product;
    }

    public boolean isCartIsEmpty() {
        if (lstProductsInCart.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
