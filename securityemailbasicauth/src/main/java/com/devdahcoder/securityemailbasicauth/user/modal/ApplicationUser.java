package com.devdahcoder.securityemailbasicauth.user.modal;

import com.devdahcoder.securityemailbasicauth.user.contract.UserDetailsContract;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public class ApplicationUser implements UserDetailsContract {

	private Long id;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String username;
	private String authorities;

	public ApplicationUser() {}

	public ApplicationUser(Long id, String firstName, String lastName, String password, String email) {

		this.id = id;

		this.firstName = firstName;

		this.lastName = lastName;

		this.password = password;

		this.email = email;

	}

	public Long getId() {

		return id;

	}

	public void setId(Long id) {

		this.id = id;

	}

	public String getFirstName() {

		return firstName;

	}

	public void setFirstName(String firstName) {

		this.firstName = firstName;

	}

	public String getLastName() {

		return lastName;

	}

	public void setLastName(String lastName) {

		this.lastName = lastName;

	}

	public String getPassword() {

		return this.password;

	}

	public void setPassword(String password) {

		this.password = password;

	}

	@Override
	public String getEmail() {

		return email;

	}

	public void setEmail(String email) {

		this.email = email;

	}

	@Override
	public String getUsername() {

		return this.username;

	}

	public void setUsername(String username) {

		this.username = username;

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return List.of(() -> this.authorities);

	}

	@Override
	public boolean isAccountNonExpired() {

		return true;

	}

	@Override
	public boolean isAccountNonLocked() {

		return true;

	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;

	}

	@Override
	public boolean isEnabled() {

		return true;

	}

}
