package com.xb.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Role implements Serializable{
    private static final long serialVersionUID = -984708072989199640L;

	private String rId;

    private String rName;
    private Set<String> resources =new HashSet<String>();
    
    private Set<Permission> roles =new HashSet<Permission>();
    
    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId == null ? null : rId.trim();
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName == null ? null : rName.trim();
    }

	public Set<String> getResources() {
		return resources;
	}

	public void setResources(Set<String> resources) {
		this.resources = resources;
	}

	public Set<Permission> getRoles() {
		return roles;
	}

	public void setRoles(Set<Permission> roles) {
		this.roles = roles;
	}
    
}