package com.example.ro36school.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class Ro36WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService ro36UserDetailService;
    private final PasswordEncoder ro36PasswordEncoder;

    public Ro36WebSecurityConfig(UserDetailsService ro36UserDetailService, PasswordEncoder ro36PasswordEncoder) {
        this.ro36UserDetailService = ro36UserDetailService;
        this.ro36PasswordEncoder = ro36PasswordEncoder;
    }

    //configureaza partea de autorizare pentru acces  la pagini
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                //ca sa putem face coluri in frontend
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/info").permitAll()
                .antMatchers("/api/students/signup").permitAll()
                .anyRequest().authenticated().and().httpBasic();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        DaoAuthenticationProvider ro36AuthenticationProvider = new DaoAuthenticationProvider();
        ro36AuthenticationProvider.setPasswordEncoder(ro36PasswordEncoder);
        ro36AuthenticationProvider.setUserDetailsService(ro36UserDetailService);
        //foloseste authenticationProvider -ul creat de mine, care e customizat cu clasele de care are aplicatia nevoie
        authenticationManagerBuilder.authenticationProvider(ro36AuthenticationProvider);
    }
}
