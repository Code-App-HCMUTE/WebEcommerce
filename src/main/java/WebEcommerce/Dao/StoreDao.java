package WebEcommerce.Dao;

import java.util.List;

import WebEcommerce.Model.StoreModel;

public interface StoreDao {
	List<StoreModel> getAllStore();
	void insertStore(StoreModel store);
	StoreModel getStoreById(int id);
	void editStore(StoreModel store);
	List<StoreModel> search(String query,int size,int index);
}
