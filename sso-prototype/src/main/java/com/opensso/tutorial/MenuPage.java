package com.opensso.tutorial;

import org.apache.click.extras.control.Menu;
import org.springframework.security.GrantedAuthority;

import com.opensso.security.Permission;

public class MenuPage {
	
	private static GrantedAuthority[] UserAuthorities;
	
    private static class MenuHolder {
        private static Menu INSTANCE = createMenus();
    }

    public static void setUserAuthorities(GrantedAuthority[] userAuthorities) {
		UserAuthorities = userAuthorities;
	}

	public static Menu getMenus() {
		return MenuHolder.INSTANCE;
    }

    @SuppressWarnings("unchecked")
	private static Menu createMenus() {
    	
		Menu rootMenu = new Menu("rootMenu");
		Menu menu;
		Menu subMenu;

		menu = createMenu("Home", "home.htm","/assets/images/home.png");
	    rootMenu.getChildren().add(menu);
    
	    	if (userHasAuthority(Permission.TEST)) {
	    		subMenu = createMenu("List tasks", "#");
	            menu.getChildren().add(subMenu);
	    	}

	    	if (userHasAuthority(Permission.ADMINISTRATOR)) {
	    		subMenu = createMenu("Administration", "#");
	            menu.getChildren().add(subMenu);
	    	}   
	    	subMenu = createMenu("Logout", "logout.jsp");
            menu.getChildren().add(subMenu);
	    menu= createMenu ("Logout", "logout.jsp", "assets/images/delete.gif");
	    rootMenu.getChildren().add(menu);
		return rootMenu;

	}
	
    @SuppressWarnings("unused")
	private static Menu createMenu(String label) {
        Menu menu = new Menu();
        menu.setLabel(label);
        menu.setTitle(label);
        return menu;
    }

    private static Menu createMenu(String label, String path) {
        Menu menu = new Menu();
        menu.setLabel(label);
        menu.setPath(path);
        menu.setTitle(label);
        return menu;
    }

    private static Menu createMenu(String label, String path, String IconPath) {
        Menu menu = new Menu();
        menu.setLabel(label);
        menu.setPath(path);
        menu.setTitle(label);
        menu.setImageSrc(IconPath);
        return menu;
    }
    
    public static boolean userHasAuthority(String authority) {
        for (int i = 0; i < UserAuthorities.length; i++) {
            if (authority.equals(UserAuthorities[i].getAuthority())) {
                return true;
            }
        }

        return false;
    }
    
}