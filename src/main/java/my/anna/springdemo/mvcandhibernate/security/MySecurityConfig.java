package my.anna.springdemo.mvcandhibernate.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		UserBuilder ub = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser(ub.username("anna").password("anna").roles("EMPLOYEE"))
		.withUser(ub.username("olga").password("olga").roles("HR"))
		.withUser(ub.username("ii").password("ii").roles("MANAGER", "HR"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests()
		.antMatchers("/myEmpApp/").hasAnyRole("EMPLOYEE","HR","MANAGER")
		.antMatchers("/myEmpApp/hr_info").hasRole("HR")
		.antMatchers("/myEmpApp/manager_info/**").hasRole("MANAGER")
		.and().formLogin().permitAll();
	}
	
	



}
