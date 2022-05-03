package com.terzo.assetmanagement.service;

import com.terzo.assetmanagement.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> findAll() ;

    public Optional<User> findById(int theId);

    public void save(User user);

    public void deleteById(int theId);
}
