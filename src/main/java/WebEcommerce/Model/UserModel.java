package WebEcommerce.Model;

import java.util.Date;

public class UserModel {

    private int _id;
    private int fistName;
    private int lastName;
    private int slug;
    private int id_card;
    private int email;
    private int phone;
    private boolean isEmalActive;
    private boolean isPhoneActive;
    private String salt;
    private String hashed_password;
    private String role;
    private String address;
    private String avatar;
    private String cover;
    private int point;
    private int e_wallet;
    private Date createdAt;
    private Date updatedAt;

    public UserModel(int _id, int fistName, int lastName, int slug, int id_card, int email, int phone, boolean isEmalActive, boolean isPhoneActive, String salt, String hashed_password, String role, String address, String avatar, String cover, int point, int e_wallet, Date createdAt, Date updatedAt) {
        this._id = _id;
        this.fistName = fistName;
        this.lastName = lastName;
        this.slug = slug;
        this.id_card = id_card;
        this.email = email;
        this.phone = phone;
        this.isEmalActive = isEmalActive;
        this.isPhoneActive = isPhoneActive;
        this.salt = salt;
        this.hashed_password = hashed_password;
        this.role = role;
        this.address = address;
        this.avatar = avatar;
        this.cover = cover;
        this.point = point;
        this.e_wallet = e_wallet;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UserModel() {
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getFistName() {
        return fistName;
    }

    public void setFistName(int fistName) {
        this.fistName = fistName;
    }

    public int getLastName() {
        return lastName;
    }

    public void setLastName(int lastName) {
        this.lastName = lastName;
    }

    public int getSlug() {
        return slug;
    }

    public void setSlug(int slug) {
        this.slug = slug;
    }

    public int getId_card() {
        return id_card;
    }

    public void setId_card(int id_card) {
        this.id_card = id_card;
    }

    public int getEmail() {
        return email;
    }

    public void setEmail(int email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public boolean isEmalActive() {
        return isEmalActive;
    }

    public void setEmalActive(boolean emalActive) {
        isEmalActive = emalActive;
    }

    public boolean isPhoneActive() {
        return isPhoneActive;
    }

    public void setPhoneActive(boolean phoneActive) {
        isPhoneActive = phoneActive;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHashed_password() {
        return hashed_password;
    }

    public void setHashed_password(String hashed_password) {
        this.hashed_password = hashed_password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
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
