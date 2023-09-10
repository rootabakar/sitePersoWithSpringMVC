package site.abakar.sitepersowithspringmvc.security.service;

import site.abakar.sitepersowithspringmvc.security.entites.AppRole;
import site.abakar.sitepersowithspringmvc.security.entites.AppUser;

public interface AccountService {
    AppUser createUser(String nom, String prenom, String email, String password);
    AppRole createRole(String nom);
    void addRoleToUser(String role, String email);
    AppUser loadUserByEmail(String email);
}
