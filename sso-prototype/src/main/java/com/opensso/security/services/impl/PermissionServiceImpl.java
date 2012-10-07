package com.opensso.security.services.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.opensso.security.services.PermissionService;
import com.opensso.tutorial.BorderPage;




public class PermissionServiceImpl extends BorderPage implements PermissionService {

	private Logger logger = getLogger(getClass()); 
	
	private static final String PERMISSION_PARAMETER = "sp_role_name";
	
	public List<String> getUserPermissions(String userLogin) {
		ResultSet rs = getUserPermissionsInternal(userLogin);
		List<String> result = new ArrayList<String>();
		try {
			while (rs.next()) {
				result.add(rs.getString(PERMISSION_PARAMETER));
			}
		} catch (SQLException e) {
			logger.error("Failed to read user " + userLogin	+ " permissions", e);
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}
	
	private ResultSet getUserPermissionsInternal(String userLogin) {
		ResultSet rs = null;
		try {
			
			String sql = "SELECT sp_role_name " +
			 "FROM sp_rights s, sp_roles s_r, sp_users s_u " +
			 "where " +
			 "s_u.sp_user_id = s.sp_rights_user_id " +
			 "and s_r.sp_role_id = s.sp_rights_role_id " + 
			 "and s_u.sp_user_login = '" + userLogin +"'";
			
			Statement statement = getDatabaseService().getConnection().createStatement();
			rs = statement.executeQuery(sql);
			logger.info(sql);
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return rs;
	}
	
}
