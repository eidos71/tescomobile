package com.opensso.security.services;

import org.springframework.security.Authentication;
import org.springframework.security.GrantedAuthority;


public interface AuthorizationService {
	
	public boolean hasPermission(String permission);
	public String getUserName();
	public Authentication getAuthentication();
	public GrantedAuthority[] getAuthorities();
	
}
