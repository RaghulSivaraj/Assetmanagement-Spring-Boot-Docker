package com.terzo.assetmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="user_id")
    private int userId;

    @Column(name="username")
    private String userName;

    @ManyToMany(
            fetch=FetchType.LAZY,
            mappedBy = "user",
            cascade= {CascadeType.MERGE , CascadeType.PERSIST ,CascadeType.DETACH ,CascadeType.REFRESH})
    @JsonIgnoreProperties("user")
    private List<Asset> assets = new ArrayList<>();

    public User() {

    }

    public User(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> asset) {
        this.assets = asset;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName=" + userName +
                '}';
    }
}
