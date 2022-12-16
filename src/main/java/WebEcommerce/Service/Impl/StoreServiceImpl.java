package WebEcommerce.Service.Impl;

import java.util.List;

import WebEcommerce.Dao.StoreDao;
import WebEcommerce.Dao.Impl.StoreDaoImpl;
import WebEcommerce.Model.StoreModel;
import WebEcommerce.Model.UserModel;
import WebEcommerce.Service.StoreService;

public class StoreServiceImpl implements StoreService {
	StoreDao storeDao=new StoreDaoImpl();
	public List<StoreModel> getAllStore(){
		return storeDao.getAllStore();
	}
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

	@Override
	public void deleteStore(int id) {
		storeDao.deleteStore(id);
	}

	@Override
	public List<StoreModel> search(String query, int size, int index) {
		return storeDao.search(query,size,index
		);
	}

}
