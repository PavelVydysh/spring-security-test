package security.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public void home() {
        SecurityContext context = SecurityContextHolder.getContext();

        System.out.println(SecurityContextHolder.getContextHolderStrategy().getClass());

        Authentication authentication = context.getAuthentication();
        System.out.println(authentication.getPrincipal());

    }

}
