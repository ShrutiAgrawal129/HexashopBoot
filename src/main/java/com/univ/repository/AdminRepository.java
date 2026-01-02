package com.univ.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.univ.bean.Admin;

public interface AdminRepository extends JpaRepository<Admin, String>{
	Optional<Admin> findByAdminName(String adminName);
}
