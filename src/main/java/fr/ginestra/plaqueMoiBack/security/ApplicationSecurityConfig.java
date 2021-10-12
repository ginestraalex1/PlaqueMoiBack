package fr.ginestra.plaqueMoiBack.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static fr.ginestra.plaqueMoiBack.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/person**").hasRole(USER.name())
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
	}

	
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		UserDetails alexUser = User.builder()
				.username("Alex")
				.password(this.passwordEncoder.encode("password"))
				.roles(USER.name())
				.build();
		
		UserDetails adminUser = User.builder()
			.username("Admin")
			.password(this.passwordEncoder.encode("adminpassword"))
			.roles(ADMIN.name())
			.build();
			
		return new InMemoryUserDetailsManager(
				alexUser,
				adminUser
			);
		
	}
}
