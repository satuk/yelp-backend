package com.propulsion.yelp.web;

import com.propulsion.yelp.security.JWTAuthenticationFilter;
import com.propulsion.yelp.security.JWTLoginFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

/**
 * Created by satuk on 27.06.17.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    public void configure( WebSecurity web ) throws Exception {
//        web.ignoring().antMatchers( "/" );
    }
    
    @Override
    protected void configure( HttpSecurity http ) throws Exception {
        http
                .mvcMatcher( "/api/restaurants" )
                .authorizeRequests()
                .mvcMatchers( GET, "/api/restaurants/**" ).permitAll()
                .mvcMatchers( POST, "/api/restaurants" ).permitAll()
                .and()
                
                .mvcMatcher( "/api/users" )
                .authorizeRequests()
                .mvcMatchers( GET, "/api/users/**" ).permitAll()
                .and()
        
                .mvcMatcher( "/api/users/sign_up" )
                .authorizeRequests()
                .mvcMatchers( POST, "/api/users/sign_up/**" ).permitAll()
                .antMatchers( OPTIONS, "/api/users/sign_up/**" ).permitAll()
                .and()
                
                .mvcMatcher( "/api/reviews" )
                .authorizeRequests()
                .mvcMatchers( GET, "/api/reviews/**" ).permitAll()
                .and()
                
                .mvcMatcher( "/api/users/sign_in" )
                .authorizeRequests()
                .mvcMatchers( HttpMethod.POST, "/api/users/sign_in" ).permitAll()
                .anyRequest()
                .authenticated()
                .and()
//                 We filter the api/login requests
                .addFilterBefore( new JWTLoginFilter( "/api/users/sign_in/**", authenticationManager() ),
                        UsernamePasswordAuthenticationFilter.class )
                // And filter other requests to check the presence of JWT in header
                .addFilterBefore( new JWTAuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class )
                
                .mvcMatcher( "/**" )
                .authorizeRequests()
                .mvcMatchers( "/**" ).denyAll()
                .and()
                
                .sessionManagement()
                .sessionCreationPolicy( SessionCreationPolicy.STATELESS )
                .and()
                
                .csrf()
                .disable()
                
                .httpBasic();
    }
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            
            @Override
            public void addCorsMappings( CorsRegistry registry ) {
                registry.addMapping( "/**" );
            }
        };
    }
    
    @Override
    protected void configure( AuthenticationManagerBuilder auth ) throws Exception {
        // Create a default account
        auth.inMemoryAuthentication()
                .withUser( "admin" )
                .password( "password" )
                .roles( "ADMIN" );
    }
}
