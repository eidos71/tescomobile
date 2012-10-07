package com.opensso.tutorial;

import org.apache.click.extras.control.ExternalLink;
import org.apache.log4j.Logger;

public class AccessDenied extends BorderPage {
	
	private Logger logger = getLogger(getClass());
	public String user;
	public ExternalLink Logout;
	@SuppressWarnings("unchecked")
	
	public void onInit() {
		super.onInit();
		user = getUserName();
		logger.warn(getCasLogout().getSystemHomePageURL() );
		Logout = new ExternalLink("Logout", getCasLogout().getLogoutURL() );
		getModel().put("title", "For user " + user + " access denied !!!");
		
	}
	
	public AccessDenied() {
		logger.warn("Access Denied for :" + getUserName());
	}
}
