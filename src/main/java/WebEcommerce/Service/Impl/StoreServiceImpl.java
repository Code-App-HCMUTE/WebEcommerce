package WebEcommerce.Service.Impl;

import java.util.List;

import WebEcommerce.Dao.StoreDao;
import WebEcommerce.Dao.Impl.StoreDaoImpl;
import WebEcommerce.Model.StoreModel;
import WebEcommerce.Model.UserModel;
import WebEcommerce.Service.StoreService;

public class StoreServiceImpl implements StoreService {
	StoreDao storeDao=new StoreDaoImpl();
	@Override
	public List<StoreModel> getStore(int id) {
		// TODO Auto-generated method stub
		return storeDao.getStore(id);
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
		storeDao.editStore(store);
	}

	@Override
	public UserModel getOwnerStore() {
		return storeDao.getOwnerStore();
	}

	@Override
	public int countStaffInStore() {
		return storeDao.countStaffInStore();
	}

	@Override
	public void updateStaffStore(int id) {
		storeDao.updateStaffStore(id);
	}

	@Override
	public UserModel getStaff() {
		// TODO Auto-generated method stub
		return storeDao.getStaff();
	}

	@Override
	public void Ruttien(int sotien) {
		storeDao.Ruttien(sotien);
	}

	@Override
	public StoreModel getStoreByName(String name) {
		// TODO Auto-generated method stub
		return storeDao.getStoreByName(name);
	}

}
