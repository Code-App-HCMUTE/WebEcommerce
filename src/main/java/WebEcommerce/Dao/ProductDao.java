package WebEcommerce.Dao;

import WebEcommerce.Model.CategoryModel;
import WebEcommerce.Model.ProductModel;

import java.util.List;

public interface ProductDao {

    List<ProductModel> findAll();

    ProductModel get(int id);

    void edit(ProductModel product);
    void insert(ProductModel product);
    void delete(int id);
}
