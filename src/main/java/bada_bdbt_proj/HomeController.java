package bada_bdbt_proj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller

public class HomeController {

    @RequestMapping("/")
    public String homePage1() {
        return "index"; // Returns the `index.html` page
    }

    @RequestMapping("/test")
    public String testPage() {
        return "test"; // Returns the `test.html` page
    }

}
