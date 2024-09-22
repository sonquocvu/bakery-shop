package com.sonvu.springboot.bakeryshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sonvu.springboot.bakeryshop.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	@Query(value = "SELECT cat FROM Category cat")
	List<Category> findAllCategories();
	
	@Query(value = "SELECT cat.category_id AS category_id, cat.name AS category_name, COUNT(f.category_id) AS food_quantity "
			+ "FROM category cat "
			+ "LEFT JOIN food f ON cat.category_id = f.category_id "
			+ "GROUP BY cat.category_id, cat.name, f.category_id",
		nativeQuery = true)
	List<Object[]> findAllCategoriesWithProductQuantity();
	
	@Query(value = "SELECT cat from Category cat "
				+ "WHERE cat.name = :name")
	Category findCategoryByName(@Param("name") String name);
}
