package com.userRegidtrstion.modelVo;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsVo  {
	private String name;
	private long number;
	private String email;
	private String password;
//	private String msg; 

}
