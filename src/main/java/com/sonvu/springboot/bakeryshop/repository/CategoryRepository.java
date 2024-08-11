package com.sonvu.springboot.bakeryshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sonvu.springboot.bakeryshop.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	
}
