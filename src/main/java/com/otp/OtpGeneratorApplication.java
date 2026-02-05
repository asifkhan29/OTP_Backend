package com.otp;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@OpenAPIDefinition(
		info = @Info(
				title = "OTP Generator API",
				version = "1.0",
				description = "APIs for generating time-based One Time Password (OTP)",
				contact = @Contact(
						name = "Abdul Moyeen",
						email = "moyeenkhan47@gmail.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://github.com/moyeenkhan47"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "OTP Generator Service Documentation",
				url = "https://github.com/moyeenkhan47"
		)
)
public class OtpGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtpGeneratorApplication.class, args);
	}

}
