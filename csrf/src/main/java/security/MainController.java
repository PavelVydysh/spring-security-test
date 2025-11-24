package security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/main")
    public String main() {
        return "main.html";
    }

    @PostMapping("/products")
    public String addProduct() {
        System.out.println("plus 1 product");
        return "main.html";
    }

}
