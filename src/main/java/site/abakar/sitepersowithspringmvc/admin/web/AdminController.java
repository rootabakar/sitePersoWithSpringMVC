package site.abakar.sitepersowithspringmvc.admin.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import site.abakar.sitepersowithspringmvc.admin.entites.Competences;
import site.abakar.sitepersowithspringmvc.admin.entites.Educations;
import site.abakar.sitepersowithspringmvc.admin.entites.Experiences;
import site.abakar.sitepersowithspringmvc.admin.entites.Langages;
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
        Competences competence = adminService.createCompetence(nom, principal.getName());
        redirectAttributes.addFlashAttribute("done", "Competence ajouter avec succes");
        return "redirect:/admin/competence";
    }

    @PostMapping("/competence/alter/{id}")
    public String competence_alter(RedirectAttributes redirectAttributes,
                                   @PathVariable("id") Long id,
                                   @RequestParam("nom") String nom){
        adminService.alterCompetence(id, nom);
        redirectAttributes.addFlashAttribute("done_mo", "Competence modifer avec succes ");
        return "redirect:/admin/competence";
    }

    @PostMapping("/competence/delete/{id}")
    public String competence_suppression(RedirectAttributes redirectAttributes,
                                         @PathVariable("id") Long id){
        adminService.deleteCompetence(id);
        redirectAttributes.addFlashAttribute("done_sup", "Competence supprimer avec succes ");
        return "redirect:/admin/competence";
    }

    @GetMapping("/education")
    public String education(Model model){
        List<Educations> educations = adminService.listeEducation();
        model.addAttribute("educations", educations);
        return "/admin/education";
    }

    @PostMapping("/education/add")
    public String education_add(@RequestParam("nomEcole") String nomEcole,
                                @RequestParam("paysVille") String paysVille,
                                @RequestParam("niveauEtude") String niveauEtude,
                                @RequestParam("date") String date,
                                @RequestParam("description") String description,
                                Principal principal, RedirectAttributes redirectAttributes){
        adminService.createEducation(nomEcole, paysVille, niveauEtude, date, description, principal.getName());
        redirectAttributes.addFlashAttribute("done", "Education ajouter avec succes ");
        return "redirect:/admin/education";
    }

    @PostMapping("/education/alter/{id}")
    public String education_alter(@PathVariable("id") Long id,
                                  @RequestParam("nomEcole") String nomEcole,
                                  @RequestParam("paysVille") String paysVille,
                                  @RequestParam("niveauEtude") String niveauEtude,
                                  @RequestParam("date") String date,
                                  @RequestParam("description") String description,
                                  RedirectAttributes redirectAttributes,
                                  Principal principal){
        adminService.alterEducation(nomEcole, paysVille, niveauEtude, date, description, principal.getName(), id);
        redirectAttributes.addFlashAttribute("done", "Element modifier avec succes ");
        return "redirect:/admin/education";
    }

    @PostMapping("/education/delete/{id}")
    public String education_delete(@PathVariable("id") Long id,
                                   RedirectAttributes redirectAttributes){
        adminService.deleteEducation(id);
        redirectAttributes.addFlashAttribute("done", "Element a ete supprimer avec succes ");
        return "redirect:/admin/education";
    }


    @GetMapping("/experience")
    public String experience(Model model){
        List<Experiences> experiences = adminService.listExperience();
        model.addAttribute("experiences", experiences);
        return "admin/experience";
    }

    @PostMapping("/experience/add")
    public String experience_add(@RequestParam("nomPoste") String nomPoste,
                                 @RequestParam("date") String date,
                                 @RequestParam("nomEntreprise") String nomEntreprise,
                                 @RequestParam("paysVille") String paysVille,
                                 @RequestParam("description") String description,
                                 RedirectAttributes redirectAttributes,
                                 Principal principal){
        adminService.createExperience(nomPoste, date, nomEntreprise, paysVille, description, principal.getName());
        redirectAttributes.addFlashAttribute("done", "Element ajouter avec succes");
        return "redirect:/admin/experience";
    }

    @PostMapping("/experience/alter/{id}")
    public String experience_alter(@RequestParam("nomPoste") String nomPoste,
                                   @RequestParam("date") String date,
                                   @RequestParam("nomEntreprise") String nomEntreprise,
                                   @RequestParam("paysVille") String paysVille,
                                   @RequestParam("description") String description,
                                   @PathVariable("id") Long id,
                                   Principal principal,
                                   RedirectAttributes redirectAttributes){
        adminService.alterExperience(id, nomPoste, date, nomEntreprise, paysVille, description, principal.getName());
        redirectAttributes.addFlashAttribute("done", "Element modifier avec succes");
        return "redirect:/admin/experience";
    }

    @PostMapping("/experience/delete/{id}")
    public String experience_delete(@PathVariable Long id,
                                    RedirectAttributes redirectAttributes){
        adminService.deleteExperience(id);
        redirectAttributes.addFlashAttribute("done", "Element supprimer avec succes");
        return "redirect:/admin/experience";
    }

    @GetMapping("/langage")
    public String langage(Model model){
        List<Langages> langages = adminService.listeLangage();
        model.addAttribute("langages", langages);
        return "/admin/langage";
    }

    @PostMapping("/langage/add")
    public String langage_add(@RequestParam("nom") String nom,
                              Principal principal,
                              RedirectAttributes redirectAttributes){
        adminService.createLangage(nom, principal.getName());
        redirectAttributes.addFlashAttribute("done", "Element ajouter avec succes ");
        return "redirect:/admin/langage";
    }

    @PostMapping("/langage/alter/{id}")
    public String langage_alter(@PathVariable Long id,
                                @RequestParam("nom") String nom,
                                RedirectAttributes redirectAttributes){
        adminService.alterLangage(id, nom);
        redirectAttributes.addFlashAttribute("done_mo", "Element modifier avec succes");
        return "redirect:/admin/langage";
    }

    @PostMapping("/langage/delete/{id}")
    public String langage_delete(@PathVariable Long id,
                                 RedirectAttributes redirectAttributes){
        adminService.deleteLangage(id);
        redirectAttributes.addFlashAttribute("done_sup", "Element supprimer avec succes");
        return "redirect:/admin/langage";
    }

}
