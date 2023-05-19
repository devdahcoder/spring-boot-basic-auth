package com.devdahcoder.securityemailbasicauth.user.mapper;

import com.devdahcoder.securityemailbasicauth.user.modal.ApplicationUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<ApplicationUser> {

	@Override
	public ApplicationUser mapRow(ResultSet rs, int rowNum) throws SQLException {

		ApplicationUser user = new ApplicationUser();

		user.setId(rs.getLong("id"));
		user.setFirstName(rs.getString("firstName"));
		user.setLastName((rs.getString("lastName")));
		user.setPassword(rs.getString("password"));
		user.setEmail(rs.getString("email"));
		user.setUsername(rs.getString("username"));

		return user;

	}

}
