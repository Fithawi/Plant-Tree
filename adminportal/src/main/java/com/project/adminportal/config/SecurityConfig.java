package com.project.adminportal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.project.adminportal.utility.SecurityUtility;
import com.project.adminportal.service.impl.UserSecurityService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
@Autowired
private Environment env;

@Autowired
private UserSecurityService userSecurityService;

private BCryptPasswordEncoder passwordEncoder() {
	
	return SecurityUtility.passwordEncoder();
}
private static final String[] PUBLIC_MATCHERS= {
		/* "/resources/**", */
		  "/css/**", 
		  "/js/**",
		  "/all/**",
		  "/image/**",
		  "/imag/**",
		  "static/imag/upload/**",
		 
		/*
		 * "/image/*.jpg", "/image/*.png",
		 */
		/*
		 * "/newUser", "/forgetPassword",
		 */
		  "/login",
		  "/addPlant",
		  "/home",
		  "/common/**",
		  "/plantList",
		  "/"
		
};
@Override
protected void configure(HttpSecurity http)throws Exception{
	http
	.authorizeRequests().
	antMatchers(HttpMethod.GET,PUBLIC_MATCHERS).
	permitAll().anyRequest().authenticated();
	
	http
	.csrf().disable().cors().disable()
	.formLogin().failureUrl("/login?error")
	.defaultSuccessUrl("/") 
	.loginPage("/login").permitAll()
	.and()
	.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	.logoutSuccessUrl("/?logout").deleteCookies("Remember-me").permitAll()
	.and()
	.rememberMe();
	
	
}
@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
	auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncoder());
	
}
}
