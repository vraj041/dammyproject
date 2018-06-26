package com.everest.amcu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_districts")
public class District {

	@Id
	@Column(name = "district_code", length = 30)
	private int districtCode;

	@Column(name = "district_name", length = 100)
	private String districtName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "state_code", foreignKey = @ForeignKey(name = "fk_district_state_code"))
	private State stateCode;

	public District() {
	}

	public int getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(int districtCode) {
		this.districtCode = districtCode;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public State getStateCode() {
		return stateCode;
	}

	public void setStateCode(State stateCode) {
		this.stateCode = stateCode;
	}

	@Override
	public String toString() {
		return this.getDistrictName();
	}
}
