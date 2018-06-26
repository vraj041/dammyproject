package com.everest.amcu.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.everest.amcu.dao.Daoclass;
import com.everest.amcu.model.User;

@Repository
public class Daoclassimpl implements Daoclass {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public boolean insert(User insertobj) {
		try {
			entityManager.persist(insertobj);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public List<User> fetchAll() {
		System.out.println("dao impl call");
		List<User> listPer = entityManager.createQuery("select state from User state", User.class).getResultList();
		return listPer;

	}

	@Override
	public boolean delete(User insertobj) {
		System.out.println("delete");
		entityManager.remove(entityManager.contains(insertobj) ? insertobj : (entityManager.merge(insertobj)));
		return true;
	}

	@Override
	public boolean update(User user1) {
		System.out.println("update call last");
		entityManager.merge(user1);
		return true;
	}

}
