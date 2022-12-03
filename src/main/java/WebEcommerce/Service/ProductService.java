package WebEcommerce.Service;

import java.util.List;

import WebEcommerce.Model.ProductModel;

public interface ProductService {
	List<ProductModel> findAll();
    ProductModel get(int id);
    void edit(ProductModel product);
    void insert(ProductModel product);
    void delete(int id);
}
