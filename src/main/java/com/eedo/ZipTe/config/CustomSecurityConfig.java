package com.eedo.ZipTe.config;

import com.eedo.ZipTe.security.filter.JWTCheckFilter;
import com.eedo.ZipTe.security.handler.APILoginFailHandler;
import com.eedo.ZipTe.security.handler.APILoginSuccessHandler;
import com.eedo.ZipTe.security.handler.CustomAccessDeniedHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class CustomSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .formLogin(login -> {
                    login
                            .loginPage("/api/member/login")
                            .successHandler(new APILoginSuccessHandler())
                            .failureHandler(new APILoginFailHandler());
                })

                .sessionManagement(session -> {
                    session.sessionCreationPolicy(SessionCreationPolicy.NEVER);
                })

                .cors(httpSecurityCorsConfigurer ->
                        httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource()))

                .csrf(csrf -> csrf.disable())
                .exceptionHandling(config->{
                    config.accessDeniedHandler(new CustomAccessDeniedHandler());

                })
                .addFilterBefore(new JWTCheckFilter(), UsernamePasswordAuthenticationFilter.class);
        ;

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true);
        config.setAllowedOrigins(List.of("http://localhost:3000"));
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
        config.setAllowedHeaders(List.of("*"));
        config.setExposedHeaders(List.of("*"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    };


}
