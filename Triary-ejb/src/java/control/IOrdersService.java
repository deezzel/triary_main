/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import model.Orders;


/**
 *
 * @author kate
 */
public interface IOrdersService {
    public List<Orders> getAll();
}
