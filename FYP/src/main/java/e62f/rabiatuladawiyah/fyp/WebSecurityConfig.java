/**
 * 
 * I declare that this code was written by me, Rabiatul Adawiyah. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Rabiatul Adawiyah
 * Student ID: 20021900
 * Class: E62F
 * Date created: 2022-May-06 2:23:57 pm 
 * 
 */

package e62f.rabiatuladawiyah.fyp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author 20021900
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Bean

	public CorpUserDetailsService CorpUserDetailsService() {

		return new CorpUserDetailsService();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

		authProvider.setUserDetailsService(CorpUserDetailsService());

		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Override

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
           
				  //Admin-Users
				.antMatchers( "/users/edit/*", "/users/delete/*")
				.hasRole("ADMIN")
				  //Admin-Users
				.antMatchers("/users","/users/add", "/users/edit/*", "/users/save", "/users/delete/*")
				.hasRole("ADMIN")
				 //Admin-Employee,Managers,Counter staff
				.antMatchers("/employee/add", "/employee/edit/*", "/employee/save", "/employee/delete/*","/managers/add","/managers","/managers/edit/*","/managers/delete/*","/counterstaff","counterstaff/add","/counterstaff/edit/*","/counterstaff/delete/*")
				.hasRole("ADMIN")
				  //Admin-Package
				.antMatchers("/packages/add", "/packages/edit/*", "/packages/save", "/packages/delete/*")
				.hasRole("ADMIN")
				  //Admin-Package items
				.antMatchers("/items/add", "/items/edit/*", "/items/save", "/items/delete/*")
				.hasRole("ADMIN")
				 //Admin-Package
				.antMatchers("/company/add", "/company/edit/*", "/company/save", "/company/delete/*")
				.hasRole("ADMIN")
				//HR, Admin 
				 .antMatchers("/company","/employee/add","employee/save", "/employee/edit/*").hasAnyRole("HR", "ADMIN")
				//HR, Admin , CS
				 .antMatchers("/company","/employee").hasAnyRole("HR", "ADMIN","COUNTERSTAFF")
				 //COUNTERSTAFF and ADMIN
					.antMatchers("/patients","/patients/add", "/patients/edit/*", "/patients/save", "/patients/delete/*")
					.hasAnyRole("ADMIN","COUNTERSTAFF")
				 
			
				.antMatchers("/","/bootstrap/*/*","/packages","/aboutus","/contactus","/home","/items","/users","/users/add","/users/save").permitAll()
				.antMatchers("/images/*").permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login")
				.permitAll().defaultSuccessUrl("/home").and().logout().logoutUrl("/logout").permitAll().and().exceptionHandling()
				.accessDeniedPage("/403");

	}
}
