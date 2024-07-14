package com.sonvu.springboot.bakeryshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sonvu.springboot.bakeryshop.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

	@Query(value = "SELECT i FROM Image i")
	List<Image> findAllImages();
}
