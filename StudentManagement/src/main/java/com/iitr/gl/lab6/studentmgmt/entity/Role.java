package com.iitr.gl.lab6.studentmgmt.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private long roleId;

	@Column(name = "role_name", nullable = false, unique = true)
	private String roleName;

	@ManyToMany(mappedBy = "roles")
	private Set<User> users = new HashSet<User>();

	public Role(String roleName, Set<User> users) {
		super();
		this.roleName = roleName;
		this.users = users;
	}

	public Role() {
		super();
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<User> getGlusers() {

		if (this.users == null) {
			this.users = new HashSet<>();
		}
		return users;
	}

	public void setGlusers(Set<User> users) {
		this.users = users;
	}
}
