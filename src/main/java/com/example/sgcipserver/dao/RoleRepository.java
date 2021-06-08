package com.example.sgcipserver.dao;

import com.example.sgcipserver.bean.ERole;
import com.example.sgcipserver.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);

	int deleteByName(ERole name);
}
