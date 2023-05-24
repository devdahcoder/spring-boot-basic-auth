package com.devdahcoder.securityemailbasicauth.configuration.security.provider;

import com.devdahcoder.securityemailbasicauth.user.contract.UserDetailsContract;
import com.devdahcoder.securityemailbasicauth.user.repository.ApplicationUserRepository;
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
	private final ApplicationUserRepository applicationUserRepository;

	@Autowired
	public ApplicationAuthenticationProvider(PasswordEncoder passwordEncoder, ApplicationUserRepository applicationUserRepository) {

		this.applicationUserRepository = applicationUserRepository;

        this.passwordEncoder = passwordEncoder;

	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();

		String password = authentication.getCredentials().toString();

		UserDetailsContract applicationUserDetailsService = applicationUserRepository.loadUserByUsername(username);

		return checkCredential(applicationUserDetailsService, username, password, passwordEncoder);

	}

	private Authentication checkCredential(UserDetailsContract user, String username, String password, PasswordEncoder passwordEncoder) {
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
