package com.niit.ekartback.DAO;

import java.util.List;

import com.niit.ekartback.model.Role;

public interface RoleDAO {

	public void save(Role role);

	public void update(Role role);
	
	public List<Role> list();
	
	public void delete(Role role);
	
	public Role getByUserId(int userId);
	
	
}
