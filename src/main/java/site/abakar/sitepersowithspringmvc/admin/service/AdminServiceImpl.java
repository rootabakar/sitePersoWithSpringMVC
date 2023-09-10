package site.abakar.sitepersowithspringmvc.admin.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.abakar.sitepersowithspringmvc.admin.entites.Competences;
import site.abakar.sitepersowithspringmvc.admin.entites.Educations;
import site.abakar.sitepersowithspringmvc.admin.entites.Experiences;
import site.abakar.sitepersowithspringmvc.admin.entites.Langages;
import site.abakar.sitepersowithspringmvc.admin.repository.CompetencesRepository;
import site.abakar.sitepersowithspringmvc.admin.repository.EducationRepository;
import site.abakar.sitepersowithspringmvc.admin.repository.ExperiencesRepository;
import site.abakar.sitepersowithspringmvc.admin.repository.LangagesRepository;
import site.abakar.sitepersowithspringmvc.security.entites.AppUser;
import site.abakar.sitepersowithspringmvc.security.repository.AppUserRepository;

import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    CompetencesRepository competencesRepository;
    EducationRepository educationRepository;
    ExperiencesRepository experiencesRepository;
    LangagesRepository langagesRepository;
    AppUserRepository appUserRepository;

    @Override
    public List<Competences> listeCompetence() {
        return competencesRepository.findAll();
    }

    @Override
    public Competences createCompetence(String nom, String email) {
        AppUser appUser = appUserRepository.findAppUserByEmail(email);
        return competencesRepository.save(
                Competences.builder()
                        .id(null)
                        .nom(nom)
                        .appUser(appUser)
                        .build()
                );
    }

    @Override
    public Competences alterCompetence(Long id, String nom) {
        Competences competence = competencesRepository.findById(id).get();
        competence.setNom(nom);
        return competencesRepository.save(competence);
    }

    @Override
    public void deleteCompetence(Long id) {
        competencesRepository.deleteById(id);
    }

    @Override
    public List<Langages> listeLangage() {
        return langagesRepository.findAll();
    }

    @Override
    public Langages createLangage(String nom, String email) {
        AppUser appUser = appUserRepository.findAppUserByEmail(email);
        return langagesRepository.save(
                Langages.builder()
                        .id(null)
                        .nom(nom)
                        .appUser(appUser)
                        .build()
        );
    }

    @Override
    public Langages alterLangage(Long id, String nom) {
        Langages langage = langagesRepository.findById(id).get();
        langage.setNom(nom);
        return langagesRepository.save(langage);
    }

    @Override
    public void deleteLangage(Long id) {
        langagesRepository.deleteById(id);
    }

    @Override
    public List<Educations> listeEducation() {
        return educationRepository.findAll();
    }

    @Override
    public Educations createEducation(String nomEcole, String paysVille, String niveauEtude, String date, String description, String email) {
        AppUser appUser = appUserRepository.findAppUserByEmail(email);
        return educationRepository.save(
                Educations.builder()
                        .id(null)
                        .nomEcole(nomEcole)
                        .paysVille(paysVille)
                        .niveauEtude(niveauEtude)
                        .date(date)
                        .description(description)
                        .appUser(appUser)
                        .build()
        );
    }

    @Override
    public Educations alterEducation(String nomEcole, String paysVille, String niveauEtude, String date, String description, String email, Long id) {
        AppUser appUser = appUserRepository.findAppUserByEmail(email);
        Educations education = educationRepository.findById(id).get();
        education.setNomEcole(nomEcole);
        education.setPaysVille(paysVille);
        education.setNiveauEtude(niveauEtude);
        education.setDate(date);
        education.setDescription(description);
        education.setAppUser(appUser);
        return educationRepository.save(education);
    }

    @Override
    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);
    }

    @Override
    public List<Experiences> listExperience() {
        return experiencesRepository.findAll();
    }

    @Override
    public Experiences createExperience(String nomPoste, String date, String nomEntreprise, String paysVille, String description, String email) {
        AppUser appUser = appUserRepository.findAppUserByEmail(email);
        return experiencesRepository.save(
                Experiences.builder()
                        .id(null)
                        .nomPoste(nomPoste)
                        .date(date)
                        .nomEntreprise(nomEntreprise)
                        .paysVille(paysVille)
                        .description(description)
                        .appUser(appUser)
                        .build()
        );
    }

    @Override
    public Experiences alterExperience(Long id, String nomPoste, String date, String nomEntreprise, String paysVille, String description, String email) {
        Experiences experience = experiencesRepository.findById(id).get();
        AppUser appUser = appUserRepository.findAppUserByEmail(email);
        experience.setNomPoste(nomPoste);
        experience.setDate(date);
        experience.setNomEntreprise(nomEntreprise);
        experience.setPaysVille(paysVille);
        experience.setDescription(description);
        experience.setAppUser(appUser);
        return experiencesRepository.save(experience);
    }

    @Override
    public void deleteExperience(Long id) {
        experiencesRepository.deleteById(id);
    }
}
