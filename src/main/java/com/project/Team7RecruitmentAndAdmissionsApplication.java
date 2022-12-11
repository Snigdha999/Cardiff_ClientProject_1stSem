package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.project.repository.AccountsRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = AccountsRepository.class)
public class Team7RecruitmentAndAdmissionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Team7RecruitmentAndAdmissionsApplication.class, args);
	}

}
