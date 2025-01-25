package bada_bdbt_proj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping
    public String test() {
        return "Application is running!";
    }
}
