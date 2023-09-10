package site.abakar.sitepersowithspringmvc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import site.abakar.sitepersowithspringmvc.admin.repository.CompetencesRepository;
import site.abakar.sitepersowithspringmvc.admin.repository.EducationRepository;
import site.abakar.sitepersowithspringmvc.admin.repository.ExperiencesRepository;
import site.abakar.sitepersowithspringmvc.admin.repository.LangagesRepository;
import site.abakar.sitepersowithspringmvc.admin.service.AdminService;
import site.abakar.sitepersowithspringmvc.security.entites.AppUser;
import site.abakar.sitepersowithspringmvc.security.service.AccountService;

@SpringBootApplication
public class SitePersoWithSpringMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SitePersoWithSpringMvcApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    CommandLineRunner commandLineRunner(AccountService accountService,
                                        AdminService adminService){
        return args -> {
            accountService.createRole("ROOT");
            accountService.createUser("Abakar", "Abbas", "root@root.net", "root");
            accountService.addRoleToUser("ROOT", "root@root.net");

            adminService.createCompetence("Competence 1", "root@root.net");
            adminService.createCompetence("Competence 2", "root@root.net");
            adminService.createCompetence("Competence 3", "root@root.net");

            adminService.createEducation("ESP", "SN, Dakar", "Licence", "2021-2022", "Licence systeme reseau et telecommunication", "root@root.net");
            adminService.createEducation("ESP", "SN, Dakar", "DST TR", "2019-2021", "Diplome Superieur en reseau et telecommunication", "root@root.net");

            adminService.createExperience("Technicien systeme et reseau", "Mai 2021-Juin 2022", "RTN", "SN, Dakar", "Technicien reseau et systeme", "root@root.net");
            adminService.createExperience("Developpeur JAVA", "Avril 2023-Juin 2022", "Balxawmi group services", "SN, Dakar", "Developpeur JAVA", "root@root.net");
            adminService.createExperience("Administrateur systeme et reseau", "Juillet 2022 - Present", "Widia", "SN, Dakar", "Administrateur reseau et systeme", "root@root.net");

            adminService.createLangage("JAVA", "root@root.net");
            adminService.createLangage("HTML", "root@root.net");
            adminService.createLangage("CSS", "root@root.net");
            adminService.createLangage("PYTHON", "root@root.net");
            adminService.createLangage("ADMIN SYS", "root@root.net");
            adminService.createLangage("RUBY", "root@root.net");
            adminService.createLangage("TEST", "root@root.net");
        };
    }
}
