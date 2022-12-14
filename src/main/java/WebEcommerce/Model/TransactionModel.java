package WebEcommerce.Model;

import java.util.Date;

public class TransactionModel {
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
	 * @return the isUp
	 */
	public boolean getIsUp() {
        return isUp;
    }

    public void setIsUp(boolean up) {
        this.isUp = up;
    }
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
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
	private boolean isUp;
	private int amount;
	private Date createdAt;
	private Date updatedAt;
	public TransactionModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransactionModel(int id, int userId, int storeId, boolean isUp, int amount, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.userId = userId;
		this.storeId = storeId;
		this.isUp = isUp;
		this.amount = amount;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
}
