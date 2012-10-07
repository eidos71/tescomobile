package com.opensso.security.services.impl;

import com.opensso.security.services.CasLogout;





public class CasLogoutImpl implements CasLogout {

	private String logoutURL;
	private String systemHomePageURL;
	
	public String getLogoutURL() {
		return logoutURL;
	}

	public void setLogoutURL(String logoutURL) {
		this.logoutURL = logoutURL;
	}

	public String getSystemHomePageURL() {
		return systemHomePageURL;
	}

	public void setSystemHomePageURL(String systemHomePageURL) {
		this.systemHomePageURL = systemHomePageURL;
	}

}
