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
		// TODO Auto-generated method stub

		return productDao.get(id);
	}

	@Override
	public void edit(ProductModel product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(ProductModel product) {
		productDao.insert(product);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductModel> search(String query,int size,int index) {
		return productDao.search(query,size,index);
	}

	@Override
	public int SearchCount(String query) {
		return productDao.SearchCount(query);
	}

}
