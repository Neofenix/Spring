package com.platzi.ereservation.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Manages project security
 * @author csar
 */
@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and().formLogin()
                .loginPage("/app/login").permitAll()
                .failureUrl("/app/login?error=true")
                .defaultSuccessUrl("/app/home");
    }

    //Configurar el método de autentificación, para lo cual utilizamos un método en memoria.
    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        builder.inMemoryAuthentication()
                .withUser("platzi")
                .password(encoder.encode("platzi"))
                .roles("USER");
    }

    //Configurar qué rutas de la aplicación se deben excluir del proceso de login, en la cual están todos los recursos estáticos configurados anteriormente.
    @Override
    public void configure(WebSecurity security) {
        security.ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }
}