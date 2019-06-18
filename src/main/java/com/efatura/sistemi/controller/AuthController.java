package com.efatura.sistemi.controller;

import java.net.URI;
import java.util.Collections;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.efatura.sistemi.exception.AppException;
import com.efatura.sistemi.model.Role;
import com.efatura.sistemi.model.RoleName;
import com.efatura.sistemi.model.User;
import com.efatura.sistemi.payload.ApiResponse;
import com.efatura.sistemi.payload.JwtAuthenticationResponse;
import com.efatura.sistemi.payload.LoginRequest;
import com.efatura.sistemi.payload.SignUpRequest;
import com.efatura.sistemi.repository.RoleRepository;
import com.efatura.sistemi.repository.UserRepository;
import com.efatura.sistemi.security.JwtTokenProvider;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
   private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider tokenProvider;
    
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
    	
    	Authentication authentication = authenticationManager.authenticate(
    			new UsernamePasswordAuthenticationToken(
    				 loginRequest.getUsernameOrEmail(), 
    				 loginRequest.getPassword()));
    	
    	SecurityContextHolder.getContext().setAuthentication(authentication);
    	String jwt = tokenProvider.generateToken(authentication);
    	return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }
    
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest){
    	
    	if(userRepository.existsByUsername(signUpRequest.getUsername())) {
    		return new ResponseEntity<Object>(new ApiResponse(false,"Username is already token!"),HttpStatus.BAD_REQUEST);
    	}
    	
    	if(userRepository.existsByEmail(signUpRequest.getEmail())) {
    	   return new ResponseEntity<Object> (new ApiResponse(false,"Email Address is already token"),HttpStatus.BAD_REQUEST);
    	}
    	//creating user's account
    	User user = new User(
    			signUpRequest.getName(),signUpRequest.getUsername(),signUpRequest.getEmail(),
    			signUpRequest.getPassword(),signUpRequest.getPhoneNumber(),signUpRequest.getCustomerStatus(),
    			signUpRequest.getAuthorityList(),signUpRequest.getCreatedDate(),signUpRequest.getCreatedUser());
    	
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
    	Role userRole= roleRepository.findByName(
    			RoleName.ROLE_USER)
    			.orElseThrow(()-> new AppException("User Role not set."));
    	
    	user.setRoles(Collections.singleton(userRole));
    	User result = userRepository.save(user);
    	URI location = ServletUriComponentsBuilder
    			.fromCurrentContextPath().path("/api/users/{username}")
    			.buildAndExpand(result.getUsername()).toUri();
    	return  ResponseEntity.created(location).body(new ApiResponse(true,"User registered successfully"));
    }
}
