package com.univ.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.univ.bean.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
		List<Product> findByStatus(int status);
		
		Optional<Product> findById(int id);
		
		@Query("SELECT p FROM Product p WHERE p.id IN :ids")
		List<Product> findByIdIn(@Param("ids") List<Integer> ids);
		
		@Modifying
	    @Query("UPDATE Product p SET p.status = :status")
	    void updateAllStatus(@Param("status") int status);

	    @Modifying
	    @Query("UPDATE Product p SET p.status = :status WHERE p.id IN :ids")
	    void updateStatusByIds(@Param("ids") List<Integer> ids, @Param("status") int status);

	    
}
