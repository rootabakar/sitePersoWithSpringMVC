package site.abakar.sitepersowithspringmvc.security.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.abakar.sitepersowithspringmvc.security.entites.AppRole;
import site.abakar.sitepersowithspringmvc.security.entites.AppUser;
import site.abakar.sitepersowithspringmvc.security.repository.AppRoleRepository;
import site.abakar.sitepersowithspringmvc.security.repository.AppUserRepository;
import java.util.ArrayList;

@AllArgsConstructor
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public AppUser createUser(String nom, String prenom, String email, String password) {
        AppUser appUser = appUserRepository.findAppUserByEmail(email);
        if (appUser!=null){
            throw new RuntimeException("L'utilisateur existe deja");
        }else{
            return appUserRepository.save(
                    AppUser.builder()
                    .id(null)
                    .prenom(prenom)
                    .nom(nom)
                    .email(email)
                    .password(passwordEncoder.encode(password))
                    .roles(new ArrayList<AppRole>())
                    .build()
            );
        }
    }

    @Override
    public AppRole createRole(String nom) {
        AppRole appRole = appRoleRepository.findAppRoleByNom(nom);
        if (appRole != null) throw new RuntimeException("Le role existe deja ");
        return appRoleRepository.save(AppRole.builder()
                .id(null)
                .nom(nom)
                .build()
        );
    }

    @Override
    public void addRoleToUser(String role, String email) {
        AppUser appUser = appUserRepository.findAppUserByEmail(email);
        AppRole appRole = appRoleRepository.findAppRoleByNom(role);
        if (appUser == null) throw new RuntimeException("L'utilisateur n'existe pas ");
        if (appRole == null) throw new RuntimeException("Le role n'existe pas");
        appUser.getRoles().add(appRole);
        appUserRepository.save(appUser);
    }

    @Override
    public AppUser loadUserByEmail(String email) {
        AppUser appUser = appUserRepository.findAppUserByEmail(email);
        if (appUser==null) throw new RuntimeException("L'utilisateur n'existe pas ");
        return appUser;
    }
}
