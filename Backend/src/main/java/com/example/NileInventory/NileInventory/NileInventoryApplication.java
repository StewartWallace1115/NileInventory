package com.example.NileInventory.NileInventory;

import org.flywaydb.core.api.*;
import org.flywaydb.core.api.callback.Callback;
import org.flywaydb.core.api.configuration.Configuration;
import org.flywaydb.core.api.migration.JavaMigration;
import org.flywaydb.core.api.pattern.ValidatePattern;
import org.flywaydb.core.api.resolver.MigrationResolver;
import org.flywaydb.core.internal.plugin.PluginRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Map;

@SpringBootApplication
public class NileInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(NileInventoryApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**").allowedOrigins("*").allowedHeaders("*").allowCredentials(false).maxAge(3600);
//
////                        .allowedOrigins("http://localhost.com")
////                        .allowedMethods("PUT", "DELETE")
////                        .allowedHeaders("header1", "header2", "header3")
////                        .exposedHeaders("header1", "header2")
//			}
//		};
//	}
}
