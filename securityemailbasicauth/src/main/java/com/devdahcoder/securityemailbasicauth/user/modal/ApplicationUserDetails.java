package com.devdahcoder.securityemailbasicauth.user.modal;

import com.devdahcoder.securityemailbasicauth.user.contract.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class ApplicationUserDetails implements CustomUserDetails {

	private final ApplicationUser applicationUser;

	@Autowired
	public ApplicationUserDetails(ApplicationUser applicationUser) {

		this.applicationUser = applicationUser;

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return applicationUser.getAuthorities();

	}

	@Override
	public String getPassword() {

		return applicationUser.getPassword();

	}

	@Override
	public String getUsername() {

		return applicationUser.getUsername();

	}

	@Override
	public String getEmail() {
		return applicationUser.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {

		return applicationUser.isAccountNonExpired();

	}

	@Override
	public boolean isAccountNonLocked() {

		return applicationUser.isAccountNonLocked();

	}

	@Override
	public boolean isCredentialsNonExpired() {

		return applicationUser.isCredentialsNonExpired();

	}

	@Override
	public boolean isEnabled() {

		return applicationUser.isEnabled();

	}

}
