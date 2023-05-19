package com.devdahcoder.securityemailbasicauth.user.contract;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsContract extends UserDetails {

    public String getFirstName();

    public String getLastName();

    public Long getId();

    public String getEmail();

}
