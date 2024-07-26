package com.sonvu.springboot.bakeryshop.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sonvu.springboot.bakeryshop.entity.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

	@Query(value = "SELECT r FROM Recipe r")
	List<Recipe> findAllRecipes();
	
	@Query(value = 
			"SELECT r, u " +
			"FROM Recipe r " +
			"JOIN FETCH r.category c " +
			"JOIN FETCH r.image i " +
			"JOIN r.user u " +
			"JOIN FETCH u.profile p " +
			"WHERE r.isActivated = true AND r.isHidden = false " +
			"ORDER BY r.numOfView DESC")
	List<Recipe> findTopViewRecipes(Pageable pageable);
	
	@Query(value = 
			"SELECT r, u " +
			"FROM Recipe r " +
			"JOIN FETCH r.category c " +
			"JOIN FETCH r.image m " +
			"JOIN r.user u " +
			"JOIN FETCH u.profile p " +
			"WHERE r.isActivated = true AND r.isHidden = false " +
			"ORDER BY r.numOfLike DESC")
	List<Recipe> findTopLikeRecipes(Pageable pageable);
	
	@Query(value = 
			"SELECT r, u " +
			"FROM Recipe r " +
			"JOIN FETCH r.category c " +
			"JOIN FETCH r.image i " +
			"JOIN r.user u " +
			"JOIN FETCH u.profile p " +
			"WHERE r.isActivated = true AND r.isHidden = false " +
			"ORDER BY r.lastModified DESC ")
	List<Recipe> findTopModifiedRecipes(Pageable pageable);
}
