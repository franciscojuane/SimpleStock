package com.francisco.springmvcboot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class JwtUtil {

	private String secret_key = "secret";
	
	public String generateToken(UserDetails userDetail) {
	Map<String, Object> claims = new HashMap<>();
	//return createToken(claims, userDetail.)
	return "abc";
	
	}
}
