package com.cht.entity;

import java.io.Serializable;
import java.sql.Date;

public class Country implements Serializable {
	private Short country_id;
	public Short getCountry_id() {
		return country_id;
	}
	public void setCountry_id(Short country_id) {
		this.country_id = country_id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLast_update() {
		return last_update;
	}
	public void setLast_update(String string) {
		this.last_update = string;
	}
	private String country;
	private String last_update;
}
