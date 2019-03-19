package com.filmland.security;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.filmland.dto.ResponseStatus;

public class FilmLandAuthenticationFailureHandler implements AccessDeniedHandler {
	@Override
	public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			AccessDeniedException e) throws IOException, ServletException {
		ResponseStatus response = new ResponseStatus(new Date(), "Login Failed",
				"Provided user ID or password is not valid. Please check.");
		OutputStream out = httpServletResponse.getOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(out, response);
		out.flush();
	}
}
