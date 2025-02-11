package com.mosweet.Mosweet.Mosweet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;


//@EnableJpaRepositories(
//		basePackages = "com.mosweet.Mosweet.Mosweet.repository.PostgreSQL", // Путь к JPA-репозиториям
//		excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "com.mosweet.Mosweet.Mosweet.repository.Redis.*")
//)
//@EnableRedisRepositories(
//		basePackages = "com.mosweet.Mosweet.Mosweet.repository.Redis", // Путь к Redis-репозиториям
//		excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "com.mosweet.Mosweet.Mosweet.repository.PostgreSQL.*")
//)
@SpringBootApplication
public class MosweetApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(MosweetApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MosweetApplication.class);
	}
}
