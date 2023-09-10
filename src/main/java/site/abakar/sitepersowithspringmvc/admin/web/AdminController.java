package site.abakar.sitepersowithspringmvc.admin.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import site.abakar.sitepersowithspringmvc.admin.entites.Competences;
import site.abakar.sitepersowithspringmvc.admin.service.AdminService;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    AdminService adminService;

    @GetMapping("/")
    public String index(){
        return "admin/index";
    }

    @GetMapping("/competence")
    public String competence(Model model){
        List<Competences> competences = adminService.listeCompetence();
        model.addAttribute("competences", competences);
        return "admin/competence";
    }

    @PostMapping("/competence/add")
    public String competence_add(RedirectAttributes redirectAttributes,
                                 @RequestParam("nom") String nom,
                                 Principal principal){
        adminService.createCompetence(nom, principal.getName());
        redirectAttributes.addFlashAttribute("done", "Competence ajouter avec succes");
        return "redirect:/admin/";
    }

    @GetMapping("/education")
    public String education(Model model){
        model.addAttribute("educations", adminService.listeEducation());
        return "admin/education";
    }

    @GetMapping("/experience")
    public String experience(Model model){
        model.addAttribute("experience", adminService.listExperience());
        return "admin/experience";
    }

    @GetMapping("/langage")
    public String langage(Model model){
        model.addAttribute("langages", adminService.listeLangage());
        return "/admin/langage";
    }

}
