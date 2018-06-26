package com.everest.amcu.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.everest.amcu.dao.DistrictDao;
import com.everest.amcu.model.District;
import com.everest.amcu.model.State;
@Repository
public class DistrictDaoImpl implements DistrictDao {

	@PersistenceContext
	EntityManager entityManager;
//
//	@Override
//	public District fetchByCode(int intCode) {
//		try {
//			District District = entityManager
//					.createQuery("SELECT d from District d LEFT JOIN FETCH d.stateCode"
//							+ "WHERE d.districtCode = :districtCode", District.class)
//					.setParameter("districtCode", intCode).getSingleResult();
//			return District;
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			return null;
//		}
//	}
	@Override
	public List<District> fetchAll(State state) {
		try {
			List<District> listDis = entityManager.createQuery("SELECT d from District d LEFT JOIN FETCH d.stateCode"
					+ " WHERE d.stateCode = :state",  District.class)
					.setParameter("state",state).getResultList();
			return listDis;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
