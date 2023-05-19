package com.devdahcoder.securityemailbasicauth.user.mapper;

import com.devdahcoder.securityemailbasicauth.user.modal.ApplicationUser;
import com.devdahcoder.securityemailbasicauth.user.modal.ApplicationUserDetails;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserResultExtractor implements ResultSetExtractor<List<ApplicationUser>> {

	@Override
	public List<ApplicationUser> extractData(ResultSet rs) throws SQLException, DataAccessException {

		List<ApplicationUser> applicationUserList = new ArrayList<>();

		while (rs.next()) {

			ApplicationUser user = new ApplicationUser();

			user.setId(rs.getLong("id"));
			user.setEmail(rs.getString("email"));
			user.setUsername(rs.getString("username"));

			applicationUserList.add(user);

		}

		return applicationUserList;

	}

}
