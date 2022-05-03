package com.terzo.assetmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AssetHistoryIdentity implements Serializable {
    @Column(name = "asset_id",nullable = false)
    private Integer asset_id;
    @Column(name = "user_id",nullable = false)
    private Integer user_id;

//    public AssetHistoryIdentity() {
//
//    }
//
//    public AssetHistoryIdentity(int asset_id, int user_id) {
//        this.asset_id = asset_id;
//        this.user_id = user_id;
//    }
//
//    public int getAsset_id() {
//        return asset_id;
//    }
//
//    public void setAsset_id(int asset_id) {
//        this.asset_id = asset_id;
//    }
//
//    public int getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(int user_id) {
//        this.user_id = user_id;
//    }
//
    //equals() method is used to compare the equivalence between two objects.

    @Override
    public boolean equals(Object o) {
        //Compares memory addresses of the owner and the parameter object
        if (this == o) return true;
        //Checks the nullability of the parameter and compares the class type of the owner and the parameter
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AssetHistoryIdentity that = (AssetHistoryIdentity) o;
        return Objects.equals(asset_id, that.asset_id)
                && Objects.equals(user_id, that.user_id);
    }
    // hashCode() method is used to generate the object's hash code which is used to properly
    // distribute entries across hash table based collections
    @Override
    public int hashCode() {
        return Objects.hash(asset_id, user_id);
    }
}