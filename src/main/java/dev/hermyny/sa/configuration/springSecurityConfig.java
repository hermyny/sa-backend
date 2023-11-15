package dev.hermyny.sa.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;





@EnableMethodSecurity
@Configuration
@EnableWebSecurity
public class springSecurityConfig {
	

	
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception {
//		return 
//				httpSecurity
//					.csrf(AbstractHttpConfigurer::disable)
//					.authorizeHttpRequests(
//						authorize ->
//								authorize.requestMatchers("/").permitAll()
//									
//									.anyRequest().authenticated()
//						).build();		
//		}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http.authorizeHttpRequests(authorizeRequests -> authorizeRequests.anyRequest()
	      .permitAll())
	      .csrf(AbstractHttpConfigurer::disable);
	    return http.build();
	}
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}


	
	

