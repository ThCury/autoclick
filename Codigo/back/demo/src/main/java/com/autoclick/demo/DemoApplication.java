package com.autoclick.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
    public Jackson2ObjectMapperBuilderCustomizer addCustomDeserialization() {
        return builder -> builder.modulesToInstall(new ParameterNamesModule());
    }

}
