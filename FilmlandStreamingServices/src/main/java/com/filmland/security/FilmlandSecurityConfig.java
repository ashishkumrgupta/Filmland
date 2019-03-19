package com.filmland.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.filmland.services.FilmLandUserDetailsService;

@Configuration
@EnableConfigurationProperties
@EnableWebSecurity
public class FilmlandSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private FilmLandUserDetailsService filmLandUserDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	FilmLandAuthenticationFailureHandler accessDeniedHandler() {
		return new FilmLandAuthenticationFailureHandler();
	}

	@Bean
	FilmLandAuthenticationEntryPoint authenticationEntryPoint() {
		return new FilmLandAuthenticationEntryPoint();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().disable();
		http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic().and()
				.sessionManagement().disable().exceptionHandling().accessDeniedHandler(accessDeniedHandler())
				.authenticationEntryPoint(authenticationEntryPoint());
		/*
		 * http.csrf().disable().authorizeRequests().antMatchers("/h2-console").
		 * permitAll().antMatchers("/filmland")
		 * .permitAll().anyRequest().authenticated().and().httpBasic().and().
		 * sessionManagement().disable();
		 */ }

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(filmLandUserDetailsService).passwordEncoder(passwordEncoder());
	}

}
