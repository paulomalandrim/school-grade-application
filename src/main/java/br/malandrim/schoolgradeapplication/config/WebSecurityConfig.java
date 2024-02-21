package br.malandrim.schoolgradeapplication.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .authorizeHttpRequests(
                        authorizeConfig -> {
                            authorizeConfig.requestMatchers("/logout", "/login").permitAll();
                            authorizeConfig.requestMatchers("/h2-console/**").permitAll();
                            authorizeConfig.requestMatchers("/api/v1/students").hasAnyRole("USER");
                            authorizeConfig.requestMatchers("/api/v1/grades").hasAnyRole("USER");
                            authorizeConfig.requestMatchers("/api/v1/subjects").hasAnyRole("USER");
                            authorizeConfig.requestMatchers("/api/v1/teachers").hasAnyRole("USER");
                            authorizeConfig.anyRequest().hasAnyRole("ADMIN");
                        })
                //.formLogin(Customizer.withDefaults())
                .headers(AbstractHttpConfigurer::disable)
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**"))

                .build();
    }

}