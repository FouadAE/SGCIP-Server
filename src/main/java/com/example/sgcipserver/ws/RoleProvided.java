package com.example.sgcipserver.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sgcipserver.bean.ERole;
import com.example.sgcipserver.bean.Role;
import com.example.sgcipserver.service.RoleService;

@RestController
@RequestMapping("/api/sgcip/role")
public class RoleProvided {
	@Autowired
	RoleService roleService;

	@GetMapping("/name/{name}")
	public Optional<Role> findByName(@PathVariable ERole name) {
		return roleService.findByName(name);
	}

	@GetMapping("/")
	public List<Role> findAll() {
		return roleService.findAll();
	}

	@DeleteMapping("/name/{name}")
	public int deleteByName(@PathVariable ERole name) {
		return roleService.deleteByName(name);
	}

}
