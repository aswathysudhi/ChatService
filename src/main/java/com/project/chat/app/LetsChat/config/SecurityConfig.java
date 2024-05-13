package com.project.chat.app.LetsChat.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	 @Bean
	    public BCryptPasswordEncoder bCryptPasswordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	 
	 @SuppressWarnings("removal")
	@Bean
	 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			
			  http .authorizeRequests(authorize -> authorize .anyRequest().permitAll() )
			  .formLogin(withDefaults()) .httpBasic(withDefaults());
			 
		 http.csrf().disable();
	 	
		 return http.build();
	 }
	 
}
