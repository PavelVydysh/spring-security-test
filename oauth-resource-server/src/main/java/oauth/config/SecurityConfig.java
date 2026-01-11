package oauth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Value("${key-set-uri}")
    private String keySetUri;

    private final JwtAuthenticationConverter converter;

    public SecurityConfig(JwtAuthenticationConverter converter) {
        this.converter = converter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.oauth2ResourceServer(
                c -> c.jwt(
                        jwt -> jwt.jwkSetUri(keySetUri)
                                .jwtAuthenticationConverter(converter)
                )
        );

        http.authorizeHttpRequests(
                c -> c.anyRequest().authenticated()
        );

        System.out.println(keySetUri);

        return http.build();
    }

}
