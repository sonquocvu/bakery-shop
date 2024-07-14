package com.sonvu.springboot.bakeryshop.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sonvu.springboot.bakeryshop.entity.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {

	@Query(value = 
			"SELECT t FROM Tag t "
			+ "ORDER BY t.count DESC")
	List<Tag> findTopTags(Pageable pageable);
}
