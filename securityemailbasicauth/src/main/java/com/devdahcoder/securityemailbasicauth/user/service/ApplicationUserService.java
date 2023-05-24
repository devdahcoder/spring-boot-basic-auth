package com.devdahcoder.securityemailbasicauth.user.service;

import com.devdahcoder.securityemailbasicauth.user.contract.UserDetailsContract;
import com.devdahcoder.securityemailbasicauth.user.contract.UserServiceContract;
import com.devdahcoder.securityemailbasicauth.user.mapper.UserResultExtractor;
import com.devdahcoder.securityemailbasicauth.user.mapper.UserRowMapper;
import com.devdahcoder.securityemailbasicauth.user.modal.ApplicationUser;
import com.devdahcoder.securityemailbasicauth.user.modal.ApplicationUserDetails;
import com.devdahcoder.securityemailbasicauth.user.modal.ApplicationUserResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationUserService implements UserServiceContract {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public ApplicationUserService(JdbcTemplate jdbcTemplate) {

		this.jdbcTemplate = jdbcTemplate;

	}

	@Override
	public List<ApplicationUserResponseData> getAllUsers() {

		String sqlQuery = "select * from user";

		return jdbcTemplate.query(sqlQuery, new UserResultExtractor());

	}

	@Override
	public UserDetailsContract loadUserByUsername(String username) throws UsernameNotFoundException {

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
