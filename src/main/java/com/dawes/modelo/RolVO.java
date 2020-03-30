package com.dawes.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
 
@Entity
@Table(name = "roles",  uniqueConstraints = { @UniqueConstraint(name = "ROLES_UK", columnNames = "Role_Name") })
public class RolVO {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Role_Id", nullable = false)
    private Long roleId;
 
    @Column(name = "Role_Name", length = 30, nullable = false)
    private String roleName;
 
    @OneToMany(mappedBy="rol",fetch=FetchType.EAGER,cascade= {CascadeType.ALL}, orphanRemoval = true)
	private List<UsuarioRolVO> roles;
    public Long getRoleId() {
        return roleId;
    }
 
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
 
    public String getRoleName() {
        return roleName;
    }
 
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

	public List<UsuarioRolVO> getRoles() {
		return roles;
	}

	public void setRoles(List<UsuarioRolVO> roles) {
		this.roles = roles;
	}
     
}