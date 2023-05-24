package com.devdahcoder.securityemailbasicauth.user.contract;

import com.devdahcoder.securityemailbasicauth.user.modal.ApplicationUserResponseData;
import org.springframework.security.provisioning.UserDetailsManager;

import java.util.List;

public interface UserServiceContract extends UserDetailsManager {

    List<ApplicationUserResponseData> getAllUsers();

}
