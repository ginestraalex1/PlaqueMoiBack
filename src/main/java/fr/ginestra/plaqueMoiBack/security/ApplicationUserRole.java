package fr.ginestra.plaqueMoiBack.security;

import java.util.HashSet;
import java.util.Set;


public enum ApplicationUserRole {

	USER(ApplicationUserPermission.USER_READ, ApplicationUserPermission.USER_WRITE),
	ADMIN(ApplicationUserPermission.ADMIN_READ, ApplicationUserPermission.ADMIN_WRITE);
	
	private final Set<ApplicationUserPermission> permissions;
	
	ApplicationUserRole(ApplicationUserPermission... permissions){
		this.permissions = new HashSet<ApplicationUserPermission>();
		for(ApplicationUserPermission permission : permissions) {
			this.permissions.add(permission);
		}
	}
	
	public Set<ApplicationUserPermission> getPermissions(){
		return this.permissions;
	}
}
