package com.devdahcoder.securityemailbasicauth.user.controller;

import com.devdahcoder.securityemailbasicauth.user.contract.UserDetailsContract;
import com.devdahcoder.securityemailbasicauth.user.mapper.UserResponseMapper;
import com.devdahcoder.securityemailbasicauth.user.modal.ApplicationUserResponseData;
import com.devdahcoder.securityemailbasicauth.user.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/user")
@RestController
public class UserController {

	private final ApplicationUserRepository applicationUserRepository;

	@Autowired
	public UserController(ApplicationUserRepository applicationUserRepository) {

		this.applicationUserRepository = applicationUserRepository;

	}

	@GetMapping("/{username}")
	public ResponseEntity<ApplicationUserResponseData> findUserByUserName(@PathVariable("username") String username) {

		UserDetailsContract userDetailsContract = applicationUserRepository.loadUserByUsername(username);

		return ResponseEntity.ok(new UserResponseMapper().mapRow(userDetailsContract));

	}

}
