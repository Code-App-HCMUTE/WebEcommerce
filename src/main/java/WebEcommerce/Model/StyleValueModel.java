package WebEcommerce.Model;

import java.util.Date;

public class StyleValueModel {
    private int _id;
    private String name;
    private int styleId;
    private boolean isDelete;
    private Date createdAt;
    private Date updatedAt;

    public StyleValueModel()
    {}

    public StyleValueModel(int id, String name, int styleId, boolean isDelete, Date createdAt, Date updatedAt) {
        this._id = id;
        this.name = name;
        this.styleId = styleId;
        this.isDelete = isDelete;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        _id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStyleId() {
        return styleId;
    }

    public void setStyleId(int styleId) {
        this.styleId = styleId;
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
