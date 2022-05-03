package com.terzo.assetmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "Asset")
public class Asset {
    //define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asset_id")
    private int assetId;
    @Column(name = "asset_name")
    private String assetName;

    @Column(name = "asset_type")
    private String assetType;

    @Column(name = "quantity")
    private int quantity ;
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name = "assethistory",
            joinColumns =@JoinColumn(name = "asset_id"),
            inverseJoinColumns =@JoinColumn(name = "user_id")
    )
    @JsonIgnoreProperties("assets")
    private List<User> user = new ArrayList<>();


    public Asset(){
    }

    public Asset(String assetName, String assetType, int quantity) {
        this.assetName = assetName;
        this.assetType = assetType;
        this.quantity = quantity;
    }

    public int getAssetId() {
        return assetId;
    }

    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "assetId=" + assetId +
                ", assetName='" + assetName + '\'' +
                ", assetType='" + assetType + '\'' +
                ", quantity=" + quantity +
                '}';
    }

}