package com.terzo.assetmanagement.service;

import com.terzo.assetmanagement.entity.Asset;
import com.terzo.assetmanagement.entity.User;
import com.terzo.assetmanagement.repository.AssetHistoryRepository;
import com.terzo.assetmanagement.repository.AssetRepository;
import com.terzo.assetmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.management.Query;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AssetServiceImplementation implements AssetService{

    @Autowired
    private AssetRepository assetRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AssetHistoryRepository assetHistoryRepository;

    @Override
    @Transactional
    public List<Asset> findAll()
    {
        return assetRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Asset> findById(int theId) {
        Optional<Asset> res;

        //optional => different pattern instead of having to check for nulls

        Optional<Asset> result = assetRepository.findById(theId);


        if (result.isPresent()) {
            res = result;
        } else {
            //we didn't find the employee

            throw new RuntimeException("Did not find employee id - " + theId);
        }
        return res;
    }

    @Override
    @Transactional
    public void save(Asset asset)
    {
        assetRepository.save(asset);
    }

    @Override
    @Transactional
    public void deleteById(int theId)
    {
        assetRepository.deleteById(theId);
    }

    @Override
    @Transactional
    public void addAsset(User user, Asset asset)
    {
        user.getAssets().add(asset);
        asset.getUser().add(user);
        userRepository.save(user);
        assetRepository.save(asset);

    }
    @Override
    @Transactional
    public void removeAsset(User user, Asset asset )
    {

        if(asset.getQuantity() < 1)
        {
            user.getAssets().remove(asset);
            asset.getUser().remove(user);
        }

        userRepository.save(user);
        assetRepository.save(asset);
    }
}