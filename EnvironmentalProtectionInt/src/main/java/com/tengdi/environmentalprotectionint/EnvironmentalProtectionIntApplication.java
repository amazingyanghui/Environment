package com.tengdi.environmentalprotectionint;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages= {"com.tengdi"})
@MapperScan(basePackages = {"com.tengdi.*.modules.*.dao"})
@EnableScheduling
@ServletComponentScan
public class EnvironmentalProtectionIntApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(EnvironmentalProtectionIntApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EnvironmentalProtectionIntApplication.class);
	}
}
