package com.freshbell.myspringproject.global.config

import com.freshbell.myspringproject.global.jwt.JwtAuthenticationFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter

@EnableMethodSecurity
@Configuration
class SecurityConfig(private val jwtAuthenticationFilter: JwtAuthenticationFilter) {
    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()
    @Bean
    fun filterChain(http:HttpSecurity) = http
            .csrf { it.disable() }
            .headers { it.frameOptions { frameOptions -> frameOptions.sameOrigin() } }
            .authorizeHttpRequests {
                it.requestMatchers("/", "/swagger-ui/**", "/v3/**").permitAll()
                        .anyRequest().authenticated()
            }
            .addFilterBefore(jwtAuthenticationFilter, BasicAuthenticationFilter::class.java)
            .build();
}