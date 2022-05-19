package pe.edu.upc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pe.edu.upc.auth.handler.LoginSuccessHandler;
import pe.edu.upc.serviceimpl.JpaUserDetailsService;



@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private LoginSuccessHandler successHandler;
	
	protected void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		try {
			http.authorizeRequests()
	            .antMatchers("/").permitAll() // This will be your home screen URL
	            .antMatchers("/css/**").permitAll()
	            .antMatchers("/js/**").permitAll()
	            .antMatchers("/img/**").permitAll()
	        	.antMatchers("/estudent/**").access("hasRole('ROLE_Administrador')")
				.antMatchers("/teacher/**").access("hasRole('ROLE_Administrador')")
				.antMatchers("/course/**").access("hasRole('ROLE_Estudiante')")	
				.antMatchers("/perfil/**").access("hasRole('ROLE_Estudiante')")	
				.antMatchers("/reports/**").access("hasRole('ROLE_Administrador')")
				.antMatchers("/registration/**").access("hasRole('ROLE_Estudiante')")
			.and()
				.formLogin().successHandler(successHandler).loginPage("/login").defaultSuccessUrl("/login").permitAll()
			.and()
				.logout().permitAll()
			.and()
				.exceptionHandling().accessDeniedPage("/error_403");

				
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
