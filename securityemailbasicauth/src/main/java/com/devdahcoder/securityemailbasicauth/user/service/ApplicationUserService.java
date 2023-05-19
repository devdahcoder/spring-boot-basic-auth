package com.devdahcoder.securityemailbasicauth.user.service;

import com.devdahcoder.securityemailbasicauth.user.contract.CustomUserDetails;
import com.devdahcoder.securityemailbasicauth.user.contract.CustomUserService;
import com.devdahcoder.securityemailbasicauth.user.mapper.UserRowMapper;
import com.devdahcoder.securityemailbasicauth.user.modal.ApplicationUser;
import com.devdahcoder.securityemailbasicauth.user.modal.ApplicationUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService implements CustomUserService {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public ApplicationUserService(JdbcTemplate jdbcTemplate) {

		this.jdbcTemplate = jdbcTemplate;

	}

	//	This method is for spring security provider user only
	@Override
	public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		String sqlQuery = "select * from user where username = ?";

		ApplicationUser user = jdbcTemplate.queryForObject(sqlQuery, new UserRowMapper(), username);

		if ( user == null ) throw new UsernameNotFoundException("User not found");

		return new ApplicationUserDetails(user);

	}

	@Override
	public void createUser(UserDetails user) {

	}

	@Override
	public void updateUser(UserDetails user) {

	}

	@Override
	public void deleteUser(String username) {

	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {

	}

	@Override
	public boolean userExists(String username) {
		return false;
	}

}
