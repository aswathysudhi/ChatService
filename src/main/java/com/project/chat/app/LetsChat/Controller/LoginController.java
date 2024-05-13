package com.project.chat.app.LetsChat.Controller;

import java.util.Collections;

import com.project.chat.app.LetsChat.Data.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.chat.app.LetsChat.Data.LoginDetails;
import com.project.chat.app.LetsChat.Model.AuthenticationRequest;
import com.project.chat.app.LetsChat.Model.AuthenticationResponse;
import com.project.chat.app.LetsChat.Util.JwtUtil;
import com.project.chat.app.LetsChat.Util.TestUtil;
import com.project.chat.app.LetsChat.service.LoginService;

@RestController
public class LoginController {
 
	@Autowired
	LoginService userService;


	@Autowired
    private JwtUtil jwtUtil;
	
	@SuppressWarnings("static-access")
	@PostMapping("/loginChat")
	@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {
        // Authenticate user and generate JWT token
        final LoginDetails login = userService.loadUserByUsername(authenticationRequest.getUsername(),authenticationRequest.getPassword());
        final String token = jwtUtil.generateToken(login);
        
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }
	
	@PostMapping("/register")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Object> registerUser(@RequestBody LoginDetails user) {
        // You can add validation and error handling as needed
        if (userService.usernameExists(user.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap("message", "User already Exists"));
        }

        userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap("message", "User Created"));
    }

	@PostMapping("/getUser")
	public UserDetails getUser(@RequestParam String name){
		return userService.getUserByName(name);
	}
	
}
