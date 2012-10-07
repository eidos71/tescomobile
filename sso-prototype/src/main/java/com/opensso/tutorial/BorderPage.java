package com.opensso.tutorial;

import java.util.Locale;

import org.apache.click.extras.control.ExternalLink;
import org.apache.click.extras.control.Menu;
import org.apache.click.util.ClickUtils;

import com.opensso.security.Permission;


public class BorderPage extends SpringPage {
	public ExternalLink Logout;
	public transient Menu rootMenu;

	public BorderPage() {
		String className = getClass().getName();

		Locale locale = new Locale("en", "US");
		Locale.setDefault(locale);
		
		String shortName = className.substring(className.lastIndexOf('.') + 1);
		String title = ClickUtils.toLabel(shortName);
		addModel("title", title);

		String srcPath = className.replace('.', '/') + ".java";
		addModel("srcPath", srcPath);
		
		
	}

	public void onInit() {
		super.onInit();
		
		if (hasPermission(Permission.LOGIN)) {
			MenuPage.setUserAuthorities(getAuthorities());
			rootMenu = MenuPage.getMenus();
			//Logout = new ExternalLink("Logout", getCasLogout().getSystemHomePageURL() );
			
		}
	}

	public String getTemplate() {
		return "border-template.htm";
	}

}