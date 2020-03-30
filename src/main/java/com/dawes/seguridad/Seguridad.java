package com.dawes.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class Seguridad extends WebSecurityConfigurerAdapter {
	/*
	 * https://docs.spring.io/spring-security/site/docs/4.0.x/apidocs/org/springframework/security/config/annotation/authentication/builders/AuthenticationManagerBuilder.html
	 */
	
	// este bean permite que spring codifique y decodifique las contraseñas
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
	@Override
	protected void configure(HttpSecurity http) throws Exception {
			//http.csrf().disable();
    	   
           // The pages does not require login
           http.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll();
    
           // /userInfo page requires login as ROLE_USER or ROLE_ADMIN.
           // If no login, it will redirect to /login page.
           http.authorizeRequests().antMatchers("/registrado").access("hasAnyRole('USER', 'ADMIN')");
    
           // For ADMIN only.
           http.authorizeRequests().antMatchers("/admin").access("hasRole('ADMIN')");
    
           // When the user has logged in as XX.
           // But access a page that requires role YY,
           // AccessDeniedException will be thrown.
           http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
    
           // Configuramos la página de login
           http.authorizeRequests().and().formLogin()//
                   .loginPage("/login")//
                   .failureUrl("/login?error=true");
                 
                   

	}

}
