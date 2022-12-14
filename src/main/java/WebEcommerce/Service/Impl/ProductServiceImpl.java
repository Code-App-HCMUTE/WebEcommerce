package WebEcommerce.Service.Impl;

import java.util.List;

import WebEcommerce.Dao.ProductDao;
import WebEcommerce.Dao.Impl.ProductDaoImpl;
import WebEcommerce.Model.ProductModel;
import WebEcommerce.Service.ProductService;

public class ProductServiceImpl implements ProductService{
	ProductDao productDao=new ProductDaoImpl();
	@Override
	public List<ProductModel> findAll() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	@Override
	public ProductModel get(int id) {
		return productDao.get(id);
	}

	@Override
	public void edit(ProductModel product) {
		productDao.edit(product);
		
	}

	@Override
	public void insert(ProductModel product) {
		productDao.insert(product);
	}

	@Override
	public void delete(int id) {
		productDao.delete(id);
	}

	@Override
	public List<ProductModel> getAllProductIsActive() {
		// TODO Auto-generated method stub
		return productDao.getAllProductIsActive();
	}

	@Override
	public List<ProductModel> getAllProductUnActive() {
		// TODO Auto-generated method stub
		return productDao.getAllProductUnActive();
	}

	@Override
	public List<ProductModel> getAllProductNoQuantity() {
		// TODO Auto-generated method stub
		return productDao.getAllProductNoQuantity();
	}

	@Override
	public List<ProductModel> getAllProductQuantity() {
		// TODO Auto-generated method stub
		return productDao.getAllProductQuantity();
	}

	@Override
	public List<ProductModel> searchProduct(String txtSearch) {
		// TODO Auto-generated method stub
		return productDao.searchProduct(txtSearch);
	}

	@Override
	public List<ProductModel> search(String query, int size, int index) {
		// TODO Auto-generated method stub
		return productDao.search(query, size, index);
	}

	@Override
	public int CountProduct(String txt) {
		// TODO Auto-generated method stub
		return productDao.CountProduct(txt);
	}

}
