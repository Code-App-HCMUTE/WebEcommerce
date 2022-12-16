package WebEcommerce.Service.Impl;

import WebEcommerce.Dao.CartDao;
import WebEcommerce.Dao.Impl.CartDaoImpl;
import WebEcommerce.Model.CartModel;
import WebEcommerce.Model.ProductModel;
import WebEcommerce.Service.CartService;

import java.util.List;

public class CartServiceImpl implements CartService {
    CartDao dao = new CartDaoImpl();
    @Override
    public void addToCart(CartModel cart) {
        dao.addToCart(cart);
    }

    @Override
    public List<ProductModel> ListItemOfUser(int id) {
        return dao.ListItemOfUser(id);
    }

    @Override
    public void update(CartModel cart) {
        dao.update(cart);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}
