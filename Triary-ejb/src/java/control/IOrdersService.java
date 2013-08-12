/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import model.Orders;
import model.Users;


/**
 *
 * @author kate
 */
public interface IOrdersService {
    public List<Orders> getAll();
    public List<Orders> getConsideringOrders(Users usr);
    public List<Orders> getDeliveringOrders(Users usr);
    public List<Orders> getDeliveredOrders(Users usr);
}
