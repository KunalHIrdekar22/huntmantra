package com.userRegidtrstion.servicer;

import com.userRegidtrstion.modelVo.UserDetailsVo;
import com.userRegidtrstion.modelVo.UserSignIn;

public interface UserRegistrationService {

	UserDetailsVo saveUserDetails(UserDetailsVo userDEtailsVO);

	UserDetailsVo getUser(UserSignIn userSignIn);

}
