package com.opensso.tutorial;

import org.apache.click.Page;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.Authentication;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.util.AuthorityUtils;

import com.opensso.security.services.AuthorizationService;
import com.opensso.security.services.CasLogout;
import com.opensso.security.services.DatabaseService;
import com.opensso.security.services.PermissionService;


public class SpringPage extends Page implements ApplicationContextAware, AuthorizationService {

	protected Logger logger;
	private ApplicationContext applicationContext;
	
	@SuppressWarnings("unchecked")
	public Logger getLogger(Class cl) {
		if (logger == null) {
			logger = Logger.getLogger(cl);
		}
		return logger;
	}
	
	public DatabaseService getDatabaseService() {
		return (DatabaseService) getBean("databaseService");
	}
	
	public PermissionService getPermissionService() {
		return (PermissionService) getBean("permissionService");
	}
	
	public CasLogout getCasLogout() {
		return (CasLogout) getBean("casLogout");
	}
	
	public String getUserName() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

	public boolean hasPermission(String permission) {
		logger.info("haspermission, permission ->"+ permission);
		return AuthorityUtils.userHasAuthority(permission);
	}
	
	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
	public GrantedAuthority[] getAuthorities() {
		return getAuthentication().getAuthorities();
	}

	public Object getBean(String beanName) {
        if (beanName == null) {
            throw new IllegalArgumentException("Null name parameter");
        }
        
        if (applicationContext == null) {
        	throw new IllegalStateException("Application context is not set");
        }

        return applicationContext.getBean(beanName);
    }
	
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
		
	}
	
}
