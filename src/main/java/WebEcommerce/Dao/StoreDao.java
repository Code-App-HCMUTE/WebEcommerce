package WebEcommerce.Dao;

import java.util.List;

import WebEcommerce.Model.StoreModel;
import WebEcommerce.Model.UserModel;

public interface StoreDao {
	List<StoreModel> getAllStore();
	void insertStore(StoreModel store);
	StoreModel getStoreById(int id);
	void editStore(StoreModel store);
	UserModel getOwnerStore();
	int countStaffInStore();
	void updateStaffStore(int id);
	UserModel getStaff();
	void Ruttien(int sotien);
}
