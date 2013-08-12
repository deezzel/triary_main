/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.mbeans;

import control.serviceimplem.CartService;
import control.serviceimplem.OrdersService;
import control.serviceimplem.ShippingService;
import control.serviceimplem.UserService;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import model.Cart;
import model.Orders;
import model.Publication;

/**
 *
 * @author kate
 */
@ManagedBean(name = "ordersMB")
@ViewScoped
public class OrdersManagedBean {

    @ManagedProperty(value = "#{userManagedBean}")
    private UserManagedBean usrMB;
    @EJB
    private CartService cartService;
    @EJB
    private OrdersService ordersService;
    @EJB
    private UserService userService;
    @EJB
    private ShippingService shippingService;
    private List<Cart> products_list;
    private List<Orders> consideringOrders;
    private List<Orders> consideredOrders;
    private List<Orders> deliveringOrders;
    private List<Orders> deliveredOrders;
    private Orders current_order = new Orders();
    private Orders accepted_order = new Orders();
    private boolean contact_info;
    private boolean check_box_name_enabled;
    private boolean check_box_surname_enabled;
    private boolean check_box_phone_enabled;
    private boolean check_box_email_enabled;
    private String new_contact_name;
    private String new_contact_surname;
    private String new_contact_phone;
    private String new_contact_email;
    private String totalPrice;
    private Integer sum_total = 0;
    private Integer cnt;
    private Integer price;
    private Integer total;
    private Integer res_total;
    private List<String> shipping_list;
    private String shipping_name;

    public void OrdersManagedBean() {
    }

    public void init(){
        String user_id = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("user_id");
        Integer id = new Integer(user_id);
        try {
            
            deliveringOrders = ordersService.getDeliveringOrders(userService.find(id));
            deliveredOrders = ordersService.getDeliveredOrders(userService.find(id));
        } catch (Exception e){
            e.getStackTrace();
        }
    }
    
