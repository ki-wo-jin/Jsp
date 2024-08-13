package com.yedam.app.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
	@Bean // 비밀번호 암호화
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// 인증 및 인가
	@Bean
	SecurityFilterChain filterCahin(HttpSecurity http) throws Exception {
		http // Security가 적용될 URI
			.authorizeHttpRequests((authrize)
		-> authrize
		.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
		.requestMatchers("/", "/all").permitAll()
		.requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
		.requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
		.anyRequest().authenticated()
		)
		.formLogin(formlogin -> formlogin
				.defaultSuccessUrl("/all"))
		.logout(logout -> logout
				.logoutSuccessUrl("/all")
				.invalidateHttpSession(true));
		
		http.csrf(csrf -> csrf.disable());
		return http.build();
	}
	
	/*@Bean // 메모리상 인증정보 등록 => 테스트 전용 방식
	InMemoryUserDetailsManager inMemeryUserDetailsService() {
		UserDetails user = User.builder()
				               .username("user1")
				               .password(passwordEncoder().encode("1234"))
				               .roles("USER") // ROLE_USER roles 메소드 사용시 값앞에 role_를 붙임
				               .authorities("ROLE_USER")
				               .build();
		
		UserDetails admin = User.builder()
								.username("admin1")
								.password(passwordEncoder().encode("1234"))
								//.roles("ADMIN") // ROLE_ADMIN
								.authorities("ROLE_ADMIN", "ROLE_USER")
								.build();
		
		return new InMemoryUserDetailsManager(user, admin);
	}*/
}
