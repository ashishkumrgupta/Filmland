package com.filmland.constants;

public class SecurityConstantss {
	
	private SecurityConstantss() {
	}
	public static final String SECRET = "filmlandkey";
	public static final long EXPIRATION_TIME = 300000; // 10 days
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
}
