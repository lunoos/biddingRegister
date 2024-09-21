package com.bidding.register.service;

import com.bidding.register.dto.SignInRequest;
import com.bidding.register.dto.SignUpRequest;
import com.bidding.register.dto.UserResponse;

public interface UserService {
	 public UserResponse signUp(SignUpRequest signUpRequest);
	 public UserResponse signIn(SignInRequest signInRequest);
}
