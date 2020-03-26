package com.nthalk.healthtracker.web.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
class SecurityConfig : WebSecurityConfigurerAdapter() {
    @Throws(Exception::class)
    public override fun configure(http: HttpSecurity) {
        http.csrf()
            // We don't need CSRF if we have no GET api endpoints
            // that process data.
            .disable()
            .authorizeRequests()
            // We want to force "/login" to go to the authorizors
            .antMatchers("/login")
            .authenticated()
            .anyRequest()
            .permitAll()
            // Add a "/logout"
            .and()
            .logout()
            // Use/allow oauth2
            .and()
            .oauth2Login()
            .and()
            .oauth2Client()
    }
}
