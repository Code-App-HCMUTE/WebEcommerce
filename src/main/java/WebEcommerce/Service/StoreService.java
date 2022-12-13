package WebEcommerce.Service;

import java.util.List;

import WebEcommerce.Model.StoreModel;
import WebEcommerce.Model.UserModel;

public interface StoreService {
	List<StoreModel> getAllStore();
	void insertStore(StoreModel store);
	StoreModel getStoreById(int id);
	void editStore(StoreModel store);
	UserModel getOwnerStore();
	int countStaffInStore();
	void updateStaffStore(int id);
	UserModel getStaff();
}
