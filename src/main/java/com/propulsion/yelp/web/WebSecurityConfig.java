package com.propulsion.yelp.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import static org.springframework.http.HttpMethod.GET;

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
                .mvcMatcher( "/api/**" )
                .authorizeRequests()
                .mvcMatchers( GET, "/api/restaurants/**" ).permitAll()
                .and()
                
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
}
