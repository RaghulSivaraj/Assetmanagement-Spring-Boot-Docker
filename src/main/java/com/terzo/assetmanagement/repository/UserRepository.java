package com.terzo.assetmanagement.repository;

import com.terzo.assetmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
