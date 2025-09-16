package security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import security.service.InMemoryService;
import security.user.User;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService2() {
        User user1 = new User("Bob","123","READ");

        User user2 = new User("Bill", "543", "WRITE");

        return new InMemoryService(
                List.of(
                        user1,
                        user2
                )
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder2() {
        return NoOpPasswordEncoder.getInstance();
    }

}
