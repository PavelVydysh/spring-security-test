package security.controller;

import jakarta.servlet.Filter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    public HomeController(List<Filter> filters) {
        for (Filter filter : filters) {
            System.out.println(filter.getClass().getName());
        }
    }

    @GetMapping
    public String home() {
        return "home index";
    }

}
