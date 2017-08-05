package com.niit.ekartback.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ekartback.model.Category;
import com.niit.ekartback.model.Role;

@Repository
public class RoleDAOImpl implements RoleDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(Role role) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(role);
	}

	public void update(Role role) {
		Session session=sessionFactory.getCurrentSession();
		session.update(role);
	}

	public List<Role> list() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Role");
		List<Role> roleList=query.list();
		return roleList;
	}

	public void delete(Role role) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(role);
	}

	public Role getByUserId(int userId) {
		Session session=sessionFactory.getCurrentSession();
		Role role=(Role) session.get(Category.class, userId);
		return role;
	}

}
