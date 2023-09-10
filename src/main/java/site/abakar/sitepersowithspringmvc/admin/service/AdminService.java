package site.abakar.sitepersowithspringmvc.admin.service;

import site.abakar.sitepersowithspringmvc.admin.entites.Competences;
import site.abakar.sitepersowithspringmvc.admin.entites.Educations;
import site.abakar.sitepersowithspringmvc.admin.entites.Experiences;
import site.abakar.sitepersowithspringmvc.admin.entites.Langages;

import java.util.List;

public interface AdminService {
    List<Competences> listeCompetence();
    Competences createCompetence(String nom, String email);
    Competences alterCompetence(Long id, String nom);
    void deleteCompetence(Long id);
    List<Langages> listeLangage();
    Langages createLangage(String nom, String email);
    Langages alterLangage(Long id, String nom);
    void deleteLangage(Long id);
    List<Educations> listeEducation();
    Educations createEducation(String nomEcole, String paysVille, String niveauEtude, String date, String description, String email);
    Educations alterEducation(String nomEcole, String paysVille, String niveauEtude, String date, String description, String email, Long id);
    void deleteEducation(Long id);
    List<Experiences> listExperience();
    Experiences createExperience(String nomPoste, String date, String nomEntreprise, String paysVille, String description, String email);
    Experiences alterExperience(Long id, String nomPoste, String date, String nomEntreprise, String paysVille, String description, String email);
    void deleteExperience(Long id);
}
