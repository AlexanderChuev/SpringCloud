package com.example.authservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

	/*@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repository) throws Exception {
		if(repository.count() == 0){
			repository.save(new User("user","user", Arrays.asList(new Role("USER"), new Role("ACTUATOR"))));
		}
		builder.userDetailsService(s -> new CustomUserDetails(repository.findByUsername(s)));
	}*/
}
