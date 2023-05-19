package com.devdahcoder.securityemailbasicauth.provider;

import com.devdahcoder.securityemailbasicauth.user.contract.CustomUserDetails;
import com.devdahcoder.securityemailbasicauth.user.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class ApplicationAuthenticationProvider implements AuthenticationProvider {

	private final PasswordEncoder passwordEncoder;
	private final ApplicationUserService applicationUserService;

	@Autowired
	public ApplicationAuthenticationProvider(PasswordEncoder passwordEncoder, ApplicationUserService applicationUserService) {

		this.applicationUserService = applicationUserService;

        this.passwordEncoder = passwordEncoder;

	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();

		String password = authentication.getCredentials().toString();

		CustomUserDetails applicationUserDetailsService = applicationUserService.loadUserByUsername(username);

		return checkCredential(applicationUserDetailsService, username, password, passwordEncoder);

	}

	private Authentication checkCredential(CustomUserDetails user, String username, String password, PasswordEncoder passwordEncoder) {
//		passwordEncoder.matches(password, user.getPassword())
		if (username.equals(user.getUsername())) {

			return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());

		} else {

			throw new BadCredentialsException("Bad credentials");

		}

	}

	@Override
	public boolean supports(Class<?> authentication) {

		return UsernamePasswordAuthenticationToken.class.equals(authentication);

	}

}
