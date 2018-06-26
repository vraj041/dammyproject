package com.everest.amcu.dao;

import java.util.List;

import com.everest.amcu.model.User;

public interface Daoclass {

	public boolean insert(User insertobj);

	public List<User> fetchAll();

	public boolean delete(User insertobj);

	public boolean update(User user1);

}
