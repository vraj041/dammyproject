package com.everest.amcu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_states")
public class State {

	@Id
	@Column(name = "id", length = 30)
	private int stateCode;

	@Column(name = "state_name", length = 50)
	private String stateName;

	public State() {
	}

	public int getCode() {
		return stateCode;
	}

	public void setCode(int code) {
		this.stateCode = code;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return this.getStateName();
	}

}
