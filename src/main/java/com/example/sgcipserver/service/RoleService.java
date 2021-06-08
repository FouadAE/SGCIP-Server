package com.example.sgcipserver.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sgcipserver.bean.ERole;
import com.example.sgcipserver.bean.Role;
import com.example.sgcipserver.dao.RoleRepository;

@Service
public class RoleService {
	@Autowired
	RoleRepository roleRepository;

	public Optional<Role> findByName(ERole name) {
		return roleRepository.findByName(name);
	}

	@Transactional
	public int deleteByName(ERole name) {
		return roleRepository.deleteByName(name);
	}

	public List<Role> findAll() {
		return roleRepository.findAll();
	}

}
