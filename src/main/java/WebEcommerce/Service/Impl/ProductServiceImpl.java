package WebEcommerce.Service.Impl;

import java.util.Date;
import java.util.List;

import WebEcommerce.Dao.ProductDao;
import WebEcommerce.Dao.Impl.ProductDaoImpl;
import WebEcommerce.Model.ProductModel;
import WebEcommerce.Service.ProductService;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao = new ProductDaoImpl();

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

    @Override
    public int countProductByDate(Date date) {
        // TODO Auto-generated method stub
        return productDao.countProductByDate(date);
    }

    @Override
    public int countAll() {
        // TODO Auto-generated method stub
        return productDao.countAll();
    }

    @Override
    public ProductModel getTop1Sold() {
        // TODO Auto-generated method stub
        return productDao.getTop1Sold();
    }


    @Override
    public int SearchCount(String query, String sql) {
        return productDao.SearchCount(query, sql);
    }

    @Override
    public List<ProductModel> productByCat(int catId, int size, int index) {
        return productDao.productByCat(catId, size, index);
    }


    //	hieu sin
    @Override
    public List<ProductModel> findAllByStore() {
        // TODO Auto-generated method stub
        return productDao.findAllByStore();
    }

    @Override
    public ProductModel getByStore(int id) {
        return productDao.getByStore(id);
    }

    @Override
    public void editByStore(ProductModel product) {
        productDao.editByStore(product);

    }

    @Override
    public void insertByStore(ProductModel product) {
        productDao.insertByStore(product);
    }

    @Override
    public void deleteByStore(int id) {
        productDao.deleteByStore(id);
    }

    @Override
    public List<ProductModel> searchByStore(String query, int size, int index) {
        // TODO Auto-generated method stub
        return productDao.searchByStore(query, size, index);
    }

}
