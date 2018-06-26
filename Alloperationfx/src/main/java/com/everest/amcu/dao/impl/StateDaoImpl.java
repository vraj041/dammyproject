package com.everest.amcu.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.everest.amcu.dao.StateDao;
import com.everest.amcu.model.State;

@Repository
public class StateDaoImpl implements StateDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<State> fetchAll() {
		try {
			List<State> listState = entityManager.createQuery("SELECT state from State state", State.class)
					.getResultList();
			return listState;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
