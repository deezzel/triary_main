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
public interface IProductService {
    public List<Product> getAll();
    
    public byte[] getImage(Integer product_id);
    
    public List<Product> getFromCart(Users usr);

    public void decreaseAmount(Product product, Integer amount);
    
    public void increaseAmount(Product product, Integer amount);
}
