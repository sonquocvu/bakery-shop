package com.sonvu.springboot.bakeryshop.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sonvu.springboot.bakeryshop.entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

	@Query(value = "SELECT p FROM Profile p")
	List<Profile> findAllProfiles();
	
	@Query(value = 
			"SELECT p, COUNT(f.following.id) AS followings, f.follower.id "
			+ "FROM Profile p "
			+ "JOIN p.user u "
			+ "JOIN u.followers f "
			+ "GROUP BY p.id, f.follower.id "
			+ "ORDER BY followings DESC")
	List<Profile> findTopFollowedProfiles(Pageable pageable);
}
