package WebEcommerce.Model;

import java.util.Date;

public class StyleModel {
    private int _id;
    private String name;
    private int caId;
    private boolean isDelete;
    private Date createdAt;
    private Date updatedAt;

    public StyleModel() {
    }

    public StyleModel(int _id, String name, int caId, boolean isDelete, Date createdAt, Date updatedAt) {
        this._id = _id;
        this.name = name;
        this.caId = caId;
        this.isDelete = isDelete;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public int getCaId() {
        return caId;
    }

    public void setCaId(int caId) {
        this.caId = caId;
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
