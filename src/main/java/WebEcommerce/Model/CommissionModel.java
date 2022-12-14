package WebEcommerce.Model;

import java.util.Date;

public class CommissionModel {
    private int _id;
    private String name;
    private double cost;
    private String description;
    private boolean isDelete;
    private Date createdAt;
    private Date updatedAt;

    public CommissionModel(int _id, String name, double cost, String description, boolean isDelete, Date createdAt, Date updatedAt) {
        this._id = _id;
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.isDelete = isDelete;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public CommissionModel() {
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean delete) {
        isDelete = delete;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
