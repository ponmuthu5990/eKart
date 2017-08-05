package com.niit.ekartback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ekartback.DAO.RoleDAO;
import com.niit.ekartback.model.Role;


@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDAO roleDAO;
	
	public void save(Role role) {
roleDAO.save(role);
	}

	public void update(Role role) {
		roleDAO.update(role);
	}

	public List<Role> list() {
		// TODO Auto-generated method stub
		return roleDAO.list();
	}

	public void delete(Role role) {
	roleDAO.delete(role);
	}

	public Role getByUserId(int userId) {
		// TODO Auto-generated method stub
		return roleDAO.getByUserId(userId);
	}

}
