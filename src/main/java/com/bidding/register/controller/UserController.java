package com.bidding.register.controller;

import org.springdoc.core.annotations.RouterOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bidding.register.dto.SignInRequest;
import com.bidding.register.dto.SignUpRequest;
import com.bidding.register.dto.UserResponse;
import com.bidding.register.service.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/auth")
public class UserController {

	@Autowired
    private UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<UserResponse> signUp(@Valid @RequestBody SignUpRequest signUpRequest) {
        UserResponse userResponse = userService.signUp(signUpRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<UserResponse> signIn(@Valid @RequestBody SignInRequest signInRequest) {
        UserResponse userResponse = userService.signIn(signInRequest);
        return ResponseEntity.ok(userResponse);
    }
}