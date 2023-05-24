package com.devdahcoder.securityemailbasicauth.user.controller;

import com.devdahcoder.securityemailbasicauth.user.contract.UserDetailsContract;
import com.devdahcoder.securityemailbasicauth.user.mapper.UserResponseMapper;
import com.devdahcoder.securityemailbasicauth.user.modal.ApplicationUserResponseData;
import com.devdahcoder.securityemailbasicauth.user.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/user")
@RestController
public class UserController {

	private final ApplicationUserRepository applicationUserRepository;

	@Autowired
	public UserController(ApplicationUserRepository applicationUserRepository) {

		this.applicationUserRepository = applicationUserRepository;

	}

	@GetMapping
	public ResponseEntity<List<ApplicationUserResponseData>> getAllUsers() {

		return new ResponseEntity<List<ApplicationUserResponseData>>(applicationUserRepository.getAllUsers(), HttpStatus.OK);

	}

	@GetMapping("/{username}")
	public ResponseEntity<ApplicationUserResponseData> findUserByUserName(@PathVariable("username") String username) {

		UserDetailsContract userDetailsContract = applicationUserRepository.loadUserByUsername(username);

		return new ResponseEntity<ApplicationUserResponseData>(new UserResponseMapper().mapRow(userDetailsContract), HttpStatus.OK);

	}

}
