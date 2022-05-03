package com.terzo.assetmanagement.service;

import com.terzo.assetmanagement.entity.User;
import com.terzo.assetmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public List<User> findAll()
    {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<User> findById(int theId)
    {

        //optional => different pattern instead of having to check for nulls

        Optional<User> result = userRepository.findById(theId);

        User res = null;

        if(result.isPresent()) {
            res= result.get();
        }
        else{
            //we didn't find the employee

            throw new RuntimeException("Did not find employee id - " + theId);
        }
        return result;
    }

    @Override
    @Transactional
    public void save(User user)
    {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteById(int theId)
    {
        userRepository.deleteById(theId);
    }
}
