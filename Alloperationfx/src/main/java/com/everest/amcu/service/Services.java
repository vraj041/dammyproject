package com.everest.amcu.service;

import java.util.List;

import com.everest.amcu.model.User;

public interface Services {
	
public boolean insert(User insertobj);

public List<User> fetchAll();

public boolean delete(User user);

public boolean update(User user1);
}
