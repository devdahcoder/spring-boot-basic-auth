package com.devdahcoder.securityemailbasicauth.user.repository;

import com.devdahcoder.securityemailbasicauth.user.contract.CustomUserService;
import com.devdahcoder.securityemailbasicauth.user.service.ApplicationUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class ApplicationUserRepository implements CustomUserService {

    private final ApplicationUserService applicationUserService;

    public ApplicationUserRepository(ApplicationUserService applicationUserService) {

        this.applicationUserService = applicationUserService;

    }

    @Override
    public void createUser(UserDetails user) {

        applicationUserService.createUser(user);

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

}
