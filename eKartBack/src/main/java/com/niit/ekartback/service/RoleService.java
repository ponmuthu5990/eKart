package com.niit.ekartback.service;

import java.util.List;

import com.niit.ekartback.model.Role;

public interface RoleService {
	public void save(Role role);

	public void update(Role role);
	
	public List<Role> list();
	
	public void delete(Role role);
	
	public Role getByUserId(int userId);
}
