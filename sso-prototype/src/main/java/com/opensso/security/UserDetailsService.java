package com.opensso.security;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.userdetails.User;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UsernameNotFoundException;

import com.opensso.tutorial.BorderPage;




public class UserDetailsService extends BorderPage implements
		org.springframework.security.userdetails.UserDetailsService {

	private static final String CAS_STATEFUL = "_cas_stateful_";

	private Logger logger = getLogger(getClass()); 

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		Set<String> permissions = null;
		
		if (CAS_STATEFUL.equalsIgnoreCase(username)) {
			permissions = Collections.emptySet();
		} else {
			permissions = new HashSet<String>(getPermissionService().getUserPermissions(username));
		}

		GrantedAuthority[] grantedAuthorities = new GrantedAuthority[permissions.size()];

		int index = 0;
		for (String permission : permissions) {
			grantedAuthorities[index++] = new GrantedAuthorityImpl(permission);
		}
		
		logger.info("Loaded permissions " + permissions + " for user \""
					+ username+"\"");
		
		return new User(username, "", true, true, true, true,
				grantedAuthorities);
	}

}
