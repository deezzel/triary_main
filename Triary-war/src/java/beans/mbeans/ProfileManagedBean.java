/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.mbeans;

import control.serviceimplem.CartService;
import control.serviceimplem.ProductService;
import control.serviceimplem.ProfileService;
import control.serviceimplem.UserService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import model.Cart;
import model.Product;
import model.Profile;
import model.Users;

/**
 *
 * @author kate
 */
@ManagedBean(name = "profileMB")
@SessionScoped
public class ProfileManagedBean implements Serializable {

    private final static String[] params;

    static {
        params = new String[11];
        params[0] = "Рост";
        params[1] = "Вес";
        params[2] = "Талия";
        params[3] = "Бицепс";
        params[4] = "Грудь";
        params[5] = "Предплечье";
        params[6] = "Запястье";
        params[7] = "Шея";
        params[8] = "Бедро";
        params[9] = "Ягодицы";
        params[10] = "Голень";
    }
    private Users curuser;
    private Profile curprofile;
    @EJB
    private UserService userService;
    @EJB
    private ProfileService profileService;
    @EJB
    private CartService cartService;
    @EJB
    private ProductService productService;
    private List<String> lstParams;
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
    private Product reversedProduct;

    public ProfileManagedBean() {
    }

    /**
     * @return the curuser
     */
    public Users getCuruser() {
        return curuser;
    }

    /**
     * @param curuser the curuser to set
     */
    public void setCuruser(Users curuser) {
        this.curuser = curuser;
    }

    /**
     * @return the curprofile
     */
    public Profile getCurprofile() {
        return curprofile;
    }

    /**
     * @param curprofile the curprofile to set
     */
    public void setCurprofile(Profile curprofile) {
        this.curprofile = curprofile;
    }

    /**
     * @return the userService
     */
    public UserService getUserService() {
        return userService;
    }

    /**
     * @param userService the userService to set
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * @return the profileService
     */
    public ProfileService getProfileService() {
        return profileService;
    }

    /**
     * @param profileService the profileService to set
     */
    public void setProfileService(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostConstruct
    public void init() {
        String id_prof = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("id_user");
        Integer id = new Integer(id_prof);
        try {
            lstProductsInCart = cartService.getByStatusProducts(getUsrMB().getCurrentUser(), "InCart");
            curprofile = (Profile) profileService.find(new Integer(id));
            System.out.println(((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getQueryString());
//            System.out.print(updatePubl.getText());

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public boolean isCartIsEmpty() {
        if (lstProductsInCart.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void updateProfile() {
        profileService.edit(curprofile);
    }

    /**
     * @return the lstParams
     */
    public List<String> getLstParams() {
        return lstParams;
    }

    /**
     * @param lstParams the lstParams to set
     */
    public void setLstParams(List<String> lstParams) {
        this.lstParams = lstParams;
    }

    public List<String> fillLstParams() {
        lstParams.add("Рост");
        lstParams.add("Вес");
        lstParams.add("Бицепс");
        setLstParams(lstParams);
        return lstParams;
    }

    public boolean isDiaryEnabled() {
        if (curprofile.getDiaryEnabled()) {
            return true;
        }
        return false;
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
     * @return the lstProductsInCart
     */
    public List<Cart> getLstProductsInCart() {
        lstProductsInCart = cartService.getByStatusProducts(getUsrMB().getCurrentUser(), "InCart");
        return lstProductsInCart;
    }

    /**
     * @param lstProductsInCart the lstProductsInCart to set
     */
    public void setLstProductsInCart(List<Cart> lstProductsInCart) {
        this.lstProductsInCart = lstProductsInCart;
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
     * @return the totalPrice
     */
    public String getTotalPrice() {
        if (getLstProductsInCart() != null) {
            for (Cart element : getLstProductsInCart()) {
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
        Integer id = new Integer(id_product);
        canceledProduct = cartService.find(Integer.valueOf(id));
        canceledProduct.setStatus("Canceled");
        reversedProduct = productService.find(canceledProduct.getProduct_id());
        productService.increaseAmount(reversedProduct, canceledProduct.getCount());
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
}
