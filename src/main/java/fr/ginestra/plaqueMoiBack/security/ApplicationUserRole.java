package fr.ginestra.plaqueMoiBack.security;

import java.util.Set;

import com.google.common.collect.Sets;

public enum ApplicationUserRole {

	USER(Sets.newHashSet()),
	ADMIN(Sets.newHashSet(ApplicationUserPermission.ADMIN_READ, ApplicationUserPermission.ADMIN_WRITE));
	
	private final Set<ApplicationUserPermission> permissions;
	
	ApplicationUserRole(Set<ApplicationUserPermission> permissions){
		this.permissions = permissions;
	}
	
	public Set<ApplicationUserPermission> getPermissions(){
		return this.permissions;
	}
	
}
