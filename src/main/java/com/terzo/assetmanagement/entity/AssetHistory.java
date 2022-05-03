package com.terzo.assetmanagement.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity(name = "assethistory")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "assethistory")
public class AssetHistory {
    @EmbeddedId
    private AssetHistoryIdentity assetHistoryIdentity;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "type")
    private String type;
    @Column(name = "createdOn")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createdOn = new Date(System.currentTimeMillis());



//    public AssetHistory() {
//
//    }
//
//    public AssetHistory(AssetHistoryIdentity assetHistoryIdentity, int quantity, String type, Date createdOn) {
//        this.assetHistoryIdentity = assetHistoryIdentity;
//        this.quantity = quantity;
//        this.type = type;
//        this.createdOn = createdOn;
//    }
//
//    public AssetHistoryIdentity getAssetHistoryIdentity() {
//        return assetHistoryIdentity;
//    }
//
//    public void setAssetHistoryIdentity(AssetHistoryIdentity assetHistoryIdentity) {
//        this.assetHistoryIdentity = assetHistoryIdentity;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public Date getCreatedOn() {
//        return createdOn;
//    }
//
//    public void setCreatedOn(Date createdOn) {
//        this.createdOn = createdOn;
//    }
}