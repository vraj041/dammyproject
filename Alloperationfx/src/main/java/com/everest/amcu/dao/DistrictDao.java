package com.everest.amcu.dao;

import java.util.List;

import com.everest.amcu.model.District;
import com.everest.amcu.model.State;

public interface DistrictDao {

//	public District fetchByCode(int intCode);

	public	List<District> fetchAll(State state);

}
