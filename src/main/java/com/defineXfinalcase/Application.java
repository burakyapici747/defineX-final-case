package com.defineXfinalcase;

import com.defineXfinalcase.model.Role;
import com.defineXfinalcase.model.User;
import com.defineXfinalcase.repository.RoleRepository;
import com.defineXfinalcase.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class Application implements CommandLineRunner {
	private final RoleRepository roleRepository;
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public Application(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.roleRepository = roleRepository;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Role role = new Role("ADMIN");
		User user = new User("burakyapici747@gmail.com", passwordEncoder.encode("123123"), "Burak", "YAPICI");
		user.getRoles().add(roleRepository.save(role));
		userRepository.save(user);
	}

}
