package com.terzo.assetmanagement.service;

import com.terzo.assetmanagement.entity.Asset;
import com.terzo.assetmanagement.entity.User;

import java.util.List;
import java.util.Optional;

public interface AssetService {

    public List<Asset> findAll();

    public Optional<Asset>findById(int theId);

    public void save(Asset asset);

    public void deleteById(int theId);

    public void addAsset(User user, Asset asset);

    public void removeAsset(User user, Asset asset );


}
