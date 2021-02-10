package com.study.studyspringsecurity;

import com.study.studyspringsecurity.entity.User;
import com.study.studyspringsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@RequiredArgsConstructor
@SpringBootApplication
public class StudyspringsecurityApplication implements CommandLineRunner {

	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudyspringsecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		User user1 = new User();
		user1.setId(1L);
		user1.setAdmin(true);
		user1.setEmail("teste@estudos.com.br");
		user1.setName("user");
		user1.setPassword(encoder.encode("123"));

		User user2 = new User();
		user2.setId(2L);
		user2.setAdmin(false);
		user2.setEmail("teste@estudos.com.br");
		user2.setName("admin");
		user2.setPassword(encoder.encode("123"));

		userRepository.saveAll(Arrays.asList(user1,user2));
	}

}
