package WebEcommerce.Service.Impl;

import java.util.List;

import WebEcommerce.Dao.StoreDao;
import WebEcommerce.Dao.Impl.StoreDaoImpl;
import WebEcommerce.Model.StoreModel;
import WebEcommerce.Service.StoreService;

public class StoreServiceImpl implements StoreService {
	StoreDao storeDao=new StoreDaoImpl();
	@Override
	public List<StoreModel> getAllStore() {
		// TODO Auto-generated method stub
		return storeDao.getAllStore();
	}

	@Override
	public void insertStore(StoreModel store) {
		storeDao.insertStore(store);
	}

	@Override
	public StoreModel getStoreById(int id) {
		// TODO Auto-generated method stub
		return storeDao.getStoreById(id);
	}

	@Override
	public void editStore(StoreModel store) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<StoreModel> search(String query, int size, int index) {
		return null;
	}

}
