package WebEcommerce.Model;

import java.util.Date;

public class UserLevelModel {
    private int id;
    private String name;
    private int minPoint;
    private int discount;
    private boolean isDeleted;
    private Date createdAt;
    private Date updatedAt;

    public UserLevelModel() {
    }

    public UserLevelModel(int id, String name, int minPoint, int discount, boolean isDeleted, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.minPoint = minPoint;
        this.discount = discount;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinPoint() {
        return minPoint;
    }

    public void setMinPoint(int minPoint) {
        this.minPoint = minPoint;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean deleted) {
        isDeleted = deleted;
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
