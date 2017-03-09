package com.fashion.secutity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserInSession extends User {
	private Integer id;

	private static final long serialVersionUID = 1L;

	public UserInSession(Integer id, String username, String password,
						 boolean enabled, boolean accountNonExpired,
						 boolean credentialsNonExpired, boolean accountNonLocked,
						 Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
