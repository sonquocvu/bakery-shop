package com.sonvu.springboot.bakeryshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sonvu.springboot.bakeryshop.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "SELECT u FROM User u")
	List<User> findAllUsers();
	
	@Query(value = "SELECT u FROM User u "
					+ "JOIN FETCH u.account a "
					+ "WHERE a.username = :username")
	User findByUsername(@Param("username") String username);
	
	@Query(value = "SELECT u FROM User u "
			+ "JOIN FETCH u.profile p "
			+ "JOIN u.account a "
			+ "WHERE a.username = :username")
	User findByUsernameGetProfile(@Param("username") String username);
}
