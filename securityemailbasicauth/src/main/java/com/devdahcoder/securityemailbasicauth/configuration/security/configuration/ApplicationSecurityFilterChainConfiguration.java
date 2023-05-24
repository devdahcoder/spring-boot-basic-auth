package com.devdahcoder.securityemailbasicauth.configuration.security.configuration;

import com.devdahcoder.securityemailbasicauth.configuration.security.provider.ApplicationAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class ApplicationSecurityFilterChainConfiguration {

    private final ApplicationAuthenticationProvider applicationAuthenticationProvider;

    @Autowired
    public ApplicationSecurityFilterChainConfiguration(ApplicationAuthenticationProvider applicationAuthenticationProvider) {

        this.applicationAuthenticationProvider = applicationAuthenticationProvider;

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws  Exception {

        httpSecurity.httpBasic();

        return httpSecurity
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated()
                .and()
                .build();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) {

        authenticationManagerBuilder.authenticationProvider(applicationAuthenticationProvider);

    }

}
