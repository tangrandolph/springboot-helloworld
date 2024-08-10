package ct.ariel.helloworld.taco;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TacoController {

    @GetMapping("/taco/home")
    public String home() {
        return "taco_home";
    }
}
