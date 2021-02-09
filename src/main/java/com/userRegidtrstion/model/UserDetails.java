package com.userRegidtrstion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Required;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity(name = "UserDetails")
@Table(name="User_Details_Table")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="USER_ID")
	private long id;
	@Column(name="USER_NAME")
	private String name;
	@Column(name="USER_NUMBER")
	private Long number;
	@Column(name="USER_EMAIL")
	private String email;
	@Column(name="USER_PASSWORD")
	private String password;
}
