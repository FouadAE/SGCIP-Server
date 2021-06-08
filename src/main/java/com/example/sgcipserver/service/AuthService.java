package com.example.sgcipserver.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.sgcipserver.bean.ERole;
import com.example.sgcipserver.bean.Role;
import com.example.sgcipserver.bean.User;
import com.example.sgcipserver.dao.RoleRepository;
import com.example.sgcipserver.dao.UserRepository;
import com.example.sgcipserver.payload.request.LoginRequest;
import com.example.sgcipserver.payload.request.SignupRequest;
import com.example.sgcipserver.payload.response.JwtResponse;
import com.example.sgcipserver.payload.response.MessageResponse;
import com.example.sgcipserver.security.jwt.JwtUtils;
import com.example.sgcipserver.security.service.UserDetailsImpl;

@Service
public class AuthService {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
	}

	public ResponseEntity<?> registerUser(SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "chefDivision":
					Role chefDivisionRole = roleRepository.findByName(ERole.ROLE_CHEF_DIVISION)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(chefDivisionRole);

					break;
				case "chefDacceuil":
					Role chefDacceuilRole = roleRepository.findByName(ERole.ROLE_CHEF_DACCEUIL)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(chefDacceuilRole);

					break;
				case "chefBureauDordre":
					Role chefBureauDordreRole = roleRepository.findByName(ERole.ROLE_CHEF_BUREAU_DORDRE)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(chefBureauDordreRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

}
