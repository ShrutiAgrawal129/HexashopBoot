package com.univ.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.univ.bean.Customer;


public interface UserRepository extends JpaRepository<Customer, String>{
	Optional<Customer> findByName(String name);
	
	
	 @Modifying
	 @Query("UPDATE Customer u SET u.phone = :phone, u.address=:address,u.email=:email,u.city=:city WHERE u.name=:name")
	 void updateProfile(@Param("name") String name,
	    		@Param("phone")Long phone,
	    		@Param("email")String email,
	    		@Param("address")String address,
	    		@Param("city")String city);

	
	@Modifying
	@Query("UPDATE Customer u SET u.password=:password where u.name=:name")
	void changePassword(@Param("name")String name,@Param("password")String pass);
}
