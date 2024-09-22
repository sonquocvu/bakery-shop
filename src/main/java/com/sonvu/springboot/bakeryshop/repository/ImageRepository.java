package com.sonvu.springboot.bakeryshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sonvu.springboot.bakeryshop.entity.Image;

import jakarta.transaction.Transactional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM Image img "
				+ "WHERE img.food.name = :foodName")
	void deleteImageByFoodName(@Param("foodName") String foodName);
}
