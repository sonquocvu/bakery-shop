package com.sonvu.springboot.bakeryshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sonvu.springboot.bakeryshop.entity.Cake;

@Repository
public interface CakeRepository extends JpaRepository<Cake, Long> {

	
}
