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
@Table(name = "tbl_person")
public class User {

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "first_name", length = 50)
	private String firstname;

	@Column(name = "last_name", length = 50)
	private String lastname;

	@Column(name = "mobile", length = 12)
	private String mobile;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "state_code", foreignKey = @ForeignKey(name = "fk_person_state_code"))
	private State stateCode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "district_code", foreignKey = @ForeignKey(name = "fk_person_district_code"))
	private District districtCode;

	public User(int id, String firstname, String lastname, String mobile, String state, String district) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobile = mobile;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public State getStateCode() {
		return stateCode;
	}

	public void setStateCode(State stateCode) {
		this.stateCode = stateCode;
	}

	public District getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(District districtCode) {
		this.districtCode = districtCode;
	}

	public User() {

	}

}
