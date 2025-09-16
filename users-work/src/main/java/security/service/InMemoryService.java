package security.service;

import jakarta.annotation.PostConstruct;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class InMemoryService implements UserDetailsService {

    private final List<UserDetails> users;

    public InMemoryService(List<UserDetails> users) {
        this.users = users;
    }

    @PostConstruct
    private void postConstruct() {
        System.out.println("InMemoryService in use");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.stream()
                .filter(
                        u -> username.equals(u.getUsername())
                )
                .findFirst()
                .orElseThrow(
                        () -> new UsernameNotFoundException("No such user")
                );
    }
}
