package security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/home")
    public String csrf() {
        return "csrf";
    }

    @PostMapping("/disabled")
    public String disabled() {
        return "disabled";
    }

}
