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

import fr.ginestra.plaqueMoiBack.errors.excpetion.PersonException;
import fr.ginestra.plaqueMoiBack.model.Person;
import fr.ginestra.plaqueMoiBack.service.PersonService;

import static fr.ginestra.plaqueMoiBack.security.ApplicationUserRole.*;

import java.util.ArrayList;
import java.util.List;

import static fr.ginestra.plaqueMoiBack.security.ApplicationUserPermission.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{
	private final PersonService personService;
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public ApplicationSecurityConfig(PasswordEncoder passwordEncoder, PersonService personService) {
		this.personService = personService;
		this.passwordEncoder = passwordEncoder;
	}
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.cors().
			and().authorizeRequests()
			.antMatchers("/").permitAll()
			//.antMatchers("/person").permitAll()
			.antMatchers("/person**").hasRole(ADMIN.name())
			.antMatchers("/conversations**").hasAuthority(ADMIN_READ.getPermission())
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
	}

	
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		List<UserDetails> userDetailList = new ArrayList<UserDetails>();
		try {
			Person p = new Person();
			p.setPlateNumber("AAAA");
			p.setUserName("Alex");
			p.setPassword(this.passwordEncoder.encode("alexpassword"));
			p.setRole(USER.name());
			this.personService.savePerson(p);

			p = new Person();
			p.setPlateNumber("BBBB");
			p.setUserName("Jean");
			p.setPassword(this.passwordEncoder.encode("jeanpassword"));
			p.setRole(USER.name());
			this.personService.savePerson(p);

			p = new Person();
			p.setPlateNumber("CCCC");
			p.setUserName("Admin");
			p.setPassword(this.passwordEncoder.encode("adminpassword"));
			p.setRole(ADMIN.name());
			this.personService.savePerson(p);
			
			
		} catch (PersonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Person person : this.personService.getPersons()) {
			userDetailList.add(User.builder()
									.username(person.getUserName())
									.password(person.getPassword())
									.roles(person.getRole())
									.build());
		}
		
		UserDetails[] userDetailTab = new UserDetails[userDetailList.size()];
		userDetailList.toArray(userDetailTab);
			
		return new InMemoryUserDetailsManager(userDetailTab);
	}
}
