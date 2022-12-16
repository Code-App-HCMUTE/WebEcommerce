package WebEcommerce.Dao;


import WebEcommerce.Model.ProductModel;

import java.util.Date;
import java.util.List;

public interface ProductDao {
    List<ProductModel> findAll();
    ProductModel get(int id);
    void edit(ProductModel product);
    void insert(ProductModel product);
    void delete(int id);
    List<ProductModel> getAllProductIsActive();
    List<ProductModel> getAllProductUnActive();
    List<ProductModel> getAllProductNoQuantity();
    List<ProductModel> getAllProductQuantity();
    List<ProductModel> searchProduct(String txtSearch);
    List<ProductModel> search(String query,int size,int index);
    int CountProduct(String txt);
    int countProductByDate(Date date);
    int countAll();
    ProductModel getTop1Sold();
}
