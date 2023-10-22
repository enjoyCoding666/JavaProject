package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by lenovo on  三月
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private String name;
	private String password;
	private String email;
	private Address address;


}
