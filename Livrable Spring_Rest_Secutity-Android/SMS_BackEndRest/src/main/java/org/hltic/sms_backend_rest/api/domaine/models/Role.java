package org.hltic.sms_backend_rest.api.domaine.models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
	
  ROLE_ADMIN, ROLE_USER, ROLE_GUEST;

  public String getAuthority() {
    return name();
  }

}
