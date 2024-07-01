package com.chatapp.talky.auth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatapp.talky.HttpResponse;

@RestController
@RequestMapping(path="/api/v1/user/auth", produces=MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins="http://localhost:4300")
public class UsersController {

    @Autowired
    private UsersService  usersService;

    @SuppressWarnings("rawtypes")
    @PostMapping("/register")
    public ResponseEntity<HttpResponse> registerUser(@RequestBody Users registerDetails) {
        try {
            System.out.println(registerDetails);
            Users createdUser = this.usersService.registerUser(registerDetails);
            if(createdUser != null){
                return new ResponseEntity<>(new HttpResponse<>("User created successfully", true, List.of(createdUser)), HttpStatus.CREATED);
            }else{
                throw new IllegalArgumentException("User creation failed");
            }
        } catch (Exception e) {
            System.out.println("e");
            return new ResponseEntity<>(new HttpResponse<>(e.getMessage(), false, List.of()), HttpStatus.BAD_REQUEST);
        }
    }

    @SuppressWarnings("rawtypes")
    @PostMapping("/login")
    public ResponseEntity<HttpResponse> loginUser(@RequestBody Users loginDetails) {
        try {
            Map<String, String> data = this.usersService.loginUser(loginDetails);
            if(data != null && !data.isEmpty()){
                return new ResponseEntity<>(new HttpResponse<>("User logged In successfully", true, List.of(data)), HttpStatus.CREATED);
            }else{
                throw new IllegalArgumentException("User login failed");
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new HttpResponse<>(e.getMessage(), false, List.of()), HttpStatus.BAD_REQUEST);
        }
    }
    

}
