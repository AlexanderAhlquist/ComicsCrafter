package com.ahlquist.comics_crafter.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.ahlquist.comics_crafter.service.UserService;
/*
 * This class configures the security of the website, allowing for the user to be registered
 * to the application. This means that the user must register and login before being allowed
 * to access the rest of the site. 
 */
@SuppressWarnings("deprecation")
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
   @Autowired
   private UserService userService;

   @Override
   protected void configure(HttpSecurity http) throws Exception {
       http
               .authorizeRequests()
                   .antMatchers(
                           "/registration**",
                           "/js/**",
                           "/css/**",
                           "/webjars/**").permitAll()
                   .anyRequest().authenticated()
               .and()
                   .formLogin()
                       .loginPage("/login")
                           .permitAll()
               .and()
                   .logout()
                       .invalidateHttpSession(true)
                       .clearAuthentication(true)
                       .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                       .logoutSuccessUrl("/login?logout")
               .permitAll();
   }

   @Bean
   public BCryptPasswordEncoder passwordEncoder(){
       return new BCryptPasswordEncoder();
   }

   @Bean
   public DaoAuthenticationProvider authenticationProvider(){
       DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
       auth.setUserDetailsService(userService);
       auth.setPasswordEncoder(passwordEncoder());
       return auth;
   }

   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.authenticationProvider(authenticationProvider());
   }

}