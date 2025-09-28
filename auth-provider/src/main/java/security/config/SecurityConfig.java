package security.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import security.entry.CustomAuthenticationEntryPoint;

import java.util.List;
import java.util.UUID;

//@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationProvider provider) throws Exception{
        http.httpBasic(c -> c.authenticationEntryPoint(new CustomAuthenticationEntryPoint()));
        http.authenticationProvider(provider);
        http.authorizeHttpRequests(c -> c.anyRequest().authenticated());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        String password = UUID.randomUUID().toString();

        UserDetails user = User.withUsername("Bob")
                .password(password)
                .build();

        System.out.println(password);

        return new InMemoryUserDetailsManager(List.of(user));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

//    @Bean
//    public InitializingBean init() {
//        return () -> SecurityContextHolder.setStrategyName(
//                SecurityContextHolder.MODE_INHERITABLETHREADLOCAL
//        );
//    }

}
