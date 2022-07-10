package com.iitr.gl.lab6.studentmgmt.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.iitr.gl.lab6.studentmgmt.entity.Role;
import com.iitr.gl.lab6.studentmgmt.entity.User;

public class StudentMgmtUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;

	private User user;

	public StudentMgmtUserDetails(User theUser) {
		this.user = theUser;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return this.user.getRoles()
				.stream()
				.map(Role::getRoleName)
				.map(roleName -> "ROLE_" + roleName)
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toSet());

	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
