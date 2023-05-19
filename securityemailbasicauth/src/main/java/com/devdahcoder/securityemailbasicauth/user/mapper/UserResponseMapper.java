package com.devdahcoder.securityemailbasicauth.user.mapper;

import com.devdahcoder.securityemailbasicauth.user.contract.UserDetailsContract;
import com.devdahcoder.securityemailbasicauth.user.modal.ApplicationUserResponseData;

public class UserResponseMapper {

    public ApplicationUserResponseData mapRow(UserDetailsContract resultSet) {

        ApplicationUserResponseData userResponseData = new ApplicationUserResponseData();

        userResponseData.setId(resultSet.getId());

        userResponseData.setFirstName(resultSet.getFirstName());

        userResponseData.setLastName(resultSet.getLastName());

        userResponseData.setUsername(resultSet.getUsername());

        userResponseData.setEmail(resultSet.getEmail());

        return userResponseData;

    }

}
