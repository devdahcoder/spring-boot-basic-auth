package com.devdahcoder.securityemailbasicauth.user.controller;

import com.devdahcoder.securityemailbasicauth.user.modal.ApplicationUser;
import com.devdahcoder.securityemailbasicauth.user.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
	public ApplicationUser getUserByUserName(@PathVariable("username") String username) {

		var user = applicationUserRepository.loadUserByUsername(username);

		return user;

	}

}
