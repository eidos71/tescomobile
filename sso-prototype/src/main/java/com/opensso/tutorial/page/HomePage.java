package com.opensso.tutorial.page;

import org.apache.log4j.Logger;

import com.opensso.security.Permission;
import com.opensso.tutorial.BorderPage;



public class HomePage extends BorderPage {

	private Logger logger = getLogger(getClass());
	
	@SuppressWarnings("unchecked")
	public void onInit() {
		super.onInit();
		getModel().put("title", getUserName());
	}
	
	public HomePage() {
		
		if (hasPermission(Permission.LOGIN)) {
			logger.info("has permision :" + getUserName());
		}
	}
	
	
	
}