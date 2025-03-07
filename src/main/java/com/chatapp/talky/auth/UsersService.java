package com.chatapp.talky.auth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.chatapp.talky.JwtService;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private JwtService jwtService;

    public Users registerUser(Users registerDetails){
        if(registerDetails.getEmail().isBlank() || registerDetails.getPassword().isBlank() || registerDetails.getName().isBlank()){
            throw new IllegalArgumentException("Require all the fields");
        }
        Optional <Users> user = this.usersRepository.findByEmail(registerDetails.getEmail());
        if(user.isPresent()){
            throw new IllegalArgumentException("Email already exists, user another email");
        }
        registerDetails.setPassword(this.hashPassword(registerDetails.getPassword()));
        return this.usersRepository.save(registerDetails);    
    }

    public Map<String, String> loginUser(Users loginDetails){
        if(loginDetails.getEmail().isBlank() || loginDetails.getPassword().isBlank()){
            throw new IllegalArgumentException("Require all the fields");
        }
        Optional <Users> user = this.usersRepository.findByEmail(loginDetails.getEmail());
        if(user.isEmpty()){
            throw new IllegalArgumentException("User not found");
        }
        boolean isCorrectPass = this.comparePassword(loginDetails.getPassword(), user.get().getPassword());
        if(!isCorrectPass){
            throw new IllegalArgumentException("Invalid Credentials");   
        } 
        Map<String, String> data = new HashMap<>(); 
        String token = this.jwtService.createJwtAccessToken(user.get().getId().toString(), user.get().getEmail());
        data.put("token", token);
        data.put("name",user.get().getName());
        data.put("email",user.get().getEmail());
        data.put("id",user.get().getId().toString());
        return data;
    }

    public List<Users> getUsers(){
        List<Users> users = null;
        try{
            users = this.usersRepository.findAll();
        }catch(Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
        return users;
    }

    public boolean comparePassword(String rawPass, String encodedPass){
        return new BCryptPasswordEncoder().matches(rawPass, encodedPass);
    }
    
    public String hashPassword(String pass){
        return new BCryptPasswordEncoder().encode(pass);
    }
}

