package com.teamdae.certificates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
@EnableJpaRepositories("com.teamdae.certificates.persistence.repository")
@EntityScan("com.teamdae.certificates.persistence.entity")

public class CertificatesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CertificatesApplication.class, args);
	}

}
