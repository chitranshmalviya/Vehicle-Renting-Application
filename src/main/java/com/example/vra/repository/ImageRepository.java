package com.example.vra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vra.entity.Image;
import com.example.vra.service.UserService;
@Repository
public interface ImageRepository  extends JpaRepository<Image, Integer>{


	
}
