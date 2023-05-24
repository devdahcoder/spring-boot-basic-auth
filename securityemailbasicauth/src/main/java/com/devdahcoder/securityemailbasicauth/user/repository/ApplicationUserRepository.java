package com.devdahcoder.securityemailbasicauth.user.repository;

import com.devdahcoder.securityemailbasicauth.user.contract.UserDetailsContract;
import com.devdahcoder.securityemailbasicauth.user.contract.UserServiceContract;
import com.devdahcoder.securityemailbasicauth.user.modal.ApplicationUserResponseData;
import com.devdahcoder.securityemailbasicauth.user.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ApplicationUserRepository implements UserServiceContract {

    private final ApplicationUserService applicationUserService;

    @Autowired
    public ApplicationUserRepository(ApplicationUserService applicationUserService) {

        this.applicationUserService = applicationUserService;

    }

    @Override
    public List<ApplicationUserResponseData> getAllUsers() {

        return applicationUserService.getAllUsers();

    }

    @Override
    public void createUser(UserDetails user) {

        applicationUserService.createUser(user);

    }

    @Override
    public UserDetailsContract loadUserByUsername(String username) throws UsernameNotFoundException {

        return applicationUserService.loadUserByUsername(username);

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