    public String calculateTotalPrice() {
        List<Orders> lstProducts = ordersService.getConsideringOrders(usrMB.getCurrentUser());
        if (!lstProducts.isEmpty()) {
            for (Orders element : lstProducts) {
                cnt = element.getProduct_amount();
                price = Integer.parseInt(element.getProduct_price());
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

    public void redirectToProfile(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("newprofile.xhtml?user_id="+usrMB.getCurrentUser().getId().toString());

        } catch (IOException ex) {
            Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void confirmation(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("accept_order.xhtml?user_id="+usrMB.getCurrentUser().getId().toString());

        } catch (IOException ex) {
            Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void confirmOrder() {
        products_list = cartService.getByStatusProducts(getUsrMB().getCurrentUser(), "InCart");
        for (Cart element : products_list) {
                cnt = element.getCount();
                price = Integer.parseInt(element.getPrice());
                total = cnt * price;
                sum_total = total + sum_total;
                res_total = sum_total;
            }
            sum_total = 0;
            totalPrice = res_total.toString();
        for (Cart product : products_list) {
            getCurrent_order().setProduct_amount(product.getCount());
            getCurrent_order().setProduct_id(product.getProduct_id());
            getCurrent_order().setProduct_name(product.getName());
            getCurrent_order().setProduct_price(product.getPrice());
            getCurrent_order().setProduct_desc(product.getShortdesc());
            getCurrent_order().setImage(product.getImage());
            getCurrent_order().setOrder_date(java.util.Calendar.getInstance().getTime());
            getCurrent_order().setOrder_price(totalPrice);
            getCurrent_order().setOrder_status("Considering");
            getCurrent_order().setOwner(getUsrMB().getCurrentUser());
            ordersService.create(getCurrent_order());
            product.setStatus("Ordered");
            cartService.edit(product);
        }
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("accept_order.xhtml?user_id="+usrMB.getCurrentUser().getId().toString());

        } catch (IOException ex) {
            Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void completeOrder() {
        consideringOrders = ordersService.getConsideringOrders(usrMB.getCurrentUser());
        for (Orders order : consideringOrders) {
            if (contact_info) {
                order.setContact_email(usrMB.getCurrentUser().getEmail());
                order.setContact_name(usrMB.getCurrentUser().getName());
                order.setContact_surname(usrMB.getCurrentUser().getSurName());
                order.setContact_phone(usrMB.getCurrentUser().getPhone());
                order.setOrder_status("Contacting");
                order.setShipping(shippingService.getByName(shipping_name));
                ordersService.edit(order);
            } else {
                if (check_box_name_enabled) {
                    String name = current_order.getContact_name();
                    order.setContact_name(current_order.getContact_name());
                } else {
                    order.setContact_name(usrMB.getCurrentUser().getName());
                }
                if (check_box_surname_enabled) {
                    String suname = current_order.getContact_surname();
                    order.setContact_surname(current_order.getContact_surname());
                } else {
                    order.setContact_surname(usrMB.getCurrentUser().getSurName());
                }
                if (check_box_email_enabled) {
                    String email = current_order.getContact_email();
                    order.setContact_email(current_order.getContact_email());
                } else {
                    order.setContact_email(usrMB.getCurrentUser().getEmail());
                }
                if (check_box_phone_enabled) {
                    order.setContact_phone(current_order.getContact_phone());
                } else {
                    order.setContact_phone(usrMB.getCurrentUser().getPhone());
                }
                order.setShipping(shippingService.getByName(shipping_name));
                order.setOrder_status("Contacting");
                ordersService.edit(order);
            }
        }
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
     * @return the current_order
     */
    public Orders getCurrent_order() {
        return current_order;
    }

    /**
     * @param current_order the current_order to set
     */
    public void setCurrent_order(Orders current_order) {
        this.current_order = current_order;
    }

    /**
     * @return the contact_info
     */
    public boolean isContact_info() {
        return contact_info;
    }

    /**
     * @param contact_info the contact_info to set
     */
    public void setContact_info(boolean contact_info) {
        this.contact_info = contact_info;
    }

    /**
     * @return the check_box_name_enabled
     */
    public boolean isCheck_box_name_enabled() {
        return check_box_name_enabled;
    }

    /**
     * @param check_box_name_enabled the check_box_name_enabled to set
     */
    public void setCheck_box_name_enabled(boolean check_box_name_enabled) {
        this.check_box_name_enabled = check_box_name_enabled;
    }

    /**
     * @return the check_box_surname_enabled
     */
    public boolean isCheck_box_surname_enabled() {
        return check_box_surname_enabled;
    }

    /**
     * @param check_box_surname_enabled the check_box_surname_enabled to set
     */
    public void setCheck_box_surname_enabled(boolean check_box_surname_enabled) {
        this.check_box_surname_enabled = check_box_surname_enabled;
    }

    /**
     * @return the check_box_phone_enabled
     */
    public boolean isCheck_box_phone_enabled() {
        return check_box_phone_enabled;
    }

    /**
     * @param check_box_phone_enabled the check_box_phone_enabled to set
     */
    public void setCheck_box_phone_enabled(boolean check_box_phone_enabled) {
        this.check_box_phone_enabled = check_box_phone_enabled;
    }

    /**
     * @return the check_box_email_enabled
     */
    public boolean isCheck_box_email_enabled() {
        return check_box_email_enabled;
    }

    /**
     * @param check_box_email_enabled the check_box_email_enabled to set
     */
    public void setCheck_box_email_enabled(boolean check_box_email_enabled) {
        this.check_box_email_enabled = check_box_email_enabled;
    }

    /**
     * @return the new_contact_name
     */
    public String getNew_contact_name() {
        return new_contact_name;
    }

    /**
     * @param new_contact_name the new_contact_name to set
     */
    public void setNew_contact_name(String new_contact_name) {
        this.new_contact_name = new_contact_name;
    }

    /**
     * @return the new_contact_surname
     */
    public String getNew_contact_surname() {
        return new_contact_surname;
    }

    /**
     * @param new_contact_surname the new_contact_surname to set
     */
    public void setNew_contact_surname(String new_contact_surname) {
        this.new_contact_surname = new_contact_surname;
    }

    /**
     * @return the new_contact_phone
     */
    public String getNew_contact_phone() {
        return new_contact_phone;
    }

    /**
     * @param new_contact_phone the new_contact_phone to set
     */
    public void setNew_contact_phone(String new_contact_phone) {
        this.new_contact_phone = new_contact_phone;
    }

    /**
     * @return the new_contact_email
     */
    public String getNew_contact_email() {
        return new_contact_email;
    }

    /**
     * @param new_contact_email the new_contact_email to set
     */
    public void setNew_contact_email(String new_contact_email) {
        this.new_contact_email = new_contact_email;
    }

    /**
     * @return the accepted_order
     */
    public Orders getAccepted_order() {
        return accepted_order;
    }

    /**
     * @param accepted_order the accepted_order to set
     */
    public void setAccepted_order(Orders accepted_order) {
        this.accepted_order = accepted_order;
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
     * @return the shippingService
     */
    public ShippingService getShippingService() {
        return shippingService;
    }

    /**
     * @param shippingService the shippingService to set
     */
    public void setShippingService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    /**
     * @return the shipping_list
     */
    public List<String> getShipping_list() {
        shipping_list = shippingService.getAll();
        return shipping_list;
    }

    /**
     * @param shipping_list the shipping_list to set
     */
    public void setShipping_list(List<String> shipping_list) {
        this.shipping_list = shipping_list;
    }

    /**
     * @return the shipping_name
     */
    public String getShipping_name() {
        return shipping_name;
    }

    /**
     * @param shipping_name the shipping_name to set
     */
    public void setShipping_name(String shipping_name) {
        this.shipping_name = shipping_name;
    }

    /**
     * @return the consideredOrders
     */
    public List<Orders> getConsideredOrders() {
        consideredOrders = ordersService.getConsideringOrders(usrMB.getCurrentUser());
        return consideredOrders;
    }

    /**
     * @return the deliveringOrders
     */
    public List<Orders> getDeliveringOrders() {
        consideredOrders = ordersService.getDeliveringOrders(usrMB.getCurrentUser());
        return deliveringOrders;
    }

    /**
     * @return the deliveredOrders
     */
    public List<Orders> getDeliveredOrders() {
        consideredOrders = ordersService.getDeliveredOrders(usrMB.getCurrentUser());
        return deliveredOrders;
    }
}
