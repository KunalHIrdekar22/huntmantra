package com.userRegidtrstion.servicer;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userRegidtrstion.exceptionHandler.EmailAlreadyExist;
import com.userRegidtrstion.exceptionHandler.ResourceNotFoundException;
import com.userRegidtrstion.model.UserDetails;
import com.userRegidtrstion.modelVo.UserDetailsVo;
import com.userRegidtrstion.modelVo.UserSignIn;
import com.userRegidtrstion.repository.UserDetailsRepository;
@Service
@Transactional
public class UserRegistrationServiceImpl implements UserRegistrationService{
	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	@Override
	public UserDetailsVo saveUserDetails(UserDetailsVo userDEtailsVO) {
		int count=userDetailsRepository.emailAlreadyExist(userDEtailsVO.getEmail());
		if(count>0) throw new EmailAlreadyExist("Email already exist");
		
		UserDetails userDetails=new UserDetails();
		userDetails.setEmail(userDEtailsVO.getEmail());
		userDetails.setName(userDEtailsVO.getName());
		userDetails.setNumber(userDEtailsVO.getNumber());
		userDetails.setPassword(userDEtailsVO.getPassword());
		UserDetails details=userDetailsRepository.save(userDetails);
		//userDEtailsVO.setId(details.getId());
		return userDEtailsVO;
	}

	@Override
	public UserDetailsVo getUser(UserSignIn userSignIn) {
		UserDetails details=
				userDetailsRepository.findUser(userSignIn.getUsername(),userSignIn.getPassword());
		//if(details==null) 
		if(details==null) throw new ResourceNotFoundException("Resource not found");
		
		UserDetailsVo userDetails=new UserDetailsVo();
		userDetails.setEmail(details.getEmail());
		userDetails.setName(details.getName());
		userDetails.setNumber(details.getNumber());
		userDetails.setPassword(details.getPassword());
		
		return userDetails;
	}

}
