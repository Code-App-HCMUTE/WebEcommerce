package WebEcommerce.Model;

import java.util.Date;

public class OrderModel {
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the storeId
	 */
	public int getStoreId() {
		return storeId;
	}
	/**
	 * @param storeId the storeId to set
	 */
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	/**
	 * @return the deliveryId
	 */
	public int getDeliveryId() {
		return deliveryId;
	}
	/**
	 * @param deliveryId the deliveryId to set
	 */
	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}
	/**
	 * @return the commissionId
	 */
	public int getCommissionId() {
		return commissionId;
	}
	/**
	 * @param commissionId the commissionId to set
	 */
	public void setCommissionId(int commissionId) {
		this.commissionId = commissionId;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the isPaidBefore
	 */
	public boolean isPaidBefore() {
		return isPaidBefore;
	}
	/**
	 * @param isPaidBefore the isPaidBefore to set
	 */
	public void setPaidBefore(boolean isPaidBefore) {
		this.isPaidBefore = isPaidBefore;
	}
	/**
	 * @return the amountFromUser
	 */
	public int getAmountFromUser() {
		return amountFromUser;
	}
	/**
	 * @param amountFromUser the amountFromUser to set
	 */
	public void setAmountFromUser(int amountFromUser) {
		this.amountFromUser = amountFromUser;
	}
	/**
	 * @return the amountFromStore
	 */
	public int getAmountFromStore() {
		return amountFromStore;
	}
	/**
	 * @param amountFromStore the amountFromStore to set
	 */
	public void setAmountFromStore(int amountFromStore) {
		this.amountFromStore = amountFromStore;
	}
	/**
	 * @return the amountToStore
	 */
	public int getAmountToStore() {
		return amountToStore;
	}
	/**
	 * @param amountToStore the amountToStore to set
	 */
	public void setAmountToStore(int amountToStore) {
		this.amountToStore = amountToStore;
	}
	/**
	 * @return the amountToGD
	 */
	public int getAmountToGD() {
		return amountToGD;
	}
	/**
	 * @param amountToGD the amountToGD to set
	 */
	public void setAmountToGD(int amountToGD) {
		this.amountToGD = amountToGD;
	}
	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}
	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	private int id;
	private int userId;
	private int storeId;
	private int deliveryId;
	private int commissionId;
	private String address;
	private String phone;
	private String status;
	private boolean isPaidBefore;
	private int amountFromUser;
	private int amountFromStore;
	private int amountToStore;
	private int amountToGD;
	private Date createdAt;
	private Date updatedAt;
	public OrderModel(int id, int userId, int storeId, int deliveryId, int commissionId, String address, String phone,
			String status, boolean isPaidBefore, int amountFromUser, int amountFromStore, int amountToStore,
			int amountToGD, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.userId = userId;
		this.storeId = storeId;
		this.deliveryId = deliveryId;
		this.commissionId = commissionId;
		this.address = address;
		this.phone = phone;
		this.status = status;
		this.isPaidBefore = isPaidBefore;
		this.amountFromUser = amountFromUser;
		this.amountFromStore = amountFromStore;
		this.amountToStore = amountToStore;
		this.amountToGD = amountToGD;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public OrderModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
