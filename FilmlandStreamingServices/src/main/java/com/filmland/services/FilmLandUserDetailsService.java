package com.filmland.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.filmland.dbrepository.UserRepository;
import com.filmland.dto.FilmlandUser;
import com.filmland.exceptions.LoginUserNotFoundException;

@Component
public class FilmLandUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws LoginUserNotFoundException {
		FilmlandUser user = userRepository.findById(username).orElseThrow(() -> new LoginUserNotFoundException());
		List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));
		return new User(user.getEmail(), user.getPassword(), authorities);
	}
}
