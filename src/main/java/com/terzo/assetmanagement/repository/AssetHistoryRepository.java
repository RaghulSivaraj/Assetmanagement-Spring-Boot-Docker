package com.terzo.assetmanagement.repository;

import com.terzo.assetmanagement.entity.Asset;
import com.terzo.assetmanagement.entity.AssetHistory;
import com.terzo.assetmanagement.entity.AssetHistoryIdentity;
import com.terzo.assetmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface AssetHistoryRepository extends JpaRepository<AssetHistory, AssetHistoryIdentity> {

//       @Modifying
//       @Query(value = "insert into Assethistory(type,quantity) VALUES (:type,:quantity)", nativeQuery = true)
//       @Transactional
//       void addAttributes(@Param("type") String type,@Param("quantity") int quantity);
}
