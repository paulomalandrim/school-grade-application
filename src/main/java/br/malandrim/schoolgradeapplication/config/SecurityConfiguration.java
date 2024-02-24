package br.malandrim.schoolgradeapplication.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        String[] devList = {
                "/h2-console/**",
                "/swagger-ui*/**",
                "/api/v1/auth/login",
                "/api/v1/auth/register"  // somente a titulo de teste em prod não deveria ficar aberto...
        };

        return http
                .headers(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> {
                    //auth.requestMatchers(devList).hasAnyRole("ADMIN","DEV"); // PROD
                    auth.requestMatchers(devList).permitAll(); // TEST
                    auth.requestMatchers("/api/v1/students").hasAnyRole("ADMIN","USER");
                    auth.requestMatchers("/api/v1/grades").hasAnyRole("ADMIN","USER");
                    auth.requestMatchers("/api/v1/subjects").hasAnyRole("ADMIN","USER");
                    auth.requestMatchers("/api/v1/teachers").hasAnyRole("ADMIN","USER");
                    auth.anyRequest().authenticated();
                })
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration auth) throws Exception {
        return auth.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}