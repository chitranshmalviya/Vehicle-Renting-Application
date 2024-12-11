package com.example.vra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vra.entity.User;

@Repository
 public interface UserRepository extends JpaRepository<User, Integer>{

}
