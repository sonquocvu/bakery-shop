package com.sonvu.springboot.bakeryshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sonvu.springboot.bakeryshop.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "SELECT u FROM User u")
	List<User> findAllUsers();
	
	@Query(value = "SELECT u FROM User u "
					+ "JOIN FETCH u.account a "
					+ "WHERE u.email = :email")
	User findByEmail(@Param("email") String email);
	
	@Query(value = "SELECT u FROM User u "
					+ "JOIN FETCH u.account a "
					+ "WHERE u.phoneNumber = :phoneNumber")
	User findByPhoneNumber(@Param("phoneNumber") String phoneNumber);
	
	@Query(value = "SELECT u FROM User u "
					+ "WHERE u.id = :id")
	User findUserById(@Param("id") Long id);
}
