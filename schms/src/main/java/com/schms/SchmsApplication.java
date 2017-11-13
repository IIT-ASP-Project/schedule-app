package com.schms;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.schms.domain.User;
import com.schms.domain.security.Role;
import com.schms.domain.security.UserRole;
import com.schms.service.UserService;
import com.schms.utility.SecurityUtility;

@SpringBootApplication
public class SchmsApplication implements CommandLineRunner {
	
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SchmsApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		User u = new User();
		u.setUsername("Omar");
		u.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		Set<UserRole> userRoles = new HashSet<>();
		Role r = new Role();
		r.setRoleId(1);
		r.setName("ROLE_ADMIN");
		userRoles.add(new UserRole(u,r));
		userService.createUser(u, userRoles);
	}
}
	