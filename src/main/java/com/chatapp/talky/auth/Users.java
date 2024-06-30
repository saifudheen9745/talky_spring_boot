package com.chatapp.talky.auth;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table
@Entity
public class Users {

    @Id
    @SequenceGenerator(
        initialValue=1,
        allocationSize=1,
        name="user_id_sequence",
        sequenceName="user_id_sequence"
    )
    @GeneratedValue(
        strategy=GenerationType.SEQUENCE,
        generator="user_id_sequence"
    )
    private Long id;
    private String name;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String email;
    private String password;

    
    
    public Users() {
    }

    public Users(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Users(String email, Long id, String name, String password) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.password = password;
    }
}
