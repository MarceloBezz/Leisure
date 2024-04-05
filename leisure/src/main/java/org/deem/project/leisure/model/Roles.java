package org.deem.project.leisure.model;

import java.io.Serializable;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PERFIL")
public class Roles implements GrantedAuthority{
    //private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable = false)
    private Long roleId;
    @Column(name="TIPO", nullable = false)
    private String role;

    @Override
    public String getAuthority() {
        return this.role.toString();
    }

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Roles() {
		
	}
	
	public Roles(String role) {
		this.role = role;
	}
	
	public Roles(Long roleId, String role) {
		this.roleId = roleId;
		this.role = role;
	}
    
}
