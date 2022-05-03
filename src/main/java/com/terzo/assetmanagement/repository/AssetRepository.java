package com.terzo.assetmanagement.repository;

import com.terzo.assetmanagement.entity.Asset;
import com.terzo.assetmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AssetRepository extends JpaRepository<Asset,Integer> {

}
