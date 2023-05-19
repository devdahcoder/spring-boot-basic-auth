package com.devdahcoder.securityemailbasicauth.user.contract;

import org.springframework.security.core.userdetails.UserDetails;

public interface CustomUserDetails extends UserDetails {

    public String getEmail();

}
