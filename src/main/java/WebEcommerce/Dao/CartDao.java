package WebEcommerce.Dao;

import WebEcommerce.Model.CartModel;
import WebEcommerce.Model.ProductModel;

import java.util.List;

public interface CartDao {

    void addToCart(CartModel cart);
    List<ProductModel> ListItemOfUser(int id);
    void update(CartModel cart);
    void delete(int id);
}
