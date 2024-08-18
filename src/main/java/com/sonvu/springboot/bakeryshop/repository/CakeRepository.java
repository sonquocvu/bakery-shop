package com.sonvu.springboot.bakeryshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sonvu.springboot.bakeryshop.entity.Cake;

@Repository
public interface CakeRepository extends JpaRepository<Cake, Long> {

	@Query(value = "SELECT c FROM Cake c "
				+ "JOIN FETCH c.user u "
				+ "JOIN FETCH c.category cat "
				+ "LEFT JOIN FETCH c.images img "
				+ "ORDER BY c.lastModified DESC")
	List<Cake> findAllCakesWithRelations();
}
