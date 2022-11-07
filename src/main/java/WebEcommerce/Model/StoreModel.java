package WebEcommerce.Model;

import java.util.Date;
import java.util.List;

public class StoreModel {

    private int _id;
    private String name;
    private String bio;
    private String slug;
    private int ownerId;
    private List staffIds;
    private boolean isActive;
    private boolean isOpen;
    private String avatar;
    private String cover;
    private List featured_images;
    private int commissionId;
    private int point;
    private int rating;
    private int e_wallet;
    private Date createdAt;
    private Date updatedAt;

    public StoreModel() {
    }

    public StoreModel(int _id, String name, String bio, String slug, int ownerId, List staffIds, boolean isActive, boolean isOpen, String avatar, String cover, List featured_images, int commissionId, int point, int rating, int e_wallet, Date createdAt, Date updatedAt) {
        this._id = _id;
        this.name = name;
        this.bio = bio;
        this.slug = slug;
        this.ownerId = ownerId;
        this.staffIds = staffIds;
        this.isActive = isActive;
        this.isOpen = isOpen;
        this.avatar = avatar;
        this.cover = cover;
        this.featured_images = featured_images;
        this.commissionId = commissionId;
        this.point = point;
        this.rating = rating;
        this.e_wallet = e_wallet;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public List getStaffIds() {
        return staffIds;
    }

    public void setStaffIds(List staffIds) {
        this.staffIds = staffIds;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public List getFeatured_images() {
        return featured_images;
    }

    public void setFeatured_images(List featured_images) {
        this.featured_images = featured_images;
    }

    public int getCommissionId() {
        return commissionId;
    }

    public void setCommissionId(int commissionId) {
        this.commissionId = commissionId;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getE_wallet() {
        return e_wallet;
    }

    public void setE_wallet(int e_wallet) {
        this.e_wallet = e_wallet;
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
