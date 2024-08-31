package com.sonvu.springboot.bakeryshop.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sonvu.springboot.bakeryshop.entity.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

	@Query(value = "SELECT f FROM Food f "
				+ "JOIN FETCH f.user u "
				+ "JOIN FETCH f.category cat "
				+ "LEFT JOIN FETCH f.images img "
				+ "ORDER BY f.lastModified DESC")
	List<Food> findAllFoodsWithAllRelations();
	
	@Query(value = "SELECT f FROM Food f "
			+ "JOIN FETCH f.user u "
			+ "JOIN FETCH f.category cat "
			+ "LEFT JOIN FETCH f.images img")
	List<Food> findFoodsByPagination(Pageable pageable);
	
	@Query(value = "SELECT f FROM Food f "
				+ "JOIN FETCH f.user u "
				+ "JOIN FETCH f.category cat "
				+ "LEFT JOIN FETCH f.images img "
				+ "WHERE f.category.name = :category")
	List<Food> findFoodsByCategoryName(@Param("category") String category);
	
	@Query(value = "SELECT * FROM ("
				+ "SELECT * FROM food f WHERE f.category_id = (SELECT category_id FROM category WHERE name = 'Signature') LIMIT 6 "
				+ "UNION ALL "
				+ "SELECT * FROM food f WHERE f.category_id = (SELECT category_id FROM caterogy WHERE name = 'Bánh kem') LIMIT 7 "
				+ "UNION ALL "
				+ "SELECT * FROM food f WHERE f.category_id = (SELECT category_id FROM category WHERE name = 'Bánh mì') LIMIT 4 "
				+ "UNION ALL "
				+ "SELECT * FROM food f WHERE f.category_id = (SELECT category_id FROM category WHERE name = 'Trà') LIMIT 3 "
				+ ") AS combined_results "
				+ "ORDER BY last_modified DESC",
			nativeQuery = true)
	List<Food> findFoodsInLimitWithoutRelations();
	
	@Query(value = 
			"(SELECT f.food_id AS food_id, f.name AS food_name, f.description AS food_description, f.price AS food_price, "
			+ "u.full_name AS chef, cat.name AS category_name, "
			+ "GROUP_CONCAT(img.image_url ORDER BY img.image_url SEPARATOR ',') AS image_urls "
			+ "FROM food f "
			+ "JOIN user u ON f.user_id = u.user_id "
			+ "JOIN category cat ON f.category_id = cat.category_id "
			+ "LEFT JOIN image img ON f.food_id = img.food_id "
			+ "WHERE f.category_id = (SELECT category_id FROM category WHERE name = 'Trà') "
			+ "GROUP BY f.food_id, f.name, f.description, f.price, u.full_name, cat.name "
			+ "ORDER BY f.last_modified DESC "
			+ "LIMIT 3) "
			+ "UNION ALL "
			+ "(SELECT f.food_id AS food_id, f.name AS food_name, f.description AS food_description, f.price AS food_price, "
			+ "u.full_name AS chef, cat.name AS category_name, "
			+ "GROUP_CONCAT(img.image_url ORDER BY img.image_url SEPARATOR ',') AS image_urls "
			+ "FROM food f "
			+ "JOIN user u ON f.user_id = u.user_id "
			+ "JOIN category cat ON f.category_id = cat.category_id "
			+ "LEFT JOIN image img ON f.food_id = img.food_id "
			+ "WHERE f.category_id = (SELECT category_id FROM category WHERE name = 'Bánh mì') "
			+ "GROUP BY f.food_id, f.name, f.description, f.price, u.full_name, cat.name "
			+ "ORDER BY f.last_modified DESC "
			+ "LIMIT 4) "
			+ "UNION ALL "
			+ "(SELECT f.food_id AS food_id, f.name AS food_name, f.description AS food_description, f.price AS food_price, "
			+ "u.full_name AS chef, cat.name AS category_name, "
			+ "GROUP_CONCAT(img.image_url ORDER BY img.image_url SEPARATOR ',') AS image_urls "
			+ "FROM food f "
			+ "JOIN user u ON f.user_id = u.user_id "
			+ "JOIN category cat ON f.category_id = cat.category_id "
			+ "LEFT JOIN image img ON f.food_id = img.food_id "
			+ "WHERE f.category_id = (SELECT category_id FROM category WHERE name = 'Bánh kem') "
			+ "GROUP BY f.food_id, f.name, f.description, f.price, u.full_name, cat.name "
			+ "ORDER BY f.last_modified DESC "
			+ "LIMIT 7) "
			+ "UNION ALL "
			+ "(SELECT f.food_id AS food_id, f.name AS food_name, f.description AS food_description, f.price AS food_price, "
			+ "u.full_name AS chef, cat.name AS category_name, "
			+ "GROUP_CONCAT(img.image_url ORDER BY img.image_url SEPARATOR ',') AS image_urls "
			+ "FROM food f "
			+ "JOIN user u ON f.user_id = u.user_id "
			+ "JOIN category cat ON f.category_id = cat.category_id "
			+ "LEFT JOIN image img ON f.food_id = img.food_id "
			+ "WHERE f.category_id = (SELECT category_id FROM category WHERE name = 'Signature') "
			+ "GROUP BY f.food_id, f.name, f.description, f.price, u.full_name, cat.name "
			+ "ORDER BY f.last_modified DESC "
			+ "LIMIT 6) ",
		nativeQuery = true)
	List<Object[]> findFoodsInLimitWithRelations();
	
	@Query(value = "SELECT f from Food f "
			+ "JOIN FETCH f.user u "
			+ "JOIN FETCH f.category cat "
			+ "LEFT JOIN FETCH f.images img "
			+ "WHERE f.id = :id")
	Food findFoodById(@Param("id") Long id);
}
