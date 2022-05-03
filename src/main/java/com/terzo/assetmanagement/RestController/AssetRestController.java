package com.terzo.assetmanagement.RestController;

import com.terzo.assetmanagement.entity.Asset;
import com.terzo.assetmanagement.entity.User;
import com.terzo.assetmanagement.exception.NotFoundException;
import com.terzo.assetmanagement.service.AssetService;
import com.terzo.assetmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/assetmanagement")
public class AssetRestController {

    @Autowired
    private AssetService assetService;


    @Autowired
    private UserService userService;


    private int assetQuantity;

    private int userQuantity;

    private String type;

    private String createdOn;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd" );
    Date getCreatedOn = new Date();

    @Autowired
    public AssetRestController(){
    }

    @GetMapping("/asset/all")
    public List<Asset> getAssetFull() {
        return assetService.findAll();
    }



    @GetMapping("/asset/{Id}")
    public Optional<Asset> getAsset(@PathVariable int Id) {

        Optional<Asset> theAsset = assetService.findById(Id);

        if (theAsset.isEmpty()) {
            throw new RuntimeException("Asset id not found - " + Id);
        }

        return theAsset;
    }


    @PostMapping("/asset")
    public Asset addAsset(@RequestBody Asset theAsset) {

        theAsset.setAssetId(0);

        assetService.save(theAsset);

        return theAsset;
    }


    @PutMapping("/asset/{id}")
    public Asset updateAsset( @PathVariable int id, @RequestBody Asset theAssets) {

        Optional<Asset> asset = assetService.findById(id);
        if(asset.isEmpty()) {
            throw new RuntimeException("Asset Id not found " +id);
        }
        theAssets.setAssetId(id);
        assetService.save(theAssets);
        return theAssets;
    }



    @DeleteMapping("/asset/{Id}")
    public String deleteAsset(@PathVariable int Id) {

        Optional<Asset> tempAsset = assetService.findById(Id);

        // throw exception if null

        if (tempAsset.isEmpty()) {
            throw new RuntimeException("Asset id not found - " + Id);
        }

        assetService.deleteById(Id);

        return "Deleted Asset id - " + Id;
    }
    @PutMapping("/asset/purchase/{asset_id}/{user_id}/{quantity}")
    public String purchase(@PathVariable int asset_id,@PathVariable int user_id,@PathVariable int quantity){

        Optional<Asset> theAsset = assetService.findById(asset_id);
        Optional<User> theUser = userService.findById(user_id);
        Asset asset = theAsset.get();
        User user = theUser.get();
        createdOn= formatter.format(getCreatedOn);
        // get a quantity from asset table
        assetQuantity = asset.getQuantity();


        if(theAsset.isEmpty()){
            throw new NotFoundException("Asset ID Not Found");
        }

        if(theUser.isEmpty()) {
            throw new NotFoundException("User ID Not Found");
        }

        if(quantity >assetQuantity ){
            throw new NotFoundException("Required number of quantity is not available to allocate ");
        }


        // After reducing the original quantity
        assetQuantity = assetQuantity-quantity;
        asset.setQuantity(assetQuantity);
        type = "purchase";

        assetService.addAsset(user , asset);

        return "User ID - "+user_id+" successfully purchase the Asset ID - "+ asset_id;
    }
    @PutMapping("/asset/return/{asset_id}/{user_id}/{quantity}")
    public String returned(@PathVariable int asset_id,@PathVariable int user_id,@PathVariable int quantity) {

        Optional<Asset> theAsset = assetService.findById(asset_id);
        Optional<User> theUser = userService.findById(user_id);
        Asset asset = theAsset.get();
        User user = theUser.get();

        if (theAsset.isEmpty()) {
            throw new NotFoundException("Asset ID Not Found");
        }

        if (theUser.isEmpty()) {
            throw new NotFoundException("User ID Not Found");
        }

        // get a quantity from asset table
        assetQuantity = asset.getQuantity(); //original quantity

        if (quantity < 0) {
            throw new NotFoundException("Required number of quantity is not available to allocate ");
        }

        // After reducing the original quantity
        assetQuantity += quantity;
        asset.setQuantity(assetQuantity);
        assetService.removeAsset(user, asset);

        return "User ID - " + user_id + " successfully returned the quantity - " + quantity + " to Asset ID - " + asset_id;

    }


}