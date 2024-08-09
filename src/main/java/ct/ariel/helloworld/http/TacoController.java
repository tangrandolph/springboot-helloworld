package ct.ariel.helloworld.http;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TacoController {

    @GetMapping("/taco/home")
    public String home() {
        return "taco_home";
    }
}
