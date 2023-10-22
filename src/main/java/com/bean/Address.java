package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\3\6 0006 23:31
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	private String country;
	private String province;
	private String city;



}
