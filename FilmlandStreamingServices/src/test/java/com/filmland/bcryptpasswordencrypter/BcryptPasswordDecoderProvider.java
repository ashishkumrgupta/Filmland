package com.filmland.bcryptpasswordencrypter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptPasswordDecoderProvider {
	public static void main(String[] args) {
		String input = "javaiscool90";
		BCryptPasswordEncoder encrpter = provideEncrypter();
		System.out.println(encrpter.encode(input));
	}

	private static BCryptPasswordEncoder provideEncrypter() {
		return new BCryptPasswordEncoder();
	}
}
