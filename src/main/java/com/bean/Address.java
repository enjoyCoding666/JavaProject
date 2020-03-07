package com.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\3\6 0006 23:31
 * @Description:
 */

public class Address {
	private String country;
	private String province;
	private String city;

	public Address(String country, String province, String city) {
		this.country = country;
		this.province = province;
		this.city = city;
	}

	public Address() {
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Optional<String> getCity() {
		return Optional.ofNullable(this.city);
	}
}
