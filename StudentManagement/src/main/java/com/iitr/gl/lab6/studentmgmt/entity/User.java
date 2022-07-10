package com.iitr.gl.lab6.studentmgmt.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long id;

	@Column(name = "user_name", nullable = false, unique = true)
	private String name;

	@Column(name = "user_password")
	private String password;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name="user_userrole",
			joinColumns= {@JoinColumn(name="user_id")},
			inverseJoinColumns = {@JoinColumn(name="role_id")}
			)
	private Set<Role> roles = new HashSet<Role>();

	public User(String name, String password, Set<Role> roles) {
		super();
		this.name = name;
		this.password = password;
		this.roles = roles;
	}

	public User() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		
		if (this.roles == null){
            this.roles = new HashSet<>();
        }
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public void addRole(Role role) {
		if(this.roles == null) {
			this.roles = new HashSet<Role>();
		}
		
		this.roles.add(role);
		role.getGlusers().add(this);
	}

	@Override
	public String toString() {
		return "GLUser [id=" + id + ", name=" + name + ", password=" + password + ", roles=" + roles + "]";
	}
}
