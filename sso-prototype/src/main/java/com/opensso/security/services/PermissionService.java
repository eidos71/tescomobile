package com.opensso.security.services;

import java.util.List;

/**
 * User permission provider.
 * 
 *
 */
public interface PermissionService {
	public List<String> getUserPermissions(String userLogin);
}
