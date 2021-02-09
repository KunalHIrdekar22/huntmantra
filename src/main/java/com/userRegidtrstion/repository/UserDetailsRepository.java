package com.userRegidtrstion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.userRegidtrstion.model.UserDetails;
@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer>{
	@Query("select user from UserDetails user where user.email=:email and user.password=:password ")
	UserDetails findUser(String email, String password);
	@Query("select count(user.id) from UserDetails user where user.email=:email") 
	int emailAlreadyExist(String email);

}
