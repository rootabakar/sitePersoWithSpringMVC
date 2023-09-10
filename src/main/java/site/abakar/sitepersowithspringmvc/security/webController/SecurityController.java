package site.abakar.sitepersowithspringmvc.security.webController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/err-403")
    public String err_403(){
        return "err_403";
    }

}
