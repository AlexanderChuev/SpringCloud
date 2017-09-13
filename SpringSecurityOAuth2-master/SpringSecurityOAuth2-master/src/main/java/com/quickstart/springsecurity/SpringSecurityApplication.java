package com.quickstart.springsecurity;

import com.quickstart.springsecurity.model.CustomUserDetails;
import com.quickstart.springsecurity.model.Role;
import com.quickstart.springsecurity.model.User;
import com.quickstart.springsecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;

@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repository) throws Exception {
        if(repository.count() == 0){
            repository.save(new User("user","user", Arrays.asList(new Role("USER"), new Role("ACTUATOR"))));
        }
        builder.userDetailsService(s -> new CustomUserDetails(repository.findByUsername(s)));
    }

}
