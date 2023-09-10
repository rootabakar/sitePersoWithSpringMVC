package site.abakar.sitepersowithspringmvc.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String index(){
        return "app/index";
    }

    @GetMapping("/contact")
    public String contact(){
        return "app/contact";
    }

    @GetMapping("/resume")
    public String resume(){
        return "app/resume";
    }

    @GetMapping("/projects")
    public String projects(){
        return "app/projects";
    }


}
