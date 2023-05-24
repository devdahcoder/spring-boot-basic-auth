package com.devdahcoder.securityemailbasicauth.user.mapper;

import com.devdahcoder.securityemailbasicauth.user.modal.ApplicationUserResponseData;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserResultExtractor implements ResultSetExtractor<List<ApplicationUserResponseData>> {

	@Override
	public List<ApplicationUserResponseData> extractData(ResultSet rs) throws SQLException, DataAccessException {

		List<ApplicationUserResponseData> applicationUserResponseDataList = new ArrayList<>();

		while (rs.next()) {

			ApplicationUserResponseData applicationUserResponseData = new ApplicationUserResponseData();

			applicationUserResponseData.setId(rs.getLong("id"));
			applicationUserResponseData.setFirstName(rs.getString("firstName"));
			applicationUserResponseData.setLastName((rs.getString("lastName")));
			applicationUserResponseData.setEmail(rs.getString("email"));
			applicationUserResponseData.setUsername(rs.getString("username"));

			applicationUserResponseDataList.add(applicationUserResponseData);

		}

		return applicationUserResponseDataList;

	}

}
