package fi.hh.server.CosmeticShop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import fi.hh.server.CosmeticShop.web.UserDetailServiceImpl;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
    private UserDetailServiceImpl userDetailService;	
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		 http
	        .authorizeRequests().antMatchers("/", "/css/**", "/images/**", "/mainpage").permitAll() 
	        .and()
	        .authorizeRequests()	 
	          .anyRequest().authenticated()
	          .and()
	      .formLogin()
	          .loginPage("/login")
	          .defaultSuccessUrl("/home")
	          .permitAll()
	          .and()
	      .logout()
	          .permitAll();
	    }
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
        .userDetailsService(userDetailService).passwordEncoder(new BCryptPasswordEncoder());
    }
}

