package site.abakar.sitepersowithspringmvc.security.config;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import site.abakar.sitepersowithspringmvc.security.entites.AppUser;
import site.abakar.sitepersowithspringmvc.security.service.AccountService;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser = accountService.loadUserByEmail(email);
        if (appUser == null) throw new UsernameNotFoundException("L'utilisateur n'existe pas ");
        String[] roles = appUser.getRoles().stream().map(u -> u.getNom()).toArray(String[]::new);
        return User.withUsername(appUser.getEmail())
               .password(appUser.getPassword())
                .roles(roles)
               .build();
    }
}
