package com.everest.amcu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.everest.amcu.dao.Daoclass;
import com.everest.amcu.model.User;
import com.everest.amcu.service.Services;

@Service
public class Serviceimpl implements Services {

	@Autowired
	Daoclass daoclass;

	@Override
	@Transactional
	public boolean insert(User insertobj) {

		return daoclass.insert(insertobj);
	}

	 @Override
	 @Transactional
	 public List<User> fetchAll() {

	 return daoclass.fetchAll();
	 }

	@Override
	 @Transactional
	public boolean delete(User user) {
		 return  daoclass.delete(user);
		
	}

	@Override
	@Transactional
	public boolean update(User user1) {
		 
		return daoclass.update(user1);
	}

	 

}
