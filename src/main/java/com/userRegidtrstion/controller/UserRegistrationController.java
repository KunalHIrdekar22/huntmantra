package com.userRegidtrstion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userRegidtrstion.exceptionHandler.EmailAlreadyExist;
import com.userRegidtrstion.exceptionHandler.ResourceNotFoundException;
import com.userRegidtrstion.model.UserDetails;
import com.userRegidtrstion.modelVo.UserDetailsVo;
import com.userRegidtrstion.modelVo.UserSignIn;
import com.userRegidtrstion.servicer.UserRegistrationService;

@RestController
@RequestMapping("/userRegistration")
public class UserRegistrationController {
	@Autowired
	UserRegistrationService userRegistrationService;
	
	@PostMapping("/SignUp")
	  public ResponseEntity<UserDetailsVo> saveUser(@RequestBody UserDetailsVo userDEtailsVO,Model model) 
	  { 
		
		UserDetailsVo userDtlsVo=userRegistrationService.saveUserDetails(userDEtailsVO);
		return new ResponseEntity<UserDetailsVo>(userDtlsVo,HttpStatus.OK);
	  }
	
	@PostMapping("/SignIn")
	  public ResponseEntity<UserDetailsVo> getUser(@RequestBody UserSignIn userSignIn) 
	  { if(userSignIn.getUsername()==null || userSignIn.getPassword()==null)
	  {
			return new ResponseEntity<UserDetailsVo>(new UserDetailsVo(),HttpStatus.NOT_FOUND);
	  }
		UserDetailsVo userDtlsVo1= userRegistrationService.getUser(userSignIn);
			
		return new ResponseEntity<UserDetailsVo>(userDtlsVo1,HttpStatus.OK);
	  }
	/**/
	 
}
