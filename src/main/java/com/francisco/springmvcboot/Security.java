package com.francisco.springmvcboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetails userDetails;

	@Bean
	public DaoAuthenticationProvider daoap() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setUserDetailsService(userDetails);
		dao.setPasswordEncoder(new BCryptPasswordEncoder());
		return dao;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		http.csrf().ignoringAntMatchers("/api/**").and().authorizeRequests().anyRequest().authenticated().and()
				.formLogin().loginPage("/login").defaultSuccessUrl("/").failureUrl("/loginerror")
				.loginProcessingUrl("/loginAction").permitAll().and().logout().permitAll();

	}

}
