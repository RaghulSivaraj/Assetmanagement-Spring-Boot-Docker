package com.terzo.assetmanagement.service;

import com.terzo.assetmanagement.entity.Asset;
import com.terzo.assetmanagement.entity.User;
import com.terzo.assetmanagement.repository.AssetHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AssetHistoryImplementation implements AssetHistoryService{
    @Autowired
    private AssetHistoryRepository assetHistoryRepository;
    @Override
    public void addAsset(String type, int quantity) {
//        user.getAssets().add(asset);
//        asset.getUser().add(user);
//        assetHistoryRepository.save(type);
//        assetHistoryRepository.save(type);

    }
}
