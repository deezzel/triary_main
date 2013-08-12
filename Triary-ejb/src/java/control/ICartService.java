/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import model.Cart;
import model.Product;
import model.Users;

/**
 *
 * @author kate
 */
public interface ICartService {
    public List<Cart> getAll();
    public List<Cart> getByStatusProducts(Users usr, String status);
    public boolean addToCart(Product prod, Cart cart, Users usr, Integer count);
    public String calculateTotalPrice(List<Cart> products);
}
