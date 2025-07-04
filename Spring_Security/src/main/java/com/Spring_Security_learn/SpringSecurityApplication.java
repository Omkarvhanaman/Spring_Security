package com.Spring_Security_learn;

import com.Spring_Security_learn.Repository.roleRepo;
import com.Spring_Security_learn.Repository.userRepo;
import com.Spring_Security_learn.entity.Role;
import com.Spring_Security_learn.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class SpringSecurityApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@Autowired
	 private roleRepo roleRepo;

	@Autowired
	private userRepo userRepo;

   @Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {


		      Role admin= roleRepo.findByName("ROLE_ADMIN").orElse(null);
		      Role normal= roleRepo.findByName("ROLE_NORMAL").orElse(null);
         if(admin==null){
			  admin=new Role();
			  admin.setRoleid(UUID.randomUUID().toString());
		      admin.setName("ROLE_ADMIN");
			  roleRepo.save(admin);
	       }

         if(normal==null){
			 normal=new Role();
			 normal.setRoleid(UUID.randomUUID().toString());
			 normal.setName("ROLE_NORMAL");
			 roleRepo.save(normal);
		 }



         User user= userRepo.findByUsername("vicky").orElse(null);
		  if(user==null){
			  user=new User();
			  user.setId(UUID.randomUUID().toString());
			  user.setUsername("vicky");
			  user.setPassword(passwordEncoder.encode("vicky123"));
			  user.setRoles(List.of(admin,normal));
			  userRepo.save(user);
		  }
		User user2= userRepo.findByUsername("omkar").orElse(null);
		if(user2==null){
			user2=new User();
			user2.setId(UUID.randomUUID().toString());
			user2.setUsername("omkar");
			user2.setPassword(passwordEncoder.encode("vicky123"));
			user2.setRoles(List.of(normal));
			userRepo.save(user2);
		}
	}
}
