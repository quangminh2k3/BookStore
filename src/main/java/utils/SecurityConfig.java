package utils;


import com.bookstore.entity.CustomUserDetail;
import com.bookstore.services.CustomUserDetailServices;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.PasswordAuthentication;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity

public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailServices();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetailsService());
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
}
