package WebEcommerce.Service.Impl;

import WebEcommerce.Dao.CategoryDao;
import WebEcommerce.Dao.Impl.CategoryDaoImpl;
import WebEcommerce.Model.CategoryModel;
import WebEcommerce.Service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<CategoryModel> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public CategoryModel get(int id) {
        return categoryDao.get(id);
    }

    @Override
    public void edit(CategoryModel category) {
        categoryDao.edit(category);
    }

    @Override
    public void insert(CategoryModel category) {
        categoryDao.insert(category);
    }

    @Override
    public void delete(int id) {
        categoryDao.delete(id);
    }
}
