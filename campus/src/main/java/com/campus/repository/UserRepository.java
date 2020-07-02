package com.campus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campus.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
